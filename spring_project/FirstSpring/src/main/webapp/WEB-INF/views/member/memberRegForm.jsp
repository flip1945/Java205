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

	<h1>Sign Up</h1>
	<hr>
	
	<form action="<c:url value="/member/members_Reg.jsp"/>" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<label for="memberid"><b>ID</b></label>
				</td>
				<td>
					<input type="text" name="memberid" id="memberid">
					<span id="msg" class="display_none"></span>
					<img id="loadingimg" alt="loading" src="<c:url value="/img/loading.gif"/>" class="display_none">
					
				</td>
			</tr>
			<tr>
				<td>
					<label for="password"><b>PW</b></label>
				</td>
				<td>
					<input type="password" name="password" id="password">
				</td>
			</tr>
			<tr>
				<td>
					<label for="membername"><b>이름</b></label>
				</td>
				<td>
					<input type="text" name="membername" id="membername">
				</td>
			</tr>
			<tr>
				<td>
					<label for="photo"><b>사진</b></label>
				</td>
				<td>
					<input type="file" name="photo" id="photo">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="등록">
				</td>
				<td id="bnt_reset">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>