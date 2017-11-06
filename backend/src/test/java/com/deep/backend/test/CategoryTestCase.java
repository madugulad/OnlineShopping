package com.deep.backend.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deep.backend.dao.CategoryDAO;
import com.deep.backend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.deep.backend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
//	@Test
//	public void testAddCategory() {
//		category = new Category();
//		
//		category.setName("TV");
//		category.setDescription("TV desc");
//		category.setImageUrl("CAT_3.png");
//		category.setActive(true);
//
//		assertEquals("category add test success", true, categoryDAO.add(category));
//	}
	
//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.getCategory(3);
//
//		assertEquals("fetch category", "TV", category.getName());
//	}
//	
	@Test
	public void testListCategory() {
		List<Category> cts = categoryDAO.list();
		assertEquals("sucecssfully fetched categories", 3, cts.size());
	}
	
	
//	@Test
//	public void crudCategories() {
//		category = new Category();
//		category.setName("TV11");
//		category.setDescription("TV desc");
//		category.setImageUrl("CAT_3.png");
//		category.setActive(true);
//		
//		assertEquals("category add TV11 success", true, categoryDAO.add(category));
//		
//		category.setDescription("updated desc");
//		assertEquals("category add TV11 success", true, categoryDAO.update(category));
//		
//		
//		assertEquals("category add TV11 success", true, categoryDAO.delete(4));
//		
//		List<Category> cts = categoryDAO.list();
//		assertEquals("sucecssfully fetched categories", 3, cts.size());
//		
//		
//	}
//	
	
}
