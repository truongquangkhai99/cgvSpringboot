package com.cgv.controllers.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.daoImpl.Admin.AdminCategoryFilmDaoImpl;
import com.cgv.models.CategoryFilm;
import com.cgv.utils.MiddleWare;

@Controller
@RequestMapping("/admin")
public class CategoryFlimAdminController {
	@Autowired
	public AdminCategoryFilmDaoImpl  adminCategoryFilmDaoImpl;
	@GetMapping("/theloai")
	public ModelAndView theloai(HttpServletRequest request) {
		MiddleWare middleWare = new MiddleWare();
		ModelAndView mv = new ModelAndView();
		boolean check = middleWare.checkAdminLogin(request);
		if(check) {
			mv = new ModelAndView("admin/theloai");
			List<CategoryFilm> listCflim =  adminCategoryFilmDaoImpl.getAll();
			mv.addObject("listCflim",listCflim);
			System.out.println(listCflim);
		}else {
			mv = new ModelAndView("redirect:login");
		}
		
		return mv;
		
	}
	@PostMapping("/update-theloai")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:theloai");
		String name = request.getParameter("category-film");
		String id = request.getParameter("id");
		
		CategoryFilm cfilm = new CategoryFilm();
		cfilm.setId(Integer.parseInt(id));
		cfilm.setName(name);
		boolean result = adminCategoryFilmDaoImpl.edit(cfilm);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/add-theloai")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:theloai");
		String name = request.getParameter("category-film");
		CategoryFilm cfilm = new CategoryFilm();
		cfilm.setName(name);
		boolean result = adminCategoryFilmDaoImpl.insert(cfilm);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/delete-theloai")
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:theloai");
		String id = request.getParameter("id");
		boolean result = adminCategoryFilmDaoImpl.delete(Integer.parseInt(id));
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
}
