package com.bitcamp.firstSpring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/view/view1")
	public void getpage1() {
		
	}
	
	@RequestMapping("/view/view2")
	public Model getpage2() {
		Model model = new Model() {
			
			@Override
			public Model mergeAttributes(Map<String, ?> attributes) {
				return null;
			}
			
			@Override
			public boolean containsAttribute(String attributeName) {
				return false;
			}
			
			@Override
			public Map<String, Object> asMap() {
				return null;
			}
			
			@Override
			public Model addAttribute(String attributeName, Object attributeValue) {
				return null;
			}
			
			@Override
			public Model addAttribute(Object attributeValue) {
				return null;
			}
			
			@Override
			public Model addAllAttributes(Map<String, ?> attributes) {
				return null;
			}
			
			@Override
			public Model addAllAttributes(Collection<?> attributeValues) {
				return null;
			}
		};
		
		return model;
		
	}
	

	@RequestMapping("/view/view3")
	public Map<String, Object> getpage3() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "COOL");
		
		return map;
	}
}
