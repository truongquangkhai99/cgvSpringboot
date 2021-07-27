package com.cgv.daoImpl.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.User.BookingDao;
import com.cgv.models.Booking;
import com.cgv.models.Film;
import com.cgv.models.Room;
import com.cgv.models.Schedule;
import com.cgv.models.Seat;
import com.cgv.models.Showtime;


@Repository
public class BookingDaoImpl implements BookingDao{
	
	public static final String GET_SCHEDULE = "SELECT * FROM `schedules` WHERE dateschedule >= DATE(NOW()) AND film_id = ? ";
	public static final String GET_SHOW_TIME = "SELECT * FROM `showtimes` WHERE schedule_id = ?";
	public static final String GET_ROOM = "SELECT * FROM `room`";
	public static final String GET_SEAT = "SELECT * from seats WHERE id NOT IN (SELECT seat_id FROM booking WHERE room_id = ? and showtime_id = ? and film_id =? and schedule_id = ? )  ";
	public static final String BOOKING = "INSERT INTO `booking`(`user_id`, `film_id`, `schedule_id`, `showtime_id`, `room_id`, `seat_id`, `amount`) VALUES (?,?,?,?,?,?,?)";
	
	
	@Autowired
	public JdbcTemplate _jdbcTemplate ;

	@Override
	public boolean bookingTicket(Booking booking) {
		int result = _jdbcTemplate.update(BOOKING,booking.getUserId(),booking.getFilmId(),booking.getScheduleId(),booking.getShowtimeId(),booking.getRoomId(),booking.getSeatId(), booking.getAmount());
		if(result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Schedule> getSchedule(int idFilm) {
		// TODO Auto-generated method stub
		return _jdbcTemplate.query(GET_SCHEDULE, new BeanPropertyRowMapper<>(Schedule.class) , new Object[] {idFilm});
	}

	@Override
	public List<Showtime> getShowtime(int idSchedule) {
		// TODO Auto-generated method stub
		return _jdbcTemplate.query(GET_SHOW_TIME, new BeanPropertyRowMapper<>(Showtime.class) , new Object[] {idSchedule});
	}

	@Override
	public List<Room> getRoom() {
		// TODO Auto-generated method stub
		return _jdbcTemplate.query(GET_ROOM, new BeanPropertyRowMapper<>(Room.class));
	}

	@Override
	public List<Seat> getseat(int roomId,int showtimeId , int idFilm,int schedule_id) {
		// TODO Auto-generated method stub
		return _jdbcTemplate.query(GET_SEAT, new BeanPropertyRowMapper<>(Seat.class), new Object[] {roomId,showtimeId,idFilm,schedule_id});
	}

	@Override
	public List<Integer> convertStringArray(String str) {
		List<Integer> arrSeat = new ArrayList<>();
		for(int i = 0; i<str.length();i++) {
			try {
				Integer.parseInt(String.valueOf(str.charAt(i)));
				arrSeat.add(Integer.parseInt(String.valueOf(str.charAt(i))));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return arrSeat;
	}

	


	



}
