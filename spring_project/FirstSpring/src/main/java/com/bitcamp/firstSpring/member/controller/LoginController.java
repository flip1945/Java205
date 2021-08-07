package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.LoginInfo;
import com.bitcamp.firstSpring.member.domain.LoginRequest;

@Controller
@RequestMapping("/member/login")
public class LoginController {

//	@RequestMapping("/member/loginform")
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm(@RequestParam(value = "page", defaultValue = "1") int page) {
		System.out.println(page+1);
		return "member/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			@RequestParam("id") String id, @RequestParam("pw") String pw,
			HttpServletRequest request,
			LoginRequest lo,
			Model model) {
		
		System.out.println(id + " : " + pw);
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		
		System.out.println(uid + " : " + upw);
		
		model.addAttribute("uid", uid);
		model.addAttribute("upw", upw);
		
		request.getSession(false).setAttribute("loginInfo", new LoginInfo());
		
		return "member/login";
	}
}
