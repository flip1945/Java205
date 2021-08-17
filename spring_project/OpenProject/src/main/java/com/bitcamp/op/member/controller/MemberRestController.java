package com.bitcamp.op.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.service.MemberRestService;

@RestController
public class MemberRestController {
	
	@Autowired
	private MemberRestService restService;
	
	@GetMapping("/members/{idx}")
	public Member getMember(@PathVariable("idx") int idx) {
		return restService.getMember(idx);
	}
	
	@GetMapping("/members")
	public List<Member> getMembers() {
		return restService.getMembers();
	}

}
