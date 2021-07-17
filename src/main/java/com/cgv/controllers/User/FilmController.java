package com.cgv.controllers.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.Film;
import com.cgv.serviceImpl.User.FilmServiceimpl;

@Controller
@RequestMapping("/user")
public class FilmController {
	@Autowired
	public FilmServiceimpl filmSerivce;
	
	@GetMapping("/phim")
	public ModelAndView phim() {
		ModelAndView mv = new ModelAndView("phim");
		List<Film> listDangChieu = filmSerivce.getFilmDangChieu();
		List<Film> listSapChieu = filmSerivce.getFilmSapChieu();
		mv.addObject("listFilmDangChieu",listDangChieu);
		mv.addObject("listFilmSapChieu",listSapChieu);
		return mv;
		
		
	}
}