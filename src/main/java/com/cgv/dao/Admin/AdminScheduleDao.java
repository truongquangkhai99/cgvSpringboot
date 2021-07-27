package com.cgv.dao.Admin;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.cgv.models.Schedule;

@Repository
public interface AdminScheduleDao {
	public List<Schedule> getAll();
	
	public boolean insert(Schedule schedule);
	
	public boolean delete(int id);
	
	public boolean edit(Schedule id);
	
	public Schedule getName(int id);
}
