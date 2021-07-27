package com.cgv.dao.Admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.Schedule;
import com.cgv.models.Showtime;



@Repository
public interface AdminShowtimeDao {
	public List<Showtime> getAll();
	
	public boolean insert(Showtime showtime);
	
	public boolean delete(int id);
	
	public boolean edit(Showtime showtime);
	
	public Showtime getName(int id);
}
