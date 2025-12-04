package com.example.quiz15.vo;

import java.util.ArrayList;
import java.util.List;

import com.example.quiz15.constants.ContantsMessage;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class  QuestionIdAnswerVo {

	// 此 class 將問題編號和
	private int questionId;
	
//	// answerList 的預設值會從 null 變成 空的List
//	@Min(value = 1, message = ContantsMessage.QUIZ_ID_ERROR)
	@NotNull(message = "答案不得為空")
	@Size(min = 1, message = "請至少選擇一個答案")
	private List<String> answerList = new ArrayList<>();

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public List<String> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<String> answerList) {
		this.answerList = answerList;
	}
}
