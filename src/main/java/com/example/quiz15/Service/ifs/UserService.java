package com.example.quiz15.Service.ifs;


import com.example.quiz15.vo.AddInfoReq;
import com.example.quiz15.vo.BasicRes;
import com.example.quiz15.vo.LoginReq;
import com.example.quiz15.vo.UserProfileRes;

public interface UserService {

	public BasicRes addInfo(AddInfoReq req);	
	
	public BasicRes login(LoginReq req);
	
	 public UserProfileRes getUserProfile(String email);
}
