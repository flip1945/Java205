<%@page import="member.dto.LoginInfo"%>
<%@page import="member.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<style>
</style>
<%
	if(loginInfo == null) {
		%>
		<script>
			alert('로그인이 필요한 페이지입니다.\n로그인 후 사용해주세요.');
			location.href = "members_LoginForm.jsp";
		</script>
		<%
	}
%>
<script>
</script>
</head>
<body>
	<h1>My Page</h1>
	<hr>
	
	<h3><%= loginInfo %></h3>
</body>
</html>