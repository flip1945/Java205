<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
		<meta name="generator" content="Hugo 0.80.0">
		<title>Offcanvas template · Bootstrap v4.6</title>
		
		<link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/offcanvas/">
	  
		<!-- Bootstrap core CSS -->
		<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
		
		
		<style>
			.bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
			}
		
			@media (min-width: 768px) {
				.bd-placeholder-img-lg {
				font-size: 3.5rem;
				}
			}
		</style>
		
		 
		 <!-- Custom styles for this template -->
		<link href="<c:url value='/css/offcanvas.css'/>" rel="stylesheet">
	</head>
 	<body class="bg-light">
 	
	<%@ include file="/WEB-INF/views/frame/bootstrap_header.jsp"%>
	
	<main role="main" class="container">
		<div class="my-3 p-3 bg-white rounded shadow-sm">
			test
		</div>
	</main>
	
	<%@ include file="/WEB-INF/views/frame/footer.jsp" %>
	
	</body>
</html>
    