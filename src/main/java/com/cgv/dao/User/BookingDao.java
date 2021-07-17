package com.cgv.dao.User;

import org.springframework.stereotype.Repository;

import com.cgv.models.Booking;

@Repository
public interface BookingDao {
	
	public boolean bookingTicket(Booking booking);

}
