package com.cgv.dao.Admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.Seat;



@Repository
public interface AdminSeatDao {
	public List<Seat> getAll();
	
	public boolean insert(Seat seat);
	
	public boolean delete(int id);
	
	public boolean edit(Seat seat);
}
