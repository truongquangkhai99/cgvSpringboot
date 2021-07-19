package com.cgv.dao.User;

import java.util.List;

import com.cgv.models.Post;

public interface PostDao {
	public List<Post> getPromotion();
	public List<Post> getInfor();
	public Post getDetail(int id);
}
