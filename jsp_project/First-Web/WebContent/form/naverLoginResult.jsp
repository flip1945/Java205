<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<table border=1>
		<tr>
			<td>아이디</td>
			<td><%= userID %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%= userPW %></td>
		</tr>
	</table>
</body>
</html>