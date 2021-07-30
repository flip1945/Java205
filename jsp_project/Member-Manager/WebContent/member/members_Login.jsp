<%@page import="member.service.MemberLoginService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	MemberLoginService.getInstance().loginMember(request, response, session);
%>
<jsp:forward page="<c:url value='/member/members_LoginView.jsp'/>"/>