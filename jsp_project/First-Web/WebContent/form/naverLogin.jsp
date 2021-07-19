<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>네이버 : 로그인</title>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        body {
            background-color: #f5f6f7;
        }

        #main_wrap {
            width: 500px;

            margin: 200px auto;
        }

        #main_wrap > img {
            display: block;

            margin: 50px auto;
        }

        #main_wrap input {
            display: block;

            margin: 15px auto;

            width: 400px;

            padding: 10px;
            border: 1px solid #DDD;
        }

        #main_wrap .login_bnt {
            width: 424px;
            padding: 15px 0;
            
            font-weight: bold;
            font-size: 16px;

            color: white;
            background-color: #03c75a;
        }
    </style>
</head>
<body>

    <div id="main_wrap">
        <img src="img/naver_logo.png" alt="네이버 로고">

		<form action="naverLoginResult.jsp" method="get">
	        <input type="text" placeholder="아이디" name="userID">
	        <input type="password" placeholder="비밀번호" name="userPW">
	        <input type="submit" value="로그인" class="login_bnt">
		</form>
    </div>
    
</body>
</html>