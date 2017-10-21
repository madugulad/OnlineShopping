package com.deep.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value= {"/", "/home", "index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","test spring MVC");
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
