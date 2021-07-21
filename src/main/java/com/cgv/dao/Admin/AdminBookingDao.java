package com.cgv.dao.Admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.Booking;

@Repository
public interface AdminBookingDao {
	public List<Booking> getAll();
	
	public boolean insert(Booking booking);
	
	public boolean delete(int id);
	
	public boolean edit(Booking id);
}
