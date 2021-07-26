package com.cgv.serviceImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminBookingDao;
import com.cgv.models.Booking;
import com.cgv.service.Admin.AdminBookingService;

@Service
public class AdminBookingServiceimpl implements AdminBookingService{
	@Autowired
	public AdminBookingDao adminBookingDao;
	@Override
	public List<Booking> getAll(){
		return adminBookingDao.getAll();
	}
	@Override
	public boolean edit(Booking id) {
		return adminBookingDao.edit(id);
	}
	@Override
	public List<Booking> getHis(int id) {
		return adminBookingDao.getHis(id);
	}
	
}
