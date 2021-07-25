package com.cgv.controllers.Admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.CategoryFilm;
import com.cgv.models.CategoryPost;
import com.cgv.serviceImpl.Admin.AdminCategoryPostServiceimpl;
import com.cgv.utils.MiddleWare;

@Controller
@RequestMapping("/admin")
public class CategoryPostAdminController {
	@Autowired
	public AdminCategoryPostServiceimpl adminCategoryPostServiceimpl;
	@GetMapping("/loaibaiviet")
	public ModelAndView loaibaiviet(HttpServletRequest request) {
		MiddleWare middleWare = new MiddleWare();
		ModelAndView mv = new ModelAndView();
		boolean check = middleWare.checkAdminLogin(request);
		if(check) {
			 mv = new ModelAndView("admin/loaibaiviet");
			List<CategoryPost> list = new ArrayList<CategoryPost>();
			list = adminCategoryPostServiceimpl.getAll();
			mv.addObject("list", list);
		}else {
			mv = new ModelAndView("redirect:login");
		}
		
		return mv;
		
	}
	@PostMapping("/update-loaibaiviet")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:loaibaiviet");
		String name = request.getParameter("category-post");
		String id = request.getParameter("id");
		CategoryPost cpost = new CategoryPost();
		cpost.setId(Integer.parseInt(id));
		cpost.setName(name);
		boolean result = adminCategoryPostServiceimpl.edit(cpost);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/add-loaibaiviet")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:loaibaiviet");
		String name = request.getParameter("category-post");
		CategoryPost cpost = new CategoryPost();
		cpost.setName(name);
		boolean result = adminCategoryPostServiceimpl.insert(cpost);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/delete-loaibaiviet")
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:loaibaiviet");
		String id = request.getParameter("id");
		boolean result = adminCategoryPostServiceimpl.delete(Integer.parseInt(id));
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
}
