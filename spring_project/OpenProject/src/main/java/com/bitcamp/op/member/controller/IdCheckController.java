package com.bitcamp.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.op.member.service.IdCheckService;

@Controller
public class IdCheckController {
	
	@Autowired
	private IdCheckService idCheckService;

	@RequestMapping(value = "/member/idcheck", method = RequestMethod.POST)
	@ResponseBody
	public String idCheck(
			@RequestParam("mid") String mid,
			Model model) {
		
		return idCheckService.idCheck(mid);
	}
}
