<%@page import="member.dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<c:if test="${loginInfo == null}">
		<button onclick="location.href='members_RegForm.jsp'">새 멤버 등록</button>
		<button onclick="location.href='members_LoginForm.jsp'">로그인</button>
	</c:if>
	<c:if test="${loginInfo != null}">
		<button onclick="location.href='members_Logout.jsp'">로그아웃</button>
		<button onclick="location.href='members_Index.jsp'">회원리스트</button>
	</c:if>
	<button onclick="location.href='members_MyPage.jsp'">MyPage</button>
	
	<table border=1>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입일자</th>
			<th>관리</th>
		</tr>
		
		<c:if test="${members != null}">
			<c:forEach items="${members}" var="member">
				<tr>
					<td>${member.id}</td>
					<td>${member.pw}</td>
					<td>${member.name}</td>
					<td>${member.regDate}</td>
					<td>
						<a href="members_EditForm.jsp?id=${member.id}">수정</a>
						<a href="javascript:delMember('${member.id}')">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
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
