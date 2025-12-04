package com.example.quiz15.vo;

import java.util.List;

public class FeedbackRes extends BasicRes {

	

	private List<QuestionAnswerVo> QuestionAnswerVo;
	
	
	public FeedbackRes(int code, String message, List<com.example.quiz15.vo.QuestionAnswerVo> questionAnswerVo) {
		super(code, message);
		QuestionAnswerVo = questionAnswerVo;
	}

	public FeedbackRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	

	public List<QuestionAnswerVo> getQuestionAnswerVo() {
		return QuestionAnswerVo;
	}

	public void setQuestionAnswerVo(List<QuestionAnswerVo> questionAnswerVo) {
		QuestionAnswerVo = questionAnswerVo;
	}


}
