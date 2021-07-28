<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
</style>
<script>
	$(document).ready(function() {
		$.get('data.html', function(data) {
			$('body').append(data);
		});

		$.post('data.html', function(data) {
			$('body').append(data);
		});
	});
</script>
</head>
<body>
	
</body>
</html>