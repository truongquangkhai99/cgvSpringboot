package com.cgv.controllers.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class RoomAdminController {
	@GetMapping("/phong")
	public ModelAndView phong() {
		ModelAndView mv = new ModelAndView("admin/phong");
		
		return mv;
		
	}
}
