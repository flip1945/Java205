<%@page import="member.service.MemberRegService"%>
<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="member.dto.Member"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.SQLException"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberRegService.getInstance().regMember(request);
%>
<jsp:forward page="members_RegView.jsp"/>