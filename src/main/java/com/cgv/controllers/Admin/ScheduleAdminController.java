package com.cgv.controllers.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.daoImpl.Admin.AdminScheduleDaoImpl;
import com.cgv.models.CategoryFilm;
import com.cgv.models.Film;
import com.cgv.models.Schedule;
import com.cgv.models.Showtime;
import com.cgv.serviceImpl.Admin.AdminFilmServiceimpl;
import com.cgv.serviceImpl.Admin.AdminShowtimeServiceimpl;

@Controller
@RequestMapping("/admin")
public class ScheduleAdminController {
	@Autowired
	public AdminScheduleDaoImpl adminScheduleServiceimpl;
	@Autowired
	public AdminFilmServiceimpl adminFilmServiceimpl;
	@Autowired
	public AdminShowtimeServiceimpl adminShowtimeServiceimpl;
	@GetMapping("/lichchieu")
	public ModelAndView lichchieu() {
		ModelAndView mv = new ModelAndView("admin/lichchieu");
		List<Schedule> list = adminScheduleServiceimpl.getAll();
		List<Film> lfilm = adminFilmServiceimpl.getAll();
		System.out.println(list);
		mv.addObject("list",list);
		mv.addObject("lfilm",lfilm);
		return mv;
		
	}
	@PostMapping("/add-schedule")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:lichchieu");
		String name = request.getParameter("film");
		String date = request.getParameter("date-film");
		Schedule schedule = new Schedule();
		schedule.setFilmId(Integer.parseInt(name));
		schedule.setDateschedule(date);
		System.out.println(schedule);
		boolean result = adminScheduleServiceimpl.insert(schedule);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/delete-schedule")
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:lichchieu");
		String id= request.getParameter("id");
		boolean result = adminScheduleServiceimpl.delete(Integer.parseInt(id));
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/update-schedule")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:lichchieu");
		String name = request.getParameter("film");
		String date = request.getParameter("date-film");
		String id= request.getParameter("id");
		Schedule schedule = new Schedule();
		schedule.setFilmId(Integer.parseInt(name));
		schedule.setDateschedule(date);
		schedule.setId(Integer.parseInt(id));
		System.out.println(schedule);
		boolean result = adminScheduleServiceimpl.edit(schedule);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/add-showtime")
	public ModelAndView addShow(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:suatchieu");
		String idsche = request.getParameter("idsche");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		Showtime showtime = new Showtime();
		showtime.setScheduleId(Integer.parseInt(idsche));
		showtime.setStartTime(start);;
		showtime.setEndTime(end);
		System.out.println(showtime);
		boolean result = adminShowtimeServiceimpl.insert(showtime);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
}
