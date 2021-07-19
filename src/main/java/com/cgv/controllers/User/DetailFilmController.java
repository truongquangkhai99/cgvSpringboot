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
import com.cgv.service.User.FilmService;
import com.cgv.serviceImpl.User.CategoryFilmServiceimpl;
import com.cgv.serviceImpl.User.FilmServiceimpl;

@Controller
public class DetailFilmController {
	@Autowired
	public FilmServiceimpl filmSerivce;
	@Autowired
	public CategoryFilmServiceimpl cfilmSerivce;
	@GetMapping("/detail/{id}/{categoryFilmId}")
	public ModelAndView detail(@PathVariable int id,@PathVariable int categoryFilmId) {
		ModelAndView mv = new ModelAndView("detail");
		Film detaifilm = filmSerivce.getDetailFilm(id);
		System.out.println(detaifilm);
		CategoryFilm cfilm = cfilmSerivce.getCFilm(categoryFilmId);
		System.out.println(categoryFilmId);
		mv.addObject("detailfilm",detaifilm);
		mv.addObject("cfilm",cfilm);
		return mv;
	}
	

}
