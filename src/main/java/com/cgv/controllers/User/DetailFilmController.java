package com.cgv.controllers.User;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.CategoryFilm;
import com.cgv.models.Film;
import com.cgv.models.Rating;
import com.cgv.models.User;
import com.cgv.service.User.FilmService;
import com.cgv.serviceImpl.User.CategoryFilmServiceimpl;
import com.cgv.serviceImpl.User.CommentServiceImpl;
import com.cgv.serviceImpl.User.FilmServiceimpl;
import com.cgv.serviceImpl.User.UserServiceImpl;

@Controller
public class DetailFilmController {
	@Autowired
	public FilmServiceimpl filmSerivce;
	@Autowired
	public CategoryFilmServiceimpl cfilmSerivce;
	@Autowired
	public CommentServiceImpl commentServide;
	@Autowired
	public UserServiceImpl userImpl;
	@GetMapping("/detail/{id}/{categoryFilmId}")
	public ModelAndView detail(@PathVariable int id,@PathVariable int categoryFilmId) {
		ModelAndView mv = new ModelAndView("detail");
		Film detaifilm = filmSerivce.getDetailFilm(id);
		List<Rating> listRating = commentServide.getCommentById(id);
		System.out.println(listRating);
		CategoryFilm cfilm = cfilmSerivce.getCFilm(categoryFilmId);
		List<User> user = userImpl.getAll();
		mv.addObject("detailfilm",detaifilm);
		mv.addObject("cfilm",cfilm);
		mv.addObject("listRating",listRating);
		mv.addObject("User",user);
		return mv;
	}
	

}
