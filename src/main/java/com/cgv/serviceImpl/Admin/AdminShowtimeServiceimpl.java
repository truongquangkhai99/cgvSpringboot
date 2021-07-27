package com.cgv.serviceImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminShowtimeDao;
import com.cgv.models.Showtime;
import com.cgv.service.Admin.AdminShowtimeService;
@Service
public class AdminShowtimeServiceimpl implements AdminShowtimeService{
	@Autowired
	public AdminShowtimeDao adminShowtimeDao;
	@Override
	public List<Showtime> getAll(){
		return adminShowtimeDao.getAll();
	}
	@Override
	public boolean insert(Showtime showtime) {
		return adminShowtimeDao.insert(showtime);
	}
	@Override
	public boolean delete(int id) {
		return adminShowtimeDao.delete(id);
	}
	@Override
	public boolean edit(Showtime showtime) {
		return adminShowtimeDao.edit(showtime);
	}
	@Override
	public Showtime getName(int id) {
		// TODO Auto-generated method stub
		return adminShowtimeDao.getName(id);
	}

}
