package com.cgv.models;

public class Seat {
	private int id;
	private String seatName;
	private int status;
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
	public int isStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Seat(int id, String seatName, int status) {
		super();
		this.id = id;
		this.seatName = seatName;
		this.status = status;
	}
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Seat [id=" + id + ", seatName=" + seatName + ", status=" + status + "]";
	}
	

}
