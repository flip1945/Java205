<%@page import="member.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "손흥민");
	session.setAttribute("name", "이강인");
	application.setAttribute("name", "메시");
	
	Member member = new Member();
	member.setId("cool");
	member.setName("COOL");
	member.setPw("1234");
	session.setAttribute("member", member);
%>
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
	표현식 : <span> <%= request.getAttribute("name") %> </span> <br>
	표현언어1 : <span>${requestScope.name}</span> <br> <br>
	
	내장 객체의 표현식이 생략됐을 때 규칙 <br> <br>
	1. pageScope의 속성을 찾는다. <br>
	2. requestScope의 속성을 찾는다. <br>
	3. sessionScope의 속성을 찾는다. <br>
	4. applicationScope의 속성을 찾는다.  <br> <br>
	
	표현언어2 : <span>${name}</span> <br>
	표현언어3 : <span>${sessionScope.name}</span> <br>
	표현언어3 : <span>${applicationScope.name}</span> <br>
	<br>
	
	<hr>
	param.code : <%= request.getParameter("code") %> <br>
	param.code : ${param.code} <br>
	
	<hr>
	pageContext : <%= pageContext.getRequest().getServletContext().getContextPath() %> <br>
	${pageContext.request.requestURL} <br>
	${pageContext.request.requestURI} <br>
	${pageContext.request.contextPath} <br>
	<%= request.getContextPath() %>
	<br>
	
	${true} / ${false} / ${100} /${'손흥민'} / ${null}
	<br>
	
	<hr>
	
	${member} / ${member.id} <br>
	<%= session.getAttribute("member") %> / 
	<%= ((Member)session.getAttribute("member")).getId() %>
</body>
</html>