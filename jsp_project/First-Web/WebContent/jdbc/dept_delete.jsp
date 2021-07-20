<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 전달하는 deptno 받고
	String deptno = request.getParameter("deptno");
	
	// DB에 있는 데이터를 삭제
	
	String sqlInsert = "delete from dept where deptno=?";
	
	int resultCnt = 0;

	// 2. DB 처리 : update
	try (Connection conn = ConnectionProvider.getConnection();
		 PreparedStatement pstmt = conn.prepareStatement(sqlInsert);){
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		// PreparedStatement
		pstmt.setInt(1, Integer.parseInt(deptno));
		
		resultCnt = pstmt.executeUpdate();
	} catch (Exception e) {
		
	}
	
	// 결과 반환
	if (resultCnt > 0) {
		%>
		<script>
			alert('삭제됐습니다.');
			location.href = 'dept_list.jsp';
		</script>
		<%
	} else {
		%>
		<script>
			alert('오류 발생으로 삭제에 실패했습니다.\n입력페이지로 다시 이동합니다.');
			/* location.href = 'dept_editForm.jsp'; */
			window.history.go(-1);
		</script>
		<%
	}
%>