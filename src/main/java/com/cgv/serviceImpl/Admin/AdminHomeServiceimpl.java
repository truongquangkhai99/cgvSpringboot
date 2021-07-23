package com.cgv.serviceImpl.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminHomeDao;
import com.cgv.service.Admin.AdminHomeService;

@Service
public class AdminHomeServiceimpl implements AdminHomeService{
	@Autowired
	public AdminHomeDao adminHomeDao;
	@Override
	public int countFilm() {
		return adminHomeDao.countFilm();
	}
	@Override
	public int countUser() {
		return adminHomeDao.countUser();
	}
	@Override
	public int countBooking() {
		return adminHomeDao.countBooking();
	}
	@Override
	public double totalMoney() {
		return adminHomeDao.totalMoney();
	}
}
