package com.cgv.serviceImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminRoomDao;
import com.cgv.models.Room;
import com.cgv.service.Admin.AdminRoomService;

@Service
public class AdminRoomServiceimpl implements AdminRoomService{
	@Autowired
	public AdminRoomDao adminRoomDao;
	@Override
	public List<Room> getAll(){
		return adminRoomDao.getAll();
	}
	@Override
	public boolean insert(Room room) {
		return adminRoomDao.insert(room);
	}
	@Override
	public boolean delete(int id) {
		return adminRoomDao.delete(id);
	}
	@Override
	public boolean edit(Room room) {
		return adminRoomDao.edit(room);
	}
	@Override
	public Room getName(int id) {
		// TODO Auto-generated method stub
		return adminRoomDao.getName(id);
	}
}
