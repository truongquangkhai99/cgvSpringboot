package com.cgv.controllers.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.Film;
import com.cgv.models.Role;
import com.cgv.models.Schedule;
import com.cgv.models.Showtime;
import com.cgv.models.User;
import com.cgv.serviceImpl.Admin.AdminUserServiceimpl;
import com.cgv.utils.MiddleWare;

@Controller
@RequestMapping("/admin")
public class UserAdminController {
	@Autowired
	public AdminUserServiceimpl adminUserServiceimpl;
	@GetMapping("/nguoidung")
	public ModelAndView nguoidung(HttpServletRequest request) {
		MiddleWare middleWare = new MiddleWare();
		ModelAndView mv = new ModelAndView();
		boolean check = middleWare.checkAdminLogin(request);
		if(check) {
			mv = new ModelAndView("admin/nguoidung");
			List<User> list = adminUserServiceimpl.getAll();
			List<Role> listR = adminUserServiceimpl.getRole();
			mv.addObject("listR", listR);
			mv.addObject("list",list);
		}else {
			mv = new ModelAndView("redirect:login");
		}
		
		return mv;
	}
	@PostMapping("/delete-user")
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:nguoidung");
		String id= request.getParameter("id");
		boolean result = adminUserServiceimpl.delete(Integer.parseInt(id));
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/add-user")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:nguoidung");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String phone = request.getParameter("phone");
		String rePassword = request.getParameter("re_pass");
		String idrole=request.getParameter("idrole");
		User user = new User();
		user.setEmail(email);
		user.setActive(0);
		user.setPassword(password);
		user.setRoleId(Integer.parseInt(idrole));
		user.setUsername(name);
		user.setPhoneNumber(phone);
		if(!password.equalsIgnoreCase(rePassword)) {
			mv.addObject("mess","Password is not map with rePassword !!");	
		}else {
			boolean result = adminUserServiceimpl.insert(user);
		    if(result) {   	
		    	mv.addObject("mess1","Add successfully");	
		    }else {
		    	mv.addObject("mess","Email is exited");	
		    }
		}
	    return mv;
		
	}
	@PostMapping("/update-user")
	public ModelAndView edit(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:nguoidung");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		String idrole=request.getParameter("idrole");
		User user = new User();
		user.setEmail(email);
		user.setActive(0);
		user.setPassword(password);
		user.setRoleId(Integer.parseInt(idrole));
		user.setUsername(name);
		user.setPhoneNumber(phone);
		user.setId(Integer.parseInt(id));
		boolean result = adminUserServiceimpl.edit(user);
		if(result) {
			mv.addObject("mess1","Update successfully");	
		}
		else {
			mv.addObject("mess","Email is exited");	
		}
		return mv;
	}
}
