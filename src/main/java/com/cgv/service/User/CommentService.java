package com.cgv.service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cgv.models.Rating;

@Service
public interface CommentService {
	public List<Rating> getCommentById(int id);
	public boolean comment(Rating rating);
}
