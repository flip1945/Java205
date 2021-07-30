<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.SQLException"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String userId = request.getParameter("id");

	Connection conn = null;
	MemberDao dao = null;
	
	int result = 0;
	
	try {
		conn = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		
		result = dao.deleteMemberById(conn, userId);
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(conn);
	}
	
	if (result > 0) {
		%>
		<script>
			alert('삭제됐습니다.');
			location.href = '<c:url value="/list.do"/>';
		</script>
		<%
	} else {
		%>
		<script>
			alert('오류로 인해 삭제에 실패했습니다.\n다시 삭제해주세요.');
			location.href = '<c:url value="/list.do"/>';
		</script>
		<%
	}
%>