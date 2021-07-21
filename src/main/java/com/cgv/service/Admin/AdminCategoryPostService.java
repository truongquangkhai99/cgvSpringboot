package com.cgv.service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cgv.models.CategoryPost;


@Service

public interface AdminCategoryPostService {
	public List<CategoryPost> getAll();
	
	public boolean insert(CategoryPost categoryPost);
	
	public boolean delete(int id);
	
	public boolean edit(CategoryPost id);
}
