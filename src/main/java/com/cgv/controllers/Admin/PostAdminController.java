package com.cgv.controllers.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.CategoryPost;
import com.cgv.models.Post;
import com.cgv.serviceImpl.Admin.AdminCategoryPostServiceimpl;
import com.cgv.serviceImpl.Admin.AdminPostServiceimpl;

@Controller
@RequestMapping("/admin")
public class PostAdminController {
	@Autowired
	public AdminPostServiceimpl adminPostServiceimpl;
	@Autowired
	public AdminCategoryPostServiceimpl adminCategoryPostServiceimpl;
	@GetMapping("/baiviet")
	public ModelAndView baiviet() {
		ModelAndView mv = new ModelAndView("admin/baiviet");
		List<Post> list = adminPostServiceimpl.getAll();
		List<CategoryPost> clist = adminCategoryPostServiceimpl.getAll();
		mv.addObject("list", list);
		mv.addObject("clist", clist);
		return mv;
	}
	@PostMapping("/delete-post")
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:baiviet");
		String id = request.getParameter("id");
		boolean result = adminPostServiceimpl.delete(Integer.parseInt(id));
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
}
