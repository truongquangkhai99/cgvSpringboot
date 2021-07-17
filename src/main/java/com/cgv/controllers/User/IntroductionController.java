package com.cgv.controllers.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IntroductionController {
	
	@GetMapping("/gioithieu")
	public ModelAndView detail() {
		ModelAndView mv = new ModelAndView("introduce");
		return mv;
		
	}

}
