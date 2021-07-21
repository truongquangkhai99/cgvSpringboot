package com.cgv.serviceImpl.User;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgv.dao.User.BookingDao;
import com.cgv.models.Booking;
import com.cgv.models.Room;
import com.cgv.models.Schedule;
import com.cgv.models.Seat;
import com.cgv.models.Showtime;
import com.cgv.service.User.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	public BookingDao bookingDao;

	@Override
	public boolean bookingTicket(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDao.bookingTicket(booking);
	}

	@Override
	public List<Schedule> getSchedule(int idFilm) {
		// TODO Auto-generated method stub
		return bookingDao.getSchedule(idFilm);
	}

	@Override
	public List<Showtime> getShowtime(int idSchedule) {
		// TODO Auto-generated method stub
		return bookingDao.getShowtime(idSchedule);
	}

	@Override
	public List<Room> getRoom() {
		// TODO Auto-generated method stub
		return bookingDao.getRoom();
	}

	@Override
	public List<Seat> getseat(int roomId,int showtimeId , int idFilm,int schedule_id) {
		// TODO Auto-generated method stub
		return bookingDao.getseat(roomId,showtimeId ,idFilm,schedule_id);
	}



	

}
