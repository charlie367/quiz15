package com.example.quiz15.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.quiz15.Service.ifs.UserService;
import com.example.quiz15.constants.ResCodeMessage;
import com.example.quiz15.dao.UserDao;
import com.example.quiz15.entity.User;
import com.example.quiz15.vo.AddInfoReq;
import com.example.quiz15.vo.BasicRes;
import com.example.quiz15.vo.LoginReq;
import com.example.quiz15.vo.LoginRes;
import com.example.quiz15.vo.UserProfileRes;
@Service
public class UserServiceImpl implements UserService {

	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public BasicRes  addInfo(AddInfoReq req) {
		// req 的參數檢查已經在類別 User 中透過 Validation 驗證
		// 1. 檢查帳號是否已存在
		// 透過 PK email 去取得 count 數， 只會得到 0 或 1
		int count = userDao.getCountByEmail(req.getEmail());
		if(count == 1) { //email 是 PK，若 count = 1 表示帳號已存在
			return new BasicRes(ResCodeMessage.EMAIL_EXISTS.getCode(),//
					ResCodeMessage.EMAIL_EXISTS.getMessage());
		}
//		2. 新增資料	
		try {
			userDao.addInfo(req.getName(), req.getPhone(), req.getEmail(),
	                req.getAge(), encoder.encode(req.getPassword()), req.getRole());
			
		} catch (Exception e) {
			return new BasicRes(ResCodeMessage.ADD_INFO_ERROR.getCode(),//
					ResCodeMessage.ADD_INFO_ERROR.getMessage());
		}
		   return new BasicRes(ResCodeMessage.SUCCESS.getCode(),
                   ResCodeMessage.SUCCESS.getMessage());
		
	}


	@Override
	public BasicRes login(LoginReq req) {
		//看看 email 是否存在於 DB 
		User user = userDao.getByEmail(req.getEmail());
		//透過 email 取得一筆資料，email 不存在的話，會得到 null
		
		if(user == null) { //email 是 PK，若 count = 1 表示帳號已存在
			return new BasicRes(ResCodeMessage.NOT_FOUND.getCode(),//
					ResCodeMessage.NOT_FOUND.getMessage());
		}
//		比對密碼
//		if  的條件式最前面有驚嘆號，表示整個比對結果 == false 的意思
		if(!encoder.matches(req.getPassword(), user.getPassword())) {
			return new BasicRes(ResCodeMessage.PASSWORD_MISMATCH.getCode(),//
					ResCodeMessage.PASSWORD_MISMATCH.getMessage());
		}
	
		

	    return new LoginRes(
	        ResCodeMessage.SUCCESS.getCode(),
	        ResCodeMessage.SUCCESS.getMessage(),
	        user.getRole() // ← 從 DB 撈出來的角色
	    );
//		return null;
	
	}

	

	@Override
	public UserProfileRes getUserProfile(String email) {
	    // 從 DAO 撈資料
	    User user = userDao.getByEmail(email);  // ← 建議統一用這個
	    
	    if (user == null) {
	        // 找不到使用者，回傳錯誤訊息
	        return new UserProfileRes(
	            ResCodeMessage.NOT_FOUND.getCode(),
	            ResCodeMessage.NOT_FOUND.getMessage(),
	            null, null, email, null
	        );
	    }

	    // 找到了，回傳成功訊息 + 使用者資料
	    return new UserProfileRes(
	        ResCodeMessage.SUCCESS.getCode(),
	        ResCodeMessage.SUCCESS.getMessage(),
	        user.getName(),
	        user.getPhone(),
	        user.getEmail(),
	        user.getAge()
	    );
	}

	
}
