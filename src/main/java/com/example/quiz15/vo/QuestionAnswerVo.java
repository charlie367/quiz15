package com.example.quiz15.vo;

import java.util.List;


import jakarta.validation.constraints.*;


public class QuestionAnswerVo {


	private int QuestionId;


	private String question;


	private String type;

	private boolean required;



	private List<String> answerList;

	public int getQuestionId() {
		return QuestionId;
	}

	public QuestionAnswerVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionAnswerVo(int questionId, String question, String type, boolean required, List<String> answerList) {
		super();
		QuestionId = questionId;
		this.question = question;
		this.type = type;
		this.required = required;
		this.answerList = answerList;
	}

	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public List<String> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<String> answerList) {
		this.answerList = answerList;
	}

}
