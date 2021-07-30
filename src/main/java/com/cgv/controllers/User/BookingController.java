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

import com.cgv.controllers.Admin.RoomAdminController;
import com.cgv.controllers.Admin.ScheduleAdminController;
import com.cgv.controllers.Admin.ShowtimeAdminController;
import com.cgv.dao.User.BookingDao;
import com.cgv.models.Booking;
import com.cgv.models.BookingResponse;
import com.cgv.models.Film;
import com.cgv.models.ResponseAjax;
import com.cgv.models.Room;
import com.cgv.models.Schedule;
import com.cgv.models.Seat;
import com.cgv.models.Showtime;
import com.cgv.models.User;
import com.cgv.serviceImpl.Admin.AdminRoomServiceimpl;
import com.cgv.serviceImpl.Admin.AdminScheduleServiceimpl;
import com.cgv.serviceImpl.Admin.AdminShowtimeServiceimpl;
import com.cgv.serviceImpl.User.BookingServiceImpl;
import com.cgv.serviceImpl.User.FilmServiceimpl;
import com.cgv.serviceImpl.User.SeatServiceImpl;

@Controller
@RequestMapping("/user")
public class BookingController {
	
	public static final int GIA_VE = 65000;
	
	@Autowired
	public BookingServiceImpl bookingService;
	
	@Autowired
	public BookingDao bookingDao;
	
	@Autowired
	public FilmServiceimpl filmService;
	
	@Autowired
	public AdminRoomServiceimpl roomAdminService;
	
	@Autowired
	public AdminScheduleServiceimpl scheduleService;
	
	@Autowired
	public AdminShowtimeServiceimpl showtimeService;
	
	
	
	@Autowired
	public SeatServiceImpl seatImpl;
	
	@GetMapping("/get-list-schedule")
	public void getSchedule(HttpServletRequest request,HttpServletResponse response) {
		
		String idFilm = request.getParameter("idFilm");
		List<Schedule> listSchedule = bookingService.getSchedule(Integer.parseInt(idFilm));
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			for (Schedule schedule : listSchedule) {
				pw.println(" <option value="+schedule.getId()+">"+schedule.getDateschedule()+"</option>");
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
		BookingResponse bookingR = new BookingResponse();
		String idSchedule = request.getParameter("idSchedule");
		String idFilm = request.getParameter("idFilm");
		String idShowtime = request.getParameter("idShowtime");
		String idRoom = request.getParameter("idRoom");
		String idSeat = request.getParameter("idSeat");
		Film film = filmService.getDetailFilm(Integer.parseInt(idFilm));
		Schedule schedule = scheduleService.getName(Integer.parseInt(idSchedule));
		Room room = roomAdminService.getName(Integer.parseInt(idRoom));
		Showtime showtime = showtimeService.getName(Integer.parseInt(idShowtime));
		bookingR.setFilmName(film.getFilmName());
		bookingR.setRoomName(room.getRoomName());
		bookingR.setScheduleName(schedule.getDateschedule());
		String thoigian = showtime.getStartTime() + "-" +showtime.getEndTime();
		bookingR.setShowtimeName(thoigian);
		bookingR.setAmount(GIA_VE);
		booking.setScheduleId(Integer.parseInt(idSchedule));
		booking.setFilmId(Integer.parseInt(idFilm));
		booking.setRoomId(Integer.parseInt(idRoom));
		List<Integer> arrSeat = bookingDao.convertStringArray(idSeat);
		List<String> arrSend = new ArrayList<String>();
		int amount = GIA_VE ;
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
				bookingR.setAmount(GIA_VE * arrSeat.size());
				for (int i = 0; i < arrSeat.size(); i++) {
					Seat seata = seatImpl.getNameSeat(arrSeat.get(i));
					System.out.println(seata);
					arrSend.add(seata.getSeatName());
					booking.setSeatId(arrSeat.get(i));
					resultBooking = bookingDao.bookingTicket(booking);
				}			
				if(resultBooking) {
					rA.setStatus("Success");
					rA.setMessage("✅ Đặt vé thành công");
					rA.setNameSeat(arrSend);
					rA.setListName(bookingR);
					
				}else {
					rA.setStatus("Error");
					rA.setMessage("❌ Đặt vé thất bại");
				}
			}
		
		}
		return rA; 	
	
	}

}
