<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
<%
	Enumeration<String> e =  application.getAttributeNames();

	while (e.hasMoreElements()) {
		String name = e.nextElement();
		out.println(name + " = " + application.getAttribute(name) + "<br><br>");
	}
%>

	<h3><a href="removeAttr.jsp">속성 삭제</a></h3>
</body>
</html>