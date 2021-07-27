package com.cgv.service.Admin;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cgv.models.Showtime;



@Service
public interface AdminShowtimeService {
	public List<Showtime> getAll();
	
	public boolean insert(Showtime showtime);
	
	public boolean delete(int id);
	
	public boolean edit(Showtime id);
	
	public Showtime getName(int id);
}

