<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	session.invalidate();
%>

<script>
	alert('로그아웃 됐습니다.');
	location.href = "members_Index.jsp";
	<%-- location.href = '<%= request.getContextPath()%>'; --%>
</script>