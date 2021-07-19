package com.cgv.controllers.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.Film;
import com.cgv.models.Post;
import com.cgv.service.User.FilmService;
import com.cgv.serviceImpl.User.FilmServiceimpl;
import com.cgv.serviceImpl.User.PostServiceimpl;

@Controller
@RequestMapping("/user")
public class HomeController {
	
	@Autowired
	public FilmServiceimpl filmSerivce;
	@Autowired
	public PostServiceimpl postService;
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("phim");
		List<Film> listDangChieu = filmSerivce.getFilmDangChieu();
		List<Film> listSapChieu = filmSerivce.getFilmSapChieu();
		List<Post> listPromotion = postService.getPromotion();
		
		mv.addObject("listFilmDangChieu",listDangChieu);
		mv.addObject("listFilmSapChieu",listSapChieu);
		mv.addObject("listPro",listPromotion);
		
		return mv;
		
	}
	@PostMapping("/search")
	public ModelAndView search(HttpServletRequest request) {
		String keySearch = request.getParameter("keySearch");
		ModelAndView mv = new ModelAndView("search");
		List<Film> listSearch = filmSerivce.searchByName(keySearch);
		mv.addObject("listSearch",listSearch);
		mv.addObject("keysearch",keySearch);
		System.out.println(listSearch);
		return mv;
	}
	@GetMapping("/search")
	public ModelAndView getSearch() {
		ModelAndView mv = new ModelAndView("redirect:home");
		return mv;
	}
}
