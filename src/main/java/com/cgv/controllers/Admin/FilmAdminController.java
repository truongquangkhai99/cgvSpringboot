package com.cgv.controllers.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.Film;
import com.cgv.serviceImpl.Admin.AdminFilmServiceimpl;

@Controller
@RequestMapping("/admin")
public class FilmAdminController {
	@Autowired
	public AdminFilmServiceimpl adminFilmServiceimpl;
	@GetMapping("/phim")
	public ModelAndView phim() {
		ModelAndView mv = new ModelAndView("admin/phim");
		List<Film> list = adminFilmServiceimpl.getAll();
		mv.addObject("listF", list);
		System.out.println(list);
		return mv;
		
	}
}
