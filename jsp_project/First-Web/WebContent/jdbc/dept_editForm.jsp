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

	// 부서정보 입력받기
	Dept dept = null;
	String sqlSelect = "select * from dept where deptno = ?";
	
	// DB 연결
	try (Connection conn = ConnectionProvider.getConnection();
		 PreparedStatement pstmt = conn.prepareStatement(sqlSelect);){
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		// PreparedStatement
		pstmt.setInt(1, Integer.parseInt(deptno));
		
		try (ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
			}
		}
		// 부서정보를 form_view.jsp 전달(공유)
		request.setAttribute("dept", dept);
	} catch (Exception e) {
		
	}
%>
<jsp:forward page="form_view.jsp"/>