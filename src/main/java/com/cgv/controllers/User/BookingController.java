package com.cgv.controllers.User;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.dao.User.BookingDao;
import com.cgv.models.Booking;
import com.cgv.models.ResponseAjax;
import com.cgv.models.Room;
import com.cgv.models.Schedule;
import com.cgv.models.Seat;
import com.cgv.models.Showtime;
import com.cgv.models.User;
import com.cgv.serviceImpl.User.BookingServiceImpl;

@Controller
@RequestMapping("/user")
public class BookingController {
	
	public static final int GIA_VE = 65000;
	
	@Autowired
	public BookingServiceImpl bookingService;
	
	@Autowired
	public BookingDao bookingDao;
	
	@GetMapping("/get-list-schedule")
	public void getSchedule(HttpServletRequest request,HttpServletResponse response) {
		
		String idFilm = request.getParameter("idFilm");
		List<Schedule> listSchedule = bookingService.getSchedule(Integer.parseInt(idFilm));
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			for (Schedule schedule : listSchedule) {
				pw.println(" <option value="+schedule.getId()+">"+schedule.getDate()+"</option>");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@GetMapping("/get-list-show-time")
	public void getShowTime(HttpServletRequest request,HttpServletResponse response) {

		String idSchedule = request.getParameter("idSchedule");
		List<Showtime> listShowtime = bookingService.getShowtime(Integer.parseInt(idSchedule));
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			for (Showtime showtime : listShowtime) {
				pw.println(" <option value="+showtime.getId()+">"+showtime.getStartTime()+" - "+showtime.getEndTime()+"</option>");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@GetMapping("/get-list-room")
	public void getRoom(HttpServletRequest request,HttpServletResponse response) {
		
		List<Room> listRoom = bookingService.getRoom();
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			for (Room room : listRoom) {
				pw.println(" <option value="+room.getId()+">"+room.getRoomName()+"</option>");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@GetMapping("/get-list-seat")
	public void getSeat(HttpServletRequest request,HttpServletResponse response) {
		String idFilm = request.getParameter("idFilm");
		String idRoom = request.getParameter("idRoom");
		String idShowtime = request.getParameter("idShowtime");
		String idSchedule = request.getParameter("idSchedule");
		List<Seat> listSeat = bookingService.getseat(Integer.parseInt(idRoom),Integer.parseInt(idShowtime),Integer.parseInt(idFilm),Integer.parseInt(idSchedule));
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			for (Seat seat : listSeat) {
				pw.println(" <option value="+seat.getId()+">"+seat.getSeatName()+"</option>");
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@PostMapping("/bookticket")
	public @ResponseBody ResponseAjax Bookticket(HttpServletRequest request,HttpServletResponse response) {
		ResponseAjax rA = new ResponseAjax();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Booking booking = new Booking();
		String idSchedule = request.getParameter("idSchedule");
		String idFilm = request.getParameter("idFilm");
		String idShowtime = request.getParameter("idShowtime");
		String idRoom = request.getParameter("idRoom");
		String idSeat = request.getParameter("idSeat");
		booking.setScheduleId(Integer.parseInt(idSchedule));
		booking.setFilmId(Integer.parseInt(idFilm));
		booking.setRoomId(Integer.parseInt(idRoom));
		List<Integer> arrSeat = bookingDao.convertStringArray(idSeat);
		int amount = GIA_VE * arrSeat.size();
		booking.setAmount(amount);	
		if("0".equals(idSchedule)||"0".equals(idShowtime)||"0".equals(idRoom)||"0".equals(idSeat)) {
			rA.setStatus("ErrorEmpty");
			rA.setMessage("❌ Cần chọn đầy đủ thông tin");
		}else {
			if(user == null) {
				rA.setStatus("ErrorLogin");
				rA.setMessage("❌ Bạn cần phải đăng nhập");
			}else {
				boolean resultBooking = false;
				booking.setShowtimeId(Integer.parseInt(idShowtime));
				booking.setUserId(user.getId());
				for (int i = 0; i < arrSeat.size(); i++) {
					booking.setSeatId(arrSeat.get(i));
					 resultBooking = bookingDao.bookingTicket(booking);
				}			
				if(resultBooking) {
					rA.setStatus("Success");
					rA.setMessage("✅ Đặt vé thành công");
				}else {
					rA.setStatus("Error");
					rA.setMessage("❌ Đặt vé thất bại");
				}
			}
		
		}
		return rA; 	
	
	}

}
