package com.bitcamp.firstSpring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/reg")
public class MemberRegController {

	@RequestMapping(method = RequestMethod.GET)
	public String getRegForm() {
		return "member/memberRegForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String reg(
			@RequestParam("memberid") String mid,
			@RequestParam("password") String mpw,
			@RequestParam("membername") String mname,
			Model model) {
		
		model.addAttribute("mid", mid);
		model.addAttribute("mpw", mpw);
		model.addAttribute("mname", mname);
		
		return "member/memberReg";
	}
}
