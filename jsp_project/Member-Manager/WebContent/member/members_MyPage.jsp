<%@page import="member.dto.LoginInfo"%>
<%@page import="member.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<style>
</style>

<%-- <c:if test="${loginInfo == null}">
	<script>
		alert('로그인이 필요한 페이지입니다.\n로그인 후 사용해주세요.');
		location.href = "members_LoginForm.jsp";
	</script>
</c:if> --%>

<script>
</script>
</head>
<body>
	<h1>My Page</h1>
	<hr>
	
	<h3><c:out value="${loginInfo}"/></h3>
</body>
</html>