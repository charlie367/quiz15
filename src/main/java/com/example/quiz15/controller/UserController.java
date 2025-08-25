package com.example.quiz15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz15.Service.ifs.UserService;
import com.example.quiz15.vo.AddInfoReq;
import com.example.quiz15.vo.BasicRes;
import com.example.quiz15.vo.LoginReq;

import jakarta.validation.Valid;
//@CrossOrigin
//可提供跨域資源共享的請求，雖然前後端電腦都在自己的同一台電腦，但前端呼叫後端提供
@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("user/add_info")
	public BasicRes addInfo(@RequestBody @Valid AddInfoReq req) {
		return userService.addInfo(req);
	}
	@PostMapping("user/login")
	public BasicRes login(@RequestBody @Valid  LoginReq req) {
		return userService.login(req);
	}
	
}
