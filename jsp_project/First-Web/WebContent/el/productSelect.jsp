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

	<h3>
		1. 선택한 상풍 : ${param.select} <br>
		2. 상품에 대한 설명 : ${product.display} <br>
		<!-- display 변수는 없지만, getDispaly()를 실행 -->
		3. 첫번재 상품 : ${product.productList[0]}
	</h3>
</body>
</html>