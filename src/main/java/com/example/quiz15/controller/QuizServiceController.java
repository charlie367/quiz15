package com.example.quiz15.controller;

import java.lang.annotation.Repeatable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz15.Service.ifs.QuizService;
import com.example.quiz15.dao.QuizDao;
import com.example.quiz15.entity.Question;
import com.example.quiz15.entity.Quiz;
import com.example.quiz15.vo.BasicRes;
import com.example.quiz15.vo.QuizCreateReq;
import com.example.quiz15.vo.QuizUpdateReq;
import com.example.quiz15.vo.SearchRes;

import jakarta.validation.Valid;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuizServiceController {

	@Autowired
	private QuizService quizService;
	
		
	@PostMapping("/quiz/create")
	public BasicRes create(@Valid @RequestBody QuizCreateReq req) throws Exception{
		
		return quizService.create(req);
	}

//	@PostMapping("/quiz/update")
//	public BasicRes update(@Valid @RequestBody QuizUpdateReq req) throws Exception{
//		return quizService.update(req);
//	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/quiz/all")
	public SearchRes getAll() {
	    return quizService.getAllQuizs();
	}
	
	@PutMapping("/quiz/update/{id}")
	public BasicRes update(@PathVariable("id") int id,
	                       @Valid @RequestBody QuizUpdateReq req) throws Exception {
	    req.setQuizId(id);  // 把前端傳來的路徑參數 id 放進去
	    return quizService.update(req);
	}

	  
	  @DeleteMapping("/quiz/delete/{id}")
	  public BasicRes delete(@PathVariable("id") int id) {
	      return quizService.deleteQuiz(id);
	  }
	
}

