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

<jsp:useBean id="product" class="product.Product" scope="session"/>

	<h1>상품 리스트 : 원하시는 상품을 선택하세요</h1>
	<form action="productSelect.jsp" method="post">
		<select name="select">
		<%
			for (int i = 0; i < product.getProductList().length; i++) {
				out.println("<option>" + product.getProductList()[i] +"</option>");
			}
		%>
		</select>
		
		<input type="submit">
	</form>
</body>
</html>