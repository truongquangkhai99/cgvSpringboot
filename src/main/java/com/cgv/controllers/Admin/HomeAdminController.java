package com.cgv.controllers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.serviceImpl.Admin.AdminHomeServiceimpl;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {
	@Autowired
	public AdminHomeServiceimpl adminHomeServiceimpl;
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("admin/index");
		int countfilm =  adminHomeServiceimpl.countFilm();
		int countuser =  adminHomeServiceimpl.countUser();
		int countbooking =  adminHomeServiceimpl.countBooking();
		double totalmoney =  adminHomeServiceimpl.totalMoney();
		String a = String.format("%,.2f", totalmoney);
		mv.addObject("cf", countfilm);
		mv.addObject("cu", countuser);
		mv.addObject("cb", countbooking);
		mv.addObject("ct", a);
		return mv;
		
	}
}
