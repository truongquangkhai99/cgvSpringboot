package com.cgv.service.Admin;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cgv.models.Room;
import com.cgv.models.Schedule;

@Service
public interface AdminScheduleService {
	public List<Schedule> getAll();
	
	public boolean insert(Schedule schedule);
	
	public boolean delete(int id);
	
	public boolean edit(Schedule id);
	
	public Schedule getName(int id);
}
