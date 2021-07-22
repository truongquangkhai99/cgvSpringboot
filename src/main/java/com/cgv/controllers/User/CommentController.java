package com.cgv.controllers.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgv.serviceImpl.User.CommentServiceImpl;

@Controller
@RequestMapping("/user")
public class CommentController {
	
	@Autowired
	public CommentServiceImpl commentService;
	
	@GetMapping("")
	public void comment() {
		
	}

}
