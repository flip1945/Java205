<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 회원가입</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>

<style>
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
				url : '<c:url value="/member/idcheck"/>',
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
	<%@ include file="/WEB-INF/views/frame/bootstrap_header.jsp"%>
	
	<main role="main" class="container">
		<div class="my-3 p-3 bg-white rounded shadow-sm">
			<h2>회원가입</h2>
			<hr>
	
			<form method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="memberid" id="memberid" class="form-control m-2">
							<span id="msg" class="display_none"></span> 
							<img id="loadingimg" class="display_none" alt="loading"
							src="<c:url value="/images/loading.gif"/>">
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="password" class="form-control m-2"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="membername" class="form-control m-2"></td>
					</tr>
					<tr>
						<td>사진</td>
						<td>
							<div class="custom-file m-2">
								<input type="file" name="photo" id="photo" class="m-2 custom-file-input">
								<label class="custom-file-label" for="photo">파일 선택</label>
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="form-control m-2 btn btn-primary"> <input type="reset" class="form-control m-2 btn btn-info">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</main>
</body>
</html>