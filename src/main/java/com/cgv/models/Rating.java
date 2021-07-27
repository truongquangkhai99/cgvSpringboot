package com.cgv.models;

public class Rating {
	
	private int id;
	private int filmId;
	private String rate;
	private int userId;
	private String created_time;
	private String name_user;
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
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	public Rating(int id, int filmId, String rate, int userId, String created_time, String name_user) {
		super();
		this.id = id;
		this.filmId = filmId;
		this.rate = rate;
		this.userId = userId;
		this.created_time = created_time;
		this.name_user = name_user;
	}
	@Override
	public String toString() {
		return "Rating [id=" + id + ", filmId=" + filmId + ", rate=" + rate + ", userId=" + userId + ", created_time="
				+ created_time + ", name_user=" + name_user + "]";
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
