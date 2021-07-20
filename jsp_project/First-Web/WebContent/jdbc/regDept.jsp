<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 1. 사용자가 입력한 데이터를 받고
	request.setCharacterEncoding("utf-8");

	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	String sqlInsert = "insert into dept values(?, ?, ?)";
	
	int resultCnt = 0;

	// 2. DB 처리 : insert
	try (Connection conn = ConnectionProvider.getConnection();
		 PreparedStatement pstmt = conn.prepareStatement(sqlInsert);) {
		Class.forName("com.mysql.cj.jdbc.Driver");

		// PreparedStatement
		pstmt.setInt(1, Integer.parseInt(deptno));
		pstmt.setString(2, dname);
		pstmt.setString(3, loc);
		
		resultCnt = pstmt.executeUpdate();
	} catch (Exception e) {
		
	}
	
	// 3. dept_list.jsp 이동 처리(sendRedirect, js의 a태그 이용)
	// response.sendRedirect("dept_list.jsp");
	
	if (resultCnt > 0) {
		%>
		<script>
			alert('등록됐습니다.');
			location.href = 'dept_list.jsp';
		</script>
		<%
	} else {
		%>
		<script>
			alert('오류 발생으로 등록에 실패했습니다.\n입력페이지로 다시 이동합니다.');
			/* location.href = 'dept_regForm.jsp'; */
			window.history.go(-1);
		</script>
		<%
	}
%>