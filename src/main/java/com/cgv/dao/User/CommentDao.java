package com.cgv.dao.User;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.Rating;

@Repository
public interface CommentDao {
	public List<Rating> getCommentById(int id);
	public boolean comment(Rating rating);
}
