package com.cgv.models;

public class RoomSeat {
	private int roomId;
	private int seatId;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public RoomSeat(int roomId, int seatId) {
		super();
		this.roomId = roomId;
		this.seatId = seatId;
	}
	public RoomSeat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RoomSeat [roomId=" + roomId + ", seatId=" + seatId + "]";
	}
	
	

}
