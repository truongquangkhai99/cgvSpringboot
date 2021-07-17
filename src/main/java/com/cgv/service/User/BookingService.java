package com.cgv.service.User;

import org.springframework.stereotype.Service;

import com.cgv.models.Booking;

@Service
public interface BookingService {
	public boolean bookingTicket(Booking booking);
}
