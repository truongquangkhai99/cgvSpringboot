package com.cgv.controllers.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.User;
import com.cgv.service.User.UserService;

@Controller
@RequestMapping("/user")
public class AuthenticationController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("dangki");
		return mv;
		
	}
	
	@PostMapping("/register")
	public ModelAndView userRegister(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("dangki");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String phone = request.getParameter("phone");
		String rePassword = request.getParameter("re_pass");
		
		User user = new User();
		user.setEmail(email);
		user.setActive(0);
		user.setPassword(password);
		user.setRoleId(3);
		user.setUsername(name);
		user.setPhoneNumber(phone);
		if(!password.equalsIgnoreCase(rePassword)) {
			mv.addObject("mess","Password is not map with rePassword !!");	
		}else {
			boolean result = userService.register(user);
		    if(result) {   	
		    	mv.addObject("mess","Register successfully");	
		    }else {
		    	mv.addObject("mess","Email is exited");	
		    }
		}
	    
		
	    return mv;
		
	}
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("dangnhap");
		return mv;
		
	}

}
