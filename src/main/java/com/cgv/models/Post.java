package com.cgv.models;

public class Post {
	private int id;
	private String title;
	private String description;
	private String createTime;
	private int categoryPost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getCategoryPost() {
		return categoryPost;
	}
	public void setCategoryPost(int categoryPost) {
		this.categoryPost = categoryPost;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(int id, String title, String description, String createTime, int categoryPost) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createTime = createTime;
		this.categoryPost = categoryPost;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", createTime=" + createTime
				+ ", categoryPost=" + categoryPost + "]";
	}
	

}
