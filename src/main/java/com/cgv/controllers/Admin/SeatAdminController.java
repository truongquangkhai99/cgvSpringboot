package com.cgv.controllers.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.Room;
import com.cgv.models.Seat;
import com.cgv.serviceImpl.Admin.AdminSeatServiceimpl;
import com.cgv.utils.MiddleWare;

@Controller
@RequestMapping("/admin")
public class SeatAdminController {
	@Autowired
	public AdminSeatServiceimpl adminSeatServiceimpl;
	@GetMapping("/ghe")
	public ModelAndView ghe(HttpServletRequest request) {
		MiddleWare middleWare = new MiddleWare();
		ModelAndView mv = new ModelAndView();
		boolean check = middleWare.checkAdminLogin(request);
		if(check) {
			 mv = new ModelAndView("admin/ghe");
			List<Seat> list = adminSeatServiceimpl.getAll();
			System.out.println(list);
			mv.addObject("list",list);
		}else {
			mv = new ModelAndView("redirect:login");
		}
		
		return mv;
	}
	@PostMapping("/delete-seat")
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:ghe");
		String id= request.getParameter("id");
		boolean result = adminSeatServiceimpl.delete(Integer.parseInt(id));
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/add-seat")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:ghe");
		String name= request.getParameter("name");
		Seat seat = new Seat();
		seat.setSeatName(name);;
		boolean result = adminSeatServiceimpl.insert(seat);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/update-seat")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:ghe");
		String name= request.getParameter("name");
		String id= request.getParameter("id");
		Seat seat = new Seat();
		seat.setSeatName(name);;
		seat.setId(Integer.parseInt(id));
		boolean result = adminSeatServiceimpl.edit(seat);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
}
