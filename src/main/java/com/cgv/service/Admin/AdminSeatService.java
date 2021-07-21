package com.cgv.service.Admin;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cgv.models.Seat;



@Service
public interface AdminSeatService {
	public List<Seat> getAll();
	
	public boolean insert(Seat seat);
	
	public boolean delete(int id);
	
	public boolean edit(Seat id);
}
