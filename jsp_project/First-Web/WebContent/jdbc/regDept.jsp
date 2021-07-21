<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="dept.domain.Dept"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 사용자가 입력한 데이터를 받고
	request.setCharacterEncoding("utf-8");

	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	int resultCnt = 0;
	
	Connection conn = null;
	DeptDao dao = null;

	// DB 처리 : insert
	try {
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
		
		resultCnt = dao.insertDept(conn, new Dept(Integer.parseInt(deptno), dname, loc));
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(conn);
	}
	
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