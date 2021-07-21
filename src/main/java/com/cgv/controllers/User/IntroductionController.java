package com.cgv.controllers.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.Post;
import com.cgv.serviceImpl.User.PostServiceimpl;

@Controller
@RequestMapping("/user")
public class IntroductionController {
	@Autowired
	public PostServiceimpl postService;
	@GetMapping("/gioithieu")
	public ModelAndView detail() {
		ModelAndView mv = new ModelAndView("introduce");
		List<Post> listInfor = postService.getInfor();
		mv.addObject("listInfor", listInfor);
		return mv;
		
	}
	@GetMapping("/postdetail/{id}")
	public ModelAndView postdetail(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("postdetail");
		Post postdetail = postService.getDetail(id);
		mv.addObject("postdetail",postdetail);
		return mv;
	}

}
