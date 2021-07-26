package com.cgv.service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cgv.models.Booking;
@Service

public interface AdminBookingService {
	public List<Booking> getAll();
	
	
	
	public boolean edit(Booking id);
	
	public List<Booking> getHis(int id);
}
