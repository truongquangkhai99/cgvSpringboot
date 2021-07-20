package com.cgv.controllers.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class CategoryFlimAdminController {
	@GetMapping("/theloai")
	public ModelAndView theloai() {
		ModelAndView mv = new ModelAndView("admin/theloai");
		
		return mv;
		
	}
}
