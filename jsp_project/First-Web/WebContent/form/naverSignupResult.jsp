<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String userName = request.getParameter("userName");
	String birthYear = request.getParameter("birthYear");
	String birthMonth = request.getParameter("birthMonth");
	String birthDay = request.getParameter("birthDay");
	String userSex = request.getParameter("userSex");
	String userEmail = request.getParameter("userEmail");
	String userPhone = request.getParameter("userPhone");
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
		<tr>
			<td>이름</td>
			<td><%= userName %></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><%= birthYear %>년 <%= birthMonth %>월 <%= birthDay %>일</td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%= userSex %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%= userEmail %></td>
		</tr>
		<tr>
			<td>휴대폰 번호</td>
			<td><%= userPhone %></td>
		</tr>
	</table>
</body>
</html>