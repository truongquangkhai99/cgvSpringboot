package com.cgv.models;

public class Seat {
	private int id;
	private String seatName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public Seat(int id, String seatName) {
		super();
		this.id = id;
		this.seatName = seatName;
	}
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Seat [id=" + id + ", seatName=" + seatName + "]";
	}
	
}
