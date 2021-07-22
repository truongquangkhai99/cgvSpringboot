package com.cgv.models;

public class Schedule {
	private int id;
	private int filmId;
	private String dateschedule;
	
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Schedule(int id, int filmId, String dateschedule) {
		super();
		this.id = id;
		this.filmId = filmId;
		this.dateschedule = dateschedule;
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", filmId=" + filmId + ", dateschedule=" + dateschedule + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getDateschedule() {
		return dateschedule;
	}
	public void setDateschedule(String dateschedule) {
		this.dateschedule = dateschedule;
	}
	
	
	
	
	
	
	

	
}
