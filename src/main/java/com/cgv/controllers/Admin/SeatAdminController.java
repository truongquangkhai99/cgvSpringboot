package com.cgv.controllers.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class SeatAdminController {
	@GetMapping("/ghe")
	public ModelAndView ghe() {
		ModelAndView mv = new ModelAndView("admin/ghe");
		
		return mv;
		
	}
}
