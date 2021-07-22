<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieBox cBox = new CookieBox(request);

	String rememId = cBox.exists("rememId") ? cBox.getValue("rememId") : "";
	String checked = cBox.exists("rememId") ? "checked" : "";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 로그인 페이지</title>
<style>
	 * {
		margin: 0;
		padding: 0;
	}
	
	h1 {
		margin: 10px;
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
	
	<h1>멤버 로그인</h1>
	<hr>
	
	<form action="members_Login.jsp" method="post">
		<table>
			<tr>
				<td>
					<label for="userId"><b>ID</b></label>
				</td>
				<td>
					<input type="text" name="userId" id="userId" value="<%= rememId %>">
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
					<input type="checkbox" name="rememId" id="rememId" value="on" <%= checked %>>
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