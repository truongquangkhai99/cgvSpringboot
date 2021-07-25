package com.cgv.controllers.Admin;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.CategoryPost;
import com.cgv.models.Film;
import com.cgv.models.Post;
import com.cgv.serviceImpl.Admin.AdminCategoryPostServiceimpl;
import com.cgv.serviceImpl.Admin.AdminPostServiceimpl;
import com.cgv.utils.MiddleWare;

@Controller
@RequestMapping("/admin")
public class PostAdminController {
	@Autowired
	public AdminPostServiceimpl adminPostServiceimpl;
	@Autowired
	public AdminCategoryPostServiceimpl adminCategoryPostServiceimpl;
	@GetMapping("/baiviet")
	public ModelAndView baiviet(HttpServletRequest request) {
		MiddleWare middleWare = new MiddleWare();
		ModelAndView mv = new ModelAndView();
		boolean check = middleWare.checkAdminLogin(request);
		if(check) {
			 mv = new ModelAndView("admin/baiviet");
			List<Post> list = adminPostServiceimpl.getAll();
			List<CategoryPost> clist = adminCategoryPostServiceimpl.getAll();
			System.out.println(clist);
			mv.addObject("list", list);
			mv.addObject("clist", clist);
		}else {
			mv = new ModelAndView("redirect:login");
		}
		
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
	@PostMapping("/insert-post")
	 public ModelAndView insert(HttpServletRequest request,@RequestParam("file") MultipartFile image) {
		ModelAndView mv = new ModelAndView("redirect:baiviet");
		String title = request.getParameter("title");
		String noidung = request.getParameter("noidung");
		String idTheloai = request.getParameter("theloai");	
		Post post = new Post();
		
		post.setDescription(noidung);
		post.setId_cpost(Integer.parseInt(idTheloai));
		post.setTitle(title);
		if(image.isEmpty()) {
			System.out.println("Rỗng");
		}
		String dirname = request.getServletContext().getRealPath("user/images");
		
		Path path = Paths.get(dirname);
		try {
			InputStream inputStream = image.getInputStream();
			
			String name = String.valueOf(new Date().getTime()+image.getOriginalFilename().toLowerCase());
			Files.copy(inputStream, path.resolve(name),StandardCopyOption.REPLACE_EXISTING);
			post.setImage(name);
			boolean result = adminPostServiceimpl.insert(post);
			if(result) {
				System.out.println("Thành công");
			}else {
				System.out.println("That bai");
			}
			
		} catch (Exception e) {
			// TODO: handle exceptione.p
			e.printStackTrace();
		}
		
		return mv;
	 }
	@PostMapping("/update-post")
	 public ModelAndView update(HttpServletRequest request,@RequestParam("file") MultipartFile image) {
		ModelAndView mv = new ModelAndView("redirect:baiviet");
		String title = request.getParameter("title");
		String noidung = request.getParameter("noidung");
		String idTheloai = request.getParameter("theloai");	
		String id = request.getParameter("idPost");	
		Post post = new Post();
		post.setId(Integer.parseInt(id));
		post.setDescription(noidung);
		post.setId_cpost(Integer.parseInt(idTheloai));
		post.setTitle(title);
		if(image.isEmpty()) {
			System.out.println("Rỗng");
		}
		String dirname = request.getServletContext().getRealPath("user/images");
		
		Path path = Paths.get(dirname);
		try {
			InputStream inputStream = image.getInputStream();
			
			String name = String.valueOf(new Date().getTime()+image.getOriginalFilename().toLowerCase());
			Files.copy(inputStream, path.resolve(name),StandardCopyOption.REPLACE_EXISTING);
			post.setImage(name);
			boolean result = adminPostServiceimpl.edit(post);
			if(result) {
				System.out.println("Thành công");
			}else {
				System.out.println("That bai");
			}
			
		} catch (Exception e) {
			// TODO: handle exceptione.p
			e.printStackTrace();
		}
		
		return mv;
	 }
}
