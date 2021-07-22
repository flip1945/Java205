<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieBox cBox = new CookieBox(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 보기</title>
<style>
</style>
<script>
</script>
</head>
<body>
	name = <%= cBox.getValue("name") %> <br>
	number = <%= cBox.getValue("number1") %> <br>
	age = <%= cBox.getValue("age") %> <br>
	<%-- <%
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			
			if (name.equals("cname")) {
				out.println("<h1>" + name + " = " + value + "</h1>");
			}
		}
	%> --%>
	<a href="editCookie.jsp">쿠키 수정</a>
	<a href="deleteCookie.jsp">쿠키 삭제</a>
</body>
</html>