package com.example.quiz15.vo;

import com.example.quiz15.constants.ContantsMessage;

import jakarta.validation.constraints.NotBlank;

public class LoginReq {
	
	@NotBlank(message = ContantsMessage.EMAIL_ERROR)
	private String email;
	
	@NotBlank(message = ContantsMessage.PASSWORD_ERROR)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
