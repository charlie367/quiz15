package com.example.quiz15.vo;

public class LoginRes extends BasicRes {

	private String role;

	

	public String getRole() {
		return role;
	}
	

	public LoginRes(int code, String message, String role) {
	    super(code, message);
	    this.role = role;
	}





	public LoginRes(int code, String message) {
		super(code, message);
		
	}

	public void setRole(String role) {
		this.role = role;
	}
}
