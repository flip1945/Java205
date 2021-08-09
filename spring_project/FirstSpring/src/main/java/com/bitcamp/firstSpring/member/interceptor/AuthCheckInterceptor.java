package com.bitcamp.firstSpring.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1. 로그인 여부 확인
		
		HttpSession session = request.getSession(false);
		
		// 2. 로그인 상태에 따라 true / false로 return
		if (session != null && session.getAttribute("loginInfo") != null) {
			return true;
		}
		// 3. 로그인 상태가 아니라면 로그인 페이지로 redirect
		response.sendRedirect(request.getContextPath()+"/member/login");
		return false;
	}

	
}