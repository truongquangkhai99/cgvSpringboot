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
import com.cgv.models.Schedule;
import com.cgv.models.Seat;
import com.cgv.models.Showtime;
import com.cgv.serviceImpl.Admin.AdminFilmServiceimpl;
import com.cgv.serviceImpl.Admin.AdminScheduleServiceimpl;
import com.cgv.serviceImpl.Admin.AdminShowtimeServiceimpl;
import com.cgv.utils.MiddleWare;

@Controller
@RequestMapping("/admin")
public class ShowtimeAdminController {
	@Autowired
	public AdminShowtimeServiceimpl adminShowtimeServiceimpl;
	@Autowired
	public AdminScheduleServiceimpl adminScheduleServiceimpl;
	@Autowired
	public AdminFilmServiceimpl adminFilmServiceimpl;
	@GetMapping("/suatchieu")
	public ModelAndView suatchieu(HttpServletRequest request) {
		MiddleWare middleWare = new MiddleWare();
		ModelAndView mv = new ModelAndView();
		boolean check = middleWare.checkAdminLogin(request);
		if(check) {
			 mv = new ModelAndView("admin/suatchieu");
			List<Showtime> list = adminShowtimeServiceimpl.getAll();
			List<Schedule> listsche = adminScheduleServiceimpl.getAll();
			List<Film> listfilm = adminFilmServiceimpl.getAll();
			mv.addObject("list", list);
			mv.addObject("listsche", listsche);
			mv.addObject("listfilm", listfilm);
		}else {
			mv = new ModelAndView("redirect:login");
		}
		
		return mv;
		
	}
	@PostMapping("/delete-showtime")
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:suatchieu");
		String id= request.getParameter("id");
		boolean result = adminShowtimeServiceimpl.delete(Integer.parseInt(id));
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/update-showtime")
	public ModelAndView addShow(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:suatchieu");
		String id = request.getParameter("id");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		Showtime showtime = new Showtime();
		showtime.setId(Integer.parseInt(id));
		showtime.setStartTime(start);;
		showtime.setEndTime(end);
		System.out.println(showtime);
		boolean result = adminShowtimeServiceimpl.edit(showtime);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	
	
}
