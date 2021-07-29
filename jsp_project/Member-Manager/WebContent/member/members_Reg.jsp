<%@page import="member.service.MemberRegService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberRegService.getInstance().regMember(request);
%>
<jsp:forward page="members_RegView.jsp"/>