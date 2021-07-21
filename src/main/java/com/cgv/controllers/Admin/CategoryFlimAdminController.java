package com.cgv.controllers.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.daoImpl.Admin.AdminCategoryFilmDaoImpl;
import com.cgv.models.CategoryFilm;

@Controller
@RequestMapping("/admin")
public class CategoryFlimAdminController {
	@Autowired
	public AdminCategoryFilmDaoImpl  adminCategoryFilmDaoImpl;
	@GetMapping("/theloai")
	public ModelAndView theloai() {
		ModelAndView mv = new ModelAndView("admin/theloai");
		List<CategoryFilm> listCflim =  adminCategoryFilmDaoImpl.getAll();
		mv.addObject("listCflim",listCflim);
		System.out.println(listCflim);
		return mv;
		
	}
	@PostMapping("/update-theloai")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:theloai");
		String name = request.getParameter("category-film");
		String id = request.getParameter("id");
		System.out.println(id);
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
}
