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
<link rel="stylesheet" href="<c:url value='/css/default.css'/>">
<style>
	 * {
		margin: 0;
		padding: 0;
	}
	
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
	
</style>
</head>
<body>

	<%@ include file="/WEB-INF/frame/header.jsp" %>
	<%@ include file="/WEB-INF/frame/nav.jsp" %>
	
	<h3>회원 리스트</h3>
	
	<table border=1>
		<tr>
			<th>idx</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입일자</th>
			<th>관리</th>
		</tr>
		
		<c:if test="${members != null}">
			<c:forEach items="${members}" var="member">
				<tr>
					<td>${member.idx}</td>
					<td>
						<img src='<c:url value="/upload/${member.memberphoto}"/>' height="30">
						${member.memberid}
					</td>
					<td>${member.password}</td>
					<td>${member.membername}</td>
					<td>${member.regdate}</td>
					<td>
						<a href="<c:url value="/member/members_EditForm.jsp?id=${member.memberid}"/>">수정</a>
						<a href="javascript:delMember('${member.memberid}')">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	<script>
		function delMember(userId) {
			if (confirm('정말로 삭제하시겠습니까?')) {
				location.href = '<c:url value="/member/members_Del.jsp?id="/>'+userId;
			}
		}
	</script>
</body>
</html>
