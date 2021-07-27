package com.cgv.controllers.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
@Controller
@RequestMapping("/user")

public class HistoryController {
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
	@GetMapping("/lichsu")
	public ModelAndView phim(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("lichsu");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int id = user.getId();
		List<Booking> listb = adminBookingServiceimpl.getHis(id);
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
		return mv;
	}
}
