package com.example.quiz15.vo;

import java.util.List;

// 一個 StatisticsVo 表示一題的所有統計
public class StatisticsVo {

	private int QuestionId;

	private String question;

	private String type;

	private boolean required;

	private List<OptionCountVo> OptionCountVoList;

	public StatisticsVo() {
		super();

	}

	public int getQuestionId() {
		return QuestionId;
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

	public List<OptionCountVo> getOptionCountVoList() {
		return OptionCountVoList;
	}

	public void setOptionCountVoList(List<OptionCountVo> optionCountVoList) {
		OptionCountVoList = optionCountVoList;
	}

	public StatisticsVo(int questionId, String question, String type, boolean required,
			List<OptionCountVo> optionCountVoList) {
		super();
		QuestionId = questionId;
		this.question = question;
		this.type = type;
		this.required = required;
		OptionCountVoList = optionCountVoList;
	}

}
