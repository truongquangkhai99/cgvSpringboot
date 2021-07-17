package com.cgv.models;

public class Showtime {
	private int id;
	private int scheduleId;
	private String startTime;
	private String endTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Showtime(int id, int scheduleId, String startTime, String endTime) {
		super();
		this.id = id;
		this.scheduleId = scheduleId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Showtime() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Showtime [id=" + id + ", scheduleId=" + scheduleId + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}
	

}
