package com.deep.backend.dao;

import java.util.List;

import com.deep.backend.dto.Product;

public interface ProductDAO {
	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(int id);
	Product getProduct(int id);
	
	List<Product> listProducts();
	
}
