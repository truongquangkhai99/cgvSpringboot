package com.cgv.serviceImpl.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgv.dao.User.CommentDao;
import com.cgv.models.Rating;
import com.cgv.service.User.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	public CommentDao commentDao;

	@Override
	public List<Rating> getCommentById(int id) {
		// TODO Auto-generated method stub
		return commentDao.getCommentById(id);
	}

	@Override
	public boolean comment(Rating rating) {
		// TODO Auto-generated method stub
		return commentDao.comment(rating);
	}

}
