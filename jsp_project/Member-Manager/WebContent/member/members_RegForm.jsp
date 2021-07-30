<%@page import="member.dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 등록 페이지</title>
<link rel="stylesheet" href="<c:url value='/css/default.css'/>">
<style>
	h3 {
		margin: 20px;
	}
	
	table {
		margin: 10px;
	}
	
	table td, table th {
		padding: 5px 10px;
		text-align: left;
	}
	
	table #bnt_reset {
		text-align: left;
	}
	
	.display_none {
		display: none;
	}
	
	.color_blue {
		color: blue;
	}
	
	.color_red {
		color: red;
	}
	
	#loadingimg {
		height: 20px;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	$(document).ready(function() {
		$('#memberid').focusin(function() {
			$('#msg').addClass('display_none');
			$('#msg').removeClass('color_blue');
			$('#msg').removeClass('color_red');
			
			$(this).val('');
		});
		
		$('#memberid').focusout(function() {
			$.ajax({
				url : '<c:url value="/member/members_IdCheck.jsp"/>',
				type : 'post',
				data : {
					mid : $(this).val()
				},
				
				beforeSend : function() {
					$('#loadingimg').removeClass('display_none');
				},
				
				success : function(data) {
					if (data == 'Y') {
						$('#msg').html('사용가능');
						$('#msg').addClass('color_blue');
						$('#msg').removeClass('display_none');
					} else {
						$('#msg').html('사용 불가능');
						$('#msg').addClass('color_red');
						$('#msg').removeClass('display_none');
					}
				},
				
				error : function(request, status, error) {
					alert('서버 통신에 문제가 발생했습니다. 다시 실행해주세요.');
					console.log(request);
					console.log(status);
					console.log(error);
				},
				
				complete : function() {
					$('#loadingimg').addClass('display_none');
				}
			});
		});
	});
</script>
</head>
<body>

	<%@ include file="/WEB-INF/frame/header.jsp" %>
	
	<hr>
	
	<h3>회원 가입</h3>
	
	<form action="<c:url value="/member/members_Reg.jsp"/>" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<label for="memberid"><b>ID</b></label>
				</td>
				<td>
					<input type="text" name="memberid" id="memberid">
					<span id="msg" class="display_none"></span>
					<img id="loadingimg" alt="loading" src="<c:url value="/img/loading.gif"/>" class="display_none">
					
				</td>
			</tr>
			<tr>
				<td>
					<label for="password"><b>PW</b></label>
				</td>
				<td>
					<input type="password" name="password" id="password">
				</td>
			</tr>
			<tr>
				<td>
					<label for="membername"><b>이름</b></label>
				</td>
				<td>
					<input type="text" name="membername" id="membername">
				</td>
			</tr>
			<tr>
				<td>
					<label for="photo"><b>사진</b></label>
				</td>
				<td>
					<input type="file" name="photo" id="photo">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="등록">
				</td>
				<td id="bnt_reset">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>