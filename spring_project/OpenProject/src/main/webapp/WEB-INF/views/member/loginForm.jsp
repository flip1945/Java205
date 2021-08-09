<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 로그인</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>

</head>
<body>

	<%@ include file="/WEB-INF/views/frame/header.jsp" %>
	<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
	
	<div id="content">
		<form action="<c:url value="/member/login"/>" method="post">
			<table>
				<tr>
					<td>
						<label for="userId"><b>ID</b></label>
					</td>
					<td>
						<input type="text" name="userId" id="userId" value="${cookie.rememId.value}">
					</td>
				</tr>
				<tr>
					<td>
						<label for="userPw"><b>PW</b></label>
					</td>
					<td>
						<input type="password" name="userPw" id="userPw">
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td class="td_left">
						<input type="checkbox" name="rememId" id="rememId" value="on" ${cookie.rememId eq null ? '' : 'checked'}>
						<label for="rememId">아이디 기억하기</label>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td class="td_left">
						<input type="submit" value="로그인">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>