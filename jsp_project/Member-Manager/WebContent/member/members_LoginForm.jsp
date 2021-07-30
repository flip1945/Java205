<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 로그인 페이지</title>
<link rel="stylesheet" href="<c:url value='/css/default.css'/>">
<style>
	h3 {
		margin: 20px;
	}
	
	table {
		margin: 10px;
	}
	
	table td, table th {
		padding: 5px 10px;
		text-align: center;
	}
	
	table .td_left  {
		text-align: left;
	}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/frame/header.jsp" %>
	
	<hr>
	
	<h3>멤버 로그인</h3>
	
	<form action="<c:url value="/member/members_Login.jsp"/>" method="post">
		<table>
			<tr>
				<td>
					<label for="userId"><b>ID</b></label>
				</td>
				<td>
					<input type="text" name="userId" id="userId" value="${cookie.rememId.value}">
				</td>
			</tr>
			<tr>
				<td>
					<label for="userPw"><b>PW</b></label>
				</td>
				<td>
					<input type="password" name="userPw" id="userPw">
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td class="td_left">
					<input type="checkbox" name="rememId" id="rememId" value="on" ${cookie.rememId eq null ? '' : 'checked'}>
					<label for="rememId">아이디 기억하기</label>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td class="td_left">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>