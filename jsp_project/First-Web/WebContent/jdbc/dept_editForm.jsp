<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 전달한 부서번호 받기
	String deptno = request.getParameter("deptno");

	Connection conn = null;
	DeptDao dao = null;
	
	try {
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
		
		request.setAttribute("dept", dao.selectByDeptno(conn, Integer.parseInt(deptno)));
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(conn);
	}
%>
<jsp:forward page="form_view.jsp"/>