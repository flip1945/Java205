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
		String select = request.getParameter("select");
	
		int selNum = Integer.parseInt(select);
		
		if (selNum > 0) {
			out.println("리다이렉트");
			// sendRedirect(경로) -> 현재 페이지가 응다 처리되고 난 후 경로의 페이지를 요청
			response.sendRedirect("result.jsp");
		} else {
			out.println("포워드");
			// 현재 페이지 resultPage.jsp가 응답되는 것이 아니라 result.jsp 파일의 결과를 응답처리
			%>
			<jsp:forward page="result.jsp"/>
			<%
		}
	%>
</body>
</html>