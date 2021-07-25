package com.cgv.controllers.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.CategoryFilm;
import com.cgv.models.Film;
import com.cgv.serviceImpl.Admin.AdminHomeServiceimpl;
import com.cgv.utils.MiddleWare;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {
	@Autowired
	public AdminHomeServiceimpl adminHomeServiceimpl;
	@GetMapping("/home")
	public ModelAndView home(HttpServletRequest request) {
		MiddleWare middleWare = new MiddleWare();
		ModelAndView mv = new ModelAndView();
		boolean check = middleWare.checkAdminLogin(request);
		if(check) {
			mv = new ModelAndView("admin/index");
			int countfilm =  adminHomeServiceimpl.countFilm();
			int countuser =  adminHomeServiceimpl.countUser();
			int countbooking =  adminHomeServiceimpl.countBooking();
			double totalmoney =  adminHomeServiceimpl.totalMoney();
			String a = String.format("%,.2f", totalmoney);
			mv.addObject("cf", countfilm);
			mv.addObject("cu", countuser);
			mv.addObject("cb", countbooking);
			mv.addObject("ct", a);
		}else {
			mv = new ModelAndView("redirect:login");
		}
		
		return mv;
		
	}
}
