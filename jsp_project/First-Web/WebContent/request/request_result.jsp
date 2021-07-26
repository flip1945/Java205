<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// request.setCharacterEncoding("utf-8");

	String userName = request.getParameter("userName");
	String job = request.getParameter("job");
	
	String[] interests = request.getParameterValues("interest");
	
	request.setAttribute("userName", userName);
	request.setAttribute("job", job);
	request.setAttribute("age", 30);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Request Form Test : result</h1>
	<hr>
	<!-- 데이터를 전송할 위치로 전송 : input 요소에 name 속성을 반드시 정의! -->
	<form action="request_result.jsp" method="get">
		<table border=1>
			<tr>
				<td>이름</td>
				<td>
					<%= userName %>
				</td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<%= job %>
				</td>
			<tr>
				<td>관심사항</td>
				<td>
					<%
					if (interests != null && interests.length > 0) {
						for (int i = 0; i < interests.length; i++) {
							out.println(interests[i] +"<br>");
						}
					}
					%>
				</td>
			</tr>
			
			<tr>
				<td>
					<jsp:include page="view.jsp"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>