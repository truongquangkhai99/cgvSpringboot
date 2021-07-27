package com.cgv.serviceImpl.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgv.daoImpl.User.SeatDaoImpl;
import com.cgv.models.Seat;
import com.cgv.service.User.SeatService;

@Service
public class SeatServiceImpl implements SeatService {
	@Autowired
	public SeatDaoImpl seatDao;

	@Override
	public Seat getNameSeat(int id) {
		// TODO Auto-generated method stub
		return seatDao.getNameSeat(id);
	}


}
