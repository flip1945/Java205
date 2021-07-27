<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div.message_box {
		padding: 5px;
		margin: 5px;
		border: 1px solid black;
		width: 300px;		
	}
	
	div.paging {
		padding: 10px;
		margin-left: 10px;
		margin-bottom: 150px;
	}
	
</style>
<script>
</script>
</head>
<body>
	<form action="writemessage.jsp" method="post">
		<table>
			<tr>
				<td><label for="guestname">이름</label></td>
				<td><input type="text" name="guestname" id="guestname" required></td>
			</tr>
			<tr>
				<td><label for="password">비밀번호</label></td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td><label for="message">메세지</label></td>
				<td>
					<textarea rows="10" cols="30" name="message" id="message"></textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="메세지 남기기"></td>
			</tr>
		</table>	
	</form>
	
	<hr>
	
	<c:if test="${not empty listView.messageList}">
	
		<c:forEach items="${listView.messageList}" var="message">
			<div class="message_box">
				<table>
					<tr>
						<td>메시지 아이디</td>
						<td>${message.messageid}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${message.guestname}</td>
					</tr>
					<tr>
						<td>메세지</td>
						<td>${message.message}</td>
					</tr>
					<tr>
						<td>작성일</td>
						<td>${message.regdate}</td>
					</tr>
					<tr>
						<td></td>
						<td><a href="confirmDelete.jsp?mid=${message.messageid}">삭제</a></td>
					</tr>
				</table>
			</div>
		</c:forEach>
	</c:if>
	
	<c:if test="${listView.pageTotalCount > 0}">
		<div class="paging">
			<c:forEach begin="1" end="${listView.pageTotalCount}" var="num">
			<span>[ <a href="list.jsp?page=${num}">${num}</a> ]</span>
			</c:forEach>		
		</div>
	</c:if>
</body>
</html>