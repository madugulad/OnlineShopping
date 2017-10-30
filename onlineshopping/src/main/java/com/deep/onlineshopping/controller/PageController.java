package com.deep.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.deep.backend.dao.CategoryDAO;
import com.deep.backend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/", "/home", "index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("id","home");
		mv.addObject("title","Home page");
		mv.addObject("userClickHome", true);
		
		mv.addObject("categories",categoryDAO.list());
		
		return mv;
	}
	
	@RequestMapping(value= {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("id","about");
		mv.addObject("title","About Page");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value= {"/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("id","contact");
		mv.addObject("title","Contact Page");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping("/show/all/products")
	public ModelAndView getAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("id","products");
		mv.addObject("title","all products");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		
		return mv;
	}
	
	@RequestMapping("/show/category/{id}/products")
	public ModelAndView getCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		Category c = categoryDAO.getCategory(id);
		
		mv.addObject("id",c.getName());
		mv.addObject("title",c.getName());
		
		mv.addObject("userClickCategoryProducts", true);
		
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("category",c);
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam("greeting") String testParam) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", testParam);
		return mv;
	}
	
	@RequestMapping(value="test/{testVar1}")
	public ModelAndView testPathVar(@PathVariable("testVar1")String str) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", str);
		return mv;
	}
}
