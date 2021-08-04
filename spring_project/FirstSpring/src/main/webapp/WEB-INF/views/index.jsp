<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Spring MVC</h1>
	<hr>
	<ul>
		<li><a href="<c:url value='/hello'/>">/greeting</a></li>
		<li><a href="<c:url value='/member/login'/>">/member/loginForm</a></li>
		<li><a href="<c:url value='/member/reg'/>">/member/memberRegForm</a></li>
		<li><a href="<c:url value='/order/order'/>">/order/order</a></li>
	</ul>

</body>
</html>