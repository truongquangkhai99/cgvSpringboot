package com.cgv.controllers.User;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.Film;

@Controller
public class DetailFilmController {
	
	@GetMapping("/detail")
	public ModelAndView detail() {
		ModelAndView mv = new ModelAndView("detail");
		return mv;
		
	}

}
