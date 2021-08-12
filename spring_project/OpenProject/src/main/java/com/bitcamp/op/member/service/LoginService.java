package com.bitcamp.op.member.service;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.Dao;
import com.bitcamp.op.member.domain.Member;

@Service
public class LoginService {
	
	@Autowired
	private SqlSessionTemplate template;
	private Dao dao;

	public boolean login(String id, String pw, String reid, HttpSession session, HttpServletResponse response) {
		boolean loginChk = false;

		try {
			dao = template.getMapper(Dao.class);
			Member member = dao.selectByIdPw(id, pw);
			
			if (member != null) {
				session.setAttribute("loginInfo", member.toLoginInfo());
				
				loginChk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (reid != null && reid.length() > 0) {
			Cookie cookie = new Cookie("reid", id);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*365);
			
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("reid", id);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			
			response.addCookie(cookie);
		}

		return loginChk;
	}
}
