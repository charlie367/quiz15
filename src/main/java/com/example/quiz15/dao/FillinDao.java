package com.example.quiz15.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.quiz15.entity.Fillin;
import com.example.quiz15.entity.FillinId;
import com.example.quiz15.vo.QuestionAnswerDto;
import com.example.quiz15.vo.UserVo;

import jakarta.transaction.Transactional;

public interface FillinDao extends JpaRepository<Fillin, FillinId> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO fillin (quiz_id, question_id, email, answer, fillin_date) "
			+ "VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	int insert(int quizId, int questionId, String email, String answer, LocalDate now);

	@Query(value = "select count(email) from fillin where quiz_id = ?1 and email = ?2", //
			nativeQuery = true)
	public int selectCountByQuizAndEmail(int quizId, String email);

	/**
	 * 1. 當 select 的欄位無法只用特定的一張表(或是裝載資料的 Entity) 來裝載資料時，nativeQuery 要變成 false </br>
	 * 2. nativeQuery = false 時，SQL語法中 <br>
	 * 2.1. select 的欄位名稱會變成各個 Entity class 中的屬性變數名稱 <br>
	 * 2.2. on 後面的欄位名稱是 Entity class 中的屬性變數名稱<br>
	 * 2.3. 表的名稱會變成 Entity class 名稱 <br>
	 * 2.4. select 後面的欄位要透過 new 建構方法的方式來塞值，UserVo 中也要有對應的建構方法<br>
	 * 2.5. UserVo 要給定完整的路徑: com.example.quiz15.vo.UserVo // * 3. select distinct :
	 * 將 selec出的所有欄位值，重複的結果于以刪除，只保留一筆資料 4. U.變數名稱: 語法中U. 後面的變數名稱，是要看 User 這個 class
	 * 的變數名稱，而非 UserVo 中的變數名稱， 因為是 from User as U
	 */
	@Query(value = "select distinct new com.example.quiz15.vo.UserVo("//
			+ "U.name, U.email, U.phone, U.age, F.fillinDate) from User as U " //
			+ "join Fillin as F on U.email = F.email where F.quizId = ?1", //
			nativeQuery = false)
	public List<UserVo> selectUserVoList(int quizId);

	/**
	 * 要確保右表不匹配的資料(null)被呈現，要將右表的過濾條件移至 on 之後 left
	 * join左連接代表「全部撈左邊（Question）的資料，不管右邊（Fillin）有沒有配對的資料都會撈出來」
	 * 如果右邊（Fillin）有對應資料就一起帶出，沒有的話右邊欄位會是 null 抓這份問卷的所有題目，即使這個人沒作答，也要出現在結果裡
	 * Qu.questionId = F.questionId 題號要一樣，一題對一答 
	 * F.quizId = ?1 同一份問卷（保險起見） F.email =
	 * ?2 同一個使用者的作答
	 */
	@Query(value = "select new com.example.quiz15.vo.QuestionAnswerDto(" //
			+ " Qu.questionId, Qu.question, Qu.type, Qu.required, F.answer)" //
			+ " from Question as Qu left join Fillin as F "//
			+ " on Qu.questionId = F.questionId and F.quizId = ?1 and F.email = ?2"//
			+ " where Qu.quizId = ?1", //	
			nativeQuery = false)
	public List<QuestionAnswerDto> selectQuestionAnswerList(int quizId, String email);

	@Query(value = "select new com.example.quiz15.vo.QuestionAnswerDto(" //
			+ " Qu.questionId, Qu.question, Qu.type, Qu.required, F.answer)" //
			+ " from Question as Qu  join Fillin as F "//
			+ " on Qu.questionId = F.questionId and F.quizId = ?1 "//
			+ " where Qu.quizId = ?1", //
			nativeQuery = false)
	public List<QuestionAnswerDto> selectQuestionAnswerList(int quizId);

}
