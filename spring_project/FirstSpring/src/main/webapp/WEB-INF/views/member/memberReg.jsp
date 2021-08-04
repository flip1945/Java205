<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Member Reg Data</h1>
	<hr>
	
	<table>
		<tr>
			<td>아이디</td>
			<td>${mid}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${mpw}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${mname}</td>
		</tr>
	</table>
</body>
</html>