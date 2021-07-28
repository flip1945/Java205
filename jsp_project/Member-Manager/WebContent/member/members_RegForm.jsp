<%@page import="member.dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 등록 페이지</title>
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
	
	table #bnt_reset {
		text-align: left;
	}
	
</style>
</head>
<body>
	
	<h1>멤버 리스트</h1>
	<hr>
	
	<form action="members_Reg.jsp" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<label for="memberid"><b>ID</b></label>
				</td>
				<td>
					<input type="text" name="memberid" id="memberid">
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