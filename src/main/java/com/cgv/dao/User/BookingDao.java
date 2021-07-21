package com.cgv.dao.User;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.cgv.models.Booking;
import com.cgv.models.Room;

import com.cgv.models.Schedule;
import com.cgv.models.Seat;
import com.cgv.models.Showtime;


@Repository
public interface BookingDao {
	
	public boolean bookingTicket(Booking booking);
	
	public List<Schedule> getSchedule(int idFilm);
	
	public List<Showtime> getShowtime(int idSchedule);
	
	public List<Seat> getseat(int roomId,int showtimeId , int idFilm,int schedule_id);

	public List<Room> getRoom();
	
	public List<Integer> convertStringArray(String str);
	

}
