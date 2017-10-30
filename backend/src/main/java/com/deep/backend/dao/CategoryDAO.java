package com.deep.backend.dao;

import java.util.List;

import com.deep.backend.dto.Category;

public interface CategoryDAO {

	
	
	List<Category> list();
	
	Category getCategory(int id);
	
	boolean add(Category category);
	
	boolean update(Category category);
	
	boolean delete(int id);
}
