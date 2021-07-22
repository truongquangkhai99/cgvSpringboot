package com.cgv.models;

public class Rating {
	
	private int id;
	private int filmId;
	private String rate;
	private int userId;
	private String createTime;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Rating(int id, int filmId, String rate, int userId, String createTime) {
		super();
		this.id = id;
		this.filmId = filmId;
		this.rate = rate;
		this.userId = userId;
		this.createTime = createTime;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Rating [id=" + id + ", filmId=" + filmId + ", rate=" + rate + ", userId=" + userId + ", createTime="
				+ createTime + "]";
	}
	
}
