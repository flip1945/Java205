<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// dept_list.jsp -> 요청을 받고 처리
	Connection conn = null;
	DeptDao dao = null;
	
	try {
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
		
		request.setAttribute("result", dao.getDeptList(conn));	
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(conn);
	}
%>
<jsp:forward page="list_view.jsp"/>