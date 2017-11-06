package com.deep.backend.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deep.backend.dao.ProductDAO;
import com.deep.backend.dto.Product;

public class ProductTestCase {
	
	public static AnnotationConfigApplicationContext context;
	public static ProductDAO productDAO;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.deep.backend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	
	
	@Test
	public void listProducts() {
		List<Product> products = productDAO.listProducts();
		
		assertEquals("test list products", 5, products.size());
	}
}
