package com.example.quiz15.vo;

import java.util.List;

import com.example.quiz15.constants.ContantsMessage;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class FillinReq {
	
	@Min(value = 1, message = ContantsMessage.QUIZ_ID_ERROR)
	private int quizId;
	
	@NotBlank(message = ContantsMessage.EMAIL_ERROR)
	private String email;
	
	@Valid// 因為 vo 裡面的 questionId 有驗證，所以要加上 @valid 才會讓該驗證失效
	@NotEmpty
	private List<QuestionIdAnswerVo> questionAnswerVoList;
	
	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<QuestionIdAnswerVo> getQuestionAnswerVoList() {
		return questionAnswerVoList;
	}

	public void setQuestionAnswerVoList(List<QuestionIdAnswerVo> questionAnswerVoList) {
		this.questionAnswerVoList = questionAnswerVoList;
	}


}
