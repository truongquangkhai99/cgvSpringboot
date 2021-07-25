package com.cgv.controllers.Admin;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.CategoryFilm;
import com.cgv.models.CategoryPost;
import com.cgv.models.Film;
import com.cgv.serviceImpl.Admin.AdminCategoryFilmServiceimpl;
import com.cgv.serviceImpl.Admin.AdminFilmServiceimpl;
import com.cgv.utils.MiddleWare;

@Controller
@RequestMapping("/admin")
public class FilmAdminController {
	@Autowired
	public AdminFilmServiceimpl adminFilmServiceimpl;
	@Autowired
	public AdminCategoryFilmServiceimpl adminCategoryFilmServiceimpl;
	@GetMapping("/phim")
	public ModelAndView phim(HttpServletRequest request) {
		MiddleWare middleWare = new MiddleWare();
		ModelAndView mv = new ModelAndView();
		boolean check = middleWare.checkAdminLogin(request);
		if(check) {
			 mv = new ModelAndView("admin/phim");
			List<Film> list = adminFilmServiceimpl.getAll();
			List<CategoryFilm> cfilm= adminCategoryFilmServiceimpl.getAll();
			mv.addObject("listF", list);
			mv.addObject("cfilm", cfilm);
			System.out.println(list);
		}else {
			mv = new ModelAndView("redirect:login");
		}
	
		return mv;
		
	}
	@PostMapping("/insert")
	 public ModelAndView insert(HttpServletRequest request,@RequestParam("file") MultipartFile image) {
		ModelAndView mv = new ModelAndView("redirect:phim");
		String nameFilm = request.getParameter("nameFilm");
		String actorFilm = request.getParameter("actorFilm");
		String directorFilm = request.getParameter("directorFilm");
		String durationFilm = request.getParameter("durationFilm");
		String description = request.getParameter("description");
		String idCfilm = request.getParameter("idCfilm");
		String trailerFilm = request.getParameter("trailerFilm");	
		Film film = new Film();
		film.setDescription(description);
		film.setActor(actorFilm);
		film.setDirector(directorFilm);
		film.setDuration(durationFilm);
		film.setFilmName(nameFilm);
		film.setId_cfilm(Integer.parseInt(idCfilm));
		film.setTrailer(trailerFilm);
		if(image.isEmpty()) {
			System.out.println("Rỗng");
		}
		String dirname = request.getServletContext().getRealPath("user/images");
		
		Path path = Paths.get(dirname);
		try {
			InputStream inputStream = image.getInputStream();
			
			String name = String.valueOf(new Date().getTime()+image.getOriginalFilename().toLowerCase());
			Files.copy(inputStream, path.resolve(name),StandardCopyOption.REPLACE_EXISTING);
			film.setImage(name);
			boolean result = adminFilmServiceimpl.insert(film);
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
	@PostMapping("/delete")
	public ModelAndView delete(@RequestParam String id) {
		
		ModelAndView mv = new ModelAndView("redirect:phim");
		
		boolean result = adminFilmServiceimpl.delete(Integer.parseInt(id));
		if(result) {
			System.out.println("Thành công");
		}else {
			System.out.println("Thất bại");
		}
		return mv;
		
	}
	@PostMapping("/update-film")
	 public ModelAndView update(HttpServletRequest request,@RequestParam("file") MultipartFile image) {
		ModelAndView mv = new ModelAndView("redirect:phim");
		String nameFilm = request.getParameter("nameFilm");
		String actorFilm = request.getParameter("actorFilm");
		String directorFilm = request.getParameter("directorFilm");
		String durationFilm = request.getParameter("durationFilm");
		String description = request.getParameter("description");
		String idCfilm = request.getParameter("idCfilm");
		String trailerFilm = request.getParameter("trailerFilm");	
		String idFilm = request.getParameter("idFilm");
		Film film = new Film();
		film.setDescription(description);
		film.setId(Integer.parseInt(idFilm));
		film.setActor(actorFilm);
		film.setDirector(directorFilm);
		film.setDuration(durationFilm);
		film.setFilmName(nameFilm);
		film.setId_cfilm(Integer.parseInt(idCfilm));
		film.setTrailer(trailerFilm);
		if(image.isEmpty()) {
			System.out.println("Rỗng");
		}
		String dirname = request.getServletContext().getRealPath("user/images");
		
		Path path = Paths.get(dirname);
		try {
			InputStream inputStream = image.getInputStream();
			
			String name = String.valueOf(new Date().getTime()+image.getOriginalFilename().toLowerCase());
			Files.copy(inputStream, path.resolve(name),StandardCopyOption.REPLACE_EXISTING);
			film.setImage(name);
			boolean result = adminFilmServiceimpl.edit(film);
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
