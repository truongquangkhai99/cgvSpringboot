package com.cgv.dao.Admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.Room;



@Repository
public interface AdminRoomDao {
	public List<Room> getAll();
	
	public boolean insert(Room room);
	
	public boolean delete(int id);
	
	public boolean edit(Room room);
	
	public Room getName(int id);
}
