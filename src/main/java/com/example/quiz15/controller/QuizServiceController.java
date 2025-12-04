package com.example.quiz15.controller;

import java.lang.annotation.Repeatable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz15.Service.ifs.QuizService;
import com.example.quiz15.constants.ResCodeMessage;
import com.example.quiz15.dao.QuizDao;
import com.example.quiz15.entity.Question;
import com.example.quiz15.entity.Quiz;
import com.example.quiz15.vo.BasicRes;
import com.example.quiz15.vo.FeedbackRes;
import com.example.quiz15.vo.FeedbackUserRes;
import com.example.quiz15.vo.FillinReq;
import com.example.quiz15.vo.QuizCreateReq;
import com.example.quiz15.vo.QuizUpdateReq;
import com.example.quiz15.vo.SearchReq;
import com.example.quiz15.vo.SearchRes;
import com.example.quiz15.vo.StatisticsRes;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true")
public class QuizServiceController {

	@Autowired
	private QuizService quizService;
	
	// 假設只有登入成功之後才能使用 quizService.create
	@PostMapping("/quiz/create")
	public BasicRes create(@Valid @RequestBody QuizCreateReq req, HttpSession session) throws Exception{
		BasicRes checkRes = checkLogin(session);
		  if(checkRes != null) {
			  return checkRes;
		  }
		return quizService.create(req);
	}
	
	public BasicRes checkLogin(HttpSession session) {
		// 檢查 session 是否有存 email 的資訊
		String savedEmail = (String) session.getAttribute("email");
		//若 savedEmail 是 null，返回請先登入訊息
		if(savedEmail == null) {
			return new BasicRes(ResCodeMessage.PLEASE_LOGIN_FIRST.getCode(),
					ResCodeMessage.PLEASE_LOGIN_FIRST.getMessage());
		}
		// 若 savedEmail 不是 null，表示已登入成功，回傳null
	return null;
	}
	
	// 假設只有登入成功之後才能使用 quizService.create
//	@PostMapping("/quiz/update")
//	public BasicRes update(@Valid @RequestBody QuizUpdateReq req, HttpSession session) throws Exception{
//	  BasicRes checkRes = checkLogin(session);
//	  if(checkRes!= null) {
//		  return checkRes;
//	  }
//	  return quizService.update(req);
//	}

//	@PostMapping("/quiz/update")
//	public BasicRes update(@Valid @RequestBody QuizUpdateReq req) throws Exception{
//		return quizService.update(req);
//	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/quiz/all")
	public SearchRes getAll() {
	    return quizService.getAllQuizs();
	}
	
//	@PutMapping("/quiz/update/{id}")
//	public BasicRes update(@PathVariable("id") int id,
//	                       @Valid @RequestBody QuizUpdateReq req) throws Exception {
//	    req.setQuizId(id);  // 把前端傳來的路徑參數 id 放進去
//	    return quizService.update(req);
//	}
	@PutMapping("/quiz/update/{id}")
	public BasicRes update(@PathVariable("id") int id,
	                       @Valid @RequestBody QuizUpdateReq req,
	                       HttpSession session) throws Exception {                 // ★多帶 session
	    BasicRes checkRes = checkLogin(session);                                  // ★補這兩行
	    if (checkRes != null) return checkRes;

	    req.setQuizId(id);
	    return quizService.update(req);
	}
	  
	  @DeleteMapping("/quiz/delete/{id}")
	  public BasicRes delete(@PathVariable("id") int id) {
	      return quizService.deleteQuiz(id);
	  }
	  @PostMapping(value ="/quiz/fillin")
	  public BasicRes fillin(@Valid @RequestBody FillinReq req)throws Exception {
		  return quizService.fillin(req);
	  }
	  
	  @GetMapping(value ="/quiz/feedback_user_list")
	  public FeedbackUserRes  feedbackUserList(@RequestParam("quizId")int quizId) {
		  return quizService.feedbackUserList(quizId);
	  }
	  	@PostMapping(value ="/quiz/feedback")
		 public FeedbackRes feedback(@RequestParam("quizId") int quizId, //
				 @RequestParam("email") String email) {
	  		return quizService.feedback(quizId,email);
	  	}
//	  	@PostMapping(value ="/quiz/statistics")
//		 public StatisticsRes statistics(@RequestParam("quizId")int quizId) {
//	  		return quizService.statistics(quizId);
//	  	}
	  	@CrossOrigin(origins = "http://localhost:4200")
	  	@GetMapping("/quiz/{quizId}/statistics")
	  	public StatisticsRes statistics(@PathVariable("quizId") int quizId) {
	  	    return quizService.statistics(quizId);
	  	}
	  	
	  
//	  @PostMapping("/quiz/search")
//	  public SearchRes search(@RequestBody SearchReq req) {
//		  return quizService.search(req);
//	  }
	  	
	  	
	
}

