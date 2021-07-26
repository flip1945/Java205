<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="member.dto.Member"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.SQLException"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String userName = request.getParameter("userName");
	
	Connection conn = null;
	MemberDao dao = null;
	
	int result = 0;
	
	try {
		conn = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		
		result = dao.updateMember(conn, new Member(userId, userPw, userName));
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(conn);
	}
	
	if (result > 0) {
		%>
		<script>
			alert('수정됐습니다.');
			location.href = 'members_Index.jsp';
		</script>
		<%
	} else {
		%>
		<script>
			alert('오류로 인해 수정에 실패했습니다.\n다시 수정해주세요.');
			window.history.go(-1);
		</script>
		<%
	}
%>