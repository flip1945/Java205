<%@page import="member.dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	List<Member> members = (List<Member>)request.getAttribute("result");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 정보 페이지</title>
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
	
	button {
		margin: 10px;
	}
	
</style>
</head>
<body>
	
	<h1>멤버 리스트</h1>
	<hr>
	
	<button onclick="location.href='members_RegForm.jsp'">새 멤버 등록</button>
	
	<table border=1>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입일자</th>
			<th>관리</th>
		</tr>
		
		<%
		if (members != null) {
			for (int i = 0; i < members.size(); i++) {
				%>
				<tr>
					<td><%= members.get(i).getId() %></td>
					<td><%= members.get(i).getPw() %></td>
					<td><%= members.get(i).getName() %></td>
					<td><%= members.get(i).getRegDate() %></td>
					<td>
						<a href="members_EditForm.jsp?id=<%= members.get(i).getId() %>">수정</a>
						<a href="javascript:delMember('<%= members.get(i).getId() %>')">삭제</a>
					</td>
				</tr>
				<%
			}
		}
		%>
	</table>
	
	<script>
		function delMember(userId) {
			if (confirm('정말로 삭제하시겠습니까?')) {
				location.href = 'members_Del.jsp?id='+userId;
			}
		}
	</script>
</body>
</html>
