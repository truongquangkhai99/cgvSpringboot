package com.cgv.serviceImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminSeatDao;
import com.cgv.models.Seat;
import com.cgv.service.Admin.AdminSeatService;

@Service
public class AdminSeatServiceimpl implements AdminSeatService{
	@Autowired
	public AdminSeatDao adminSeatDao;
	@Override
	public List<Seat> getAll(){
		return adminSeatDao.getAll();
	}
	@Override
	public boolean insert(Seat seat) {
		return adminSeatDao.insert(seat);
	}
	@Override
	public boolean delete(int id) {
		return adminSeatDao.delete(id);
	}
	@Override
	public boolean edit(Seat seat) {
		return adminSeatDao.edit(seat);
	}
}
