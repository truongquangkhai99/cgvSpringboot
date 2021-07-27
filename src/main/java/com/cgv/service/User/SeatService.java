package com.cgv.service.User;

import org.springframework.stereotype.Service;

import com.cgv.models.Seat;

@Service
public interface SeatService {
	public Seat getNameSeat(int id);
}
