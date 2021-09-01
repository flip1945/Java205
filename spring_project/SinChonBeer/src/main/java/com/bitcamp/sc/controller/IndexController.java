package com.bitcamp.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/")
	public String thymeleaf(Model model) {
//		model.addAttribute("name", "Chae Ho Yeon");
		return "thymeleaf";
	}
}
