package com.example.quiz15.vo;


import com.example.quiz15.constants.ContantsMessage;
import com.example.quiz15.entity.User;

import jakarta.validation.constraints.NotBlank;



public class AddInfoReq extends User {

	
	@NotBlank(message = ContantsMessage.ROLE_ERROR)
	private String role;

	public String getRole() {
	    return role;
	}

	public void setRole(String role) {
	    this.role = role;
	}
}
