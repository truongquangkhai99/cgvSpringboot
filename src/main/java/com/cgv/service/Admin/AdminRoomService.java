package com.cgv.service.Admin;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cgv.models.Room;


@Service
public interface AdminRoomService {
	public List<Room> getAll();
	
	public boolean insert(Room room);
	
	public boolean delete(int id);
	
	public boolean edit(Room id);
	
	public Room getName(int id);
}
