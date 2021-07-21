package com.cgv.dao.Admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.CategoryPost;



@Repository
public interface AdminCategoryPostDao {
	public List<CategoryPost> getAll();
	
	public boolean insert(CategoryPost categoryPost);
	
	public boolean delete(int id);
	
	public boolean edit(CategoryPost id);
}
