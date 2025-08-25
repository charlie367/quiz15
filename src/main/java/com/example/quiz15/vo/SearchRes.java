package com.example.quiz15.vo;

import java.util.List;

import com.example.quiz15.entity.Quiz;

public class SearchRes extends BasicRes {

	private List<Quiz> quizList;

	public List<Quiz> getQuizList() {
		return quizList;
	}

	public SearchRes(int code, String message, List<Quiz> quizList) {
		super(code, message);
		this.quizList = quizList;
	}

	public void setQuizList(List<Quiz> quizList) {
		this.quizList = quizList;
	}

	public SearchRes() {
	
	}

	public SearchRes(int code, String message) {
		super(code, message);
		
	}
}
