<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// dept_list.jsp -> 요청을 받고 처리
	
	String sqlSelect = "select * from dept";
	try (Connection conn = ConnectionProvider.getConnection();
		 Statement stmt = conn.createStatement();) {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (ResultSet rs = stmt.executeQuery(sqlSelect);) {
			List<Dept> deptList = new ArrayList<Dept>();
			
			while (rs.next()) {
				deptList.add(new Dept(
						rs.getInt("deptno"), 
						rs.getString("dname"), 
						rs.getString("loc")));
			}
			out.println(deptList);
			request.setAttribute("result", deptList);
		}
	}
%>
<jsp:forward page="list_view.jsp"/>