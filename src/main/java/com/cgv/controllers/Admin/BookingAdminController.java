package com.cgv.controllers.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.dao.Admin.AdminShowtimeDao;
import com.cgv.models.Booking;
import com.cgv.models.Film;
import com.cgv.models.Room;
import com.cgv.models.Schedule;
import com.cgv.models.Seat;
import com.cgv.models.Showtime;
import com.cgv.models.User;
import com.cgv.serviceImpl.Admin.AdminBookingServiceimpl;
import com.cgv.serviceImpl.Admin.AdminFilmServiceimpl;
import com.cgv.serviceImpl.Admin.AdminRoomServiceimpl;
import com.cgv.serviceImpl.Admin.AdminScheduleServiceimpl;
import com.cgv.serviceImpl.Admin.AdminSeatServiceimpl;
import com.cgv.serviceImpl.Admin.AdminShowtimeServiceimpl;
import com.cgv.serviceImpl.Admin.AdminUserServiceimpl;
import com.cgv.utils.MiddleWare;

@Controller
@RequestMapping("/admin")
public class BookingAdminController {
	@Autowired
	public AdminBookingServiceimpl adminBookingServiceimpl;
	@Autowired
	public AdminUserServiceimpl adminUserServiceimpl;
	@Autowired
	public AdminFilmServiceimpl adminFilmServiceimpl;
	@Autowired
	public AdminScheduleServiceimpl adminScheduleServiceimpl;
	@Autowired
	public AdminShowtimeServiceimpl adminShowtimeServiceimpl;
	@Autowired
	public AdminRoomServiceimpl adminRoomServiceimpl;
	@Autowired
	public AdminSeatServiceimpl adminSeatServiceimpl;

	@GetMapping("/booking")
	public ModelAndView booking(HttpServletRequest request) {
		MiddleWare middleWare = new MiddleWare();
		ModelAndView mv = new ModelAndView();
		boolean check = middleWare.checkAdminLogin(request);
		if(check) {
			mv = new ModelAndView("admin/booking");
			List<Booking> listb = adminBookingServiceimpl.getAll();
			List<User> listu = adminUserServiceimpl.getAll();
			List<Film> listf = adminFilmServiceimpl.getAll();
			List<Schedule> listsc = adminScheduleServiceimpl.getAll();
			List<Showtime> listsh = adminShowtimeServiceimpl.getAll();
			List<Room> listr = adminRoomServiceimpl.getAll();
			List<Seat> lists = adminSeatServiceimpl.getAll();
			mv.addObject("listb", listb);
			mv.addObject("listu", listu);
			mv.addObject("listf", listf);
			mv.addObject("listsc", listsc);
			mv.addObject("listsh", listsh);
			mv.addObject("listr", listr);
			mv.addObject("lists", lists);
		}else {
			mv = new ModelAndView("redirect:login");
		}
		
		return mv;
		
	}
	@PostMapping("/update-booking")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:booking");
		String id = request.getParameter("id");
		Booking booking = new Booking();
		booking.setId(Integer.parseInt(id));
		booking.setStatus(1);
		boolean result = adminBookingServiceimpl.edit(booking);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
}
