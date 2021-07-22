<%@page import="member.dto.Member"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.SQLException"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 전달한 데이터를 받고 -> DB에서 확인 -> 로그인 처리
	// rememId 확인하고 값을 받아오면 쿠키 설정
	
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String rememId = request.getParameter("rememId");
	
	boolean isLogin = false;
	
	Connection conn = null;
	MemberDao dao = null;
	
	if (userId != null && userPw != null && userId.trim().length() > 2 && userPw.trim().length() > 2) {
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			Member member = dao.getMemberByIdPw(conn, userId, userPw);
			
			if (member != null) {
				// 회원의 정보를 Session 객체에 저장
				session.setAttribute("loginInfo", member.toLoginInfo());
				isLogin = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// ID 저장을 위한 쿠키 설정
	// rememId 값의 유무 체크
	if (rememId != null && rememId.equals("on")) {
		response.addCookie(CookieBox.makeCookie("rememId", userId, "/", 60*60*24*365));
	} else {
		response.addCookie(CookieBox.makeCookie("rememId", userId, "/", 0));
	}
	
	if (isLogin) {
		response.sendRedirect("members_Index.jsp");
	} else {
		%>
		<script>
			alert('아이디 혹은 비밀번호가 일치하지 않습니다.');
			history.go(-1);
		</script>
		<%
	}
%>

