package com.cgv.controllers.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.User;
import com.cgv.serviceImpl.Admin.AdminUserServiceimpl;

@Controller
@RequestMapping("/admin")
public class AuthenticationAdminController {
	@Autowired
	public AdminUserServiceimpl adminUserServiceimpl;
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("admin/login");
		return mv;
	}
	@PostMapping("/login")
	public ModelAndView loginauthe(HttpServletRequest request) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		boolean result = adminUserServiceimpl.login(user);
		if(result) {
			User userInfo = adminUserServiceimpl.getInformation(email);
			HttpSession session = request.getSession();
			session.setAttribute("userAdmin", userInfo);
			ModelAndView mv = new ModelAndView("redirect:home");
			return mv;
		}
		
		ModelAndView mv = new ModelAndView("admin/login");
		mv.addObject("mess","Email or password incorret");	
		return mv;
		
	}
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);	
		session.invalidate();
		ModelAndView mv = new ModelAndView("redirect:login");
		return mv;
	}
}
