<%@page import="member.service.MemberEditService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberEditService.getInstance().editMember(request);
%>
<jsp:forward page="members_EditView.jsp"/>