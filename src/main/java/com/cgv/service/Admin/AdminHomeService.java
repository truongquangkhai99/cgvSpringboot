package com.cgv.service.Admin;

import org.springframework.stereotype.Service;

@Service
public interface AdminHomeService {
	public int countFilm();
	public int countUser();
	public int countBooking();
	public double totalMoney();
}
