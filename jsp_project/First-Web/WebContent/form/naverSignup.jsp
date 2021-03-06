<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>네이버 : 회원가입</title>

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

            margin: 80px auto;
        }

        #main_wrap > img {
            display: block;

            margin: 50px auto;
        }

        #main_wrap label {
            font-size: 14px;
            font-weight: bold;
        }

        #main_wrap input {
            display: block;

            margin: 15px auto;

            width: 480px;
            height: 30px;
            line-height: 30px;

            padding: 10px;
            border: 1px solid #DDD;
        }

        #main_wrap select {
            display: block;

            margin: 15px auto;
            padding:0 10px;

            width: 502px;
            height: 50px;
            line-height: 30px;
            border: 1px solid #DDD;
        }

        #birthday_wrap {
            width: 500px;
            height: 80px;
        }

        #main_wrap .birthday {
            display: inline-block;

            width: 140px;

            margin: 15px 0;
            line-height: 30px;

            padding: 10px;
            border: 1px solid #DDD;
        }

        #main_wrap #birthday_wrap > #month,  #main_wrap > #birthday_wrap > #day{
            margin-left: 12px;
        }

        #main_wrap #birthday_wrap > select {
            padding: 0 10px;

            height: 52px;
            line-height: 30px;
            border: 1px solid #DDD;
        }

        #main_wrap #tel_input {
            display: inline-block;
            width: 350px;
        }

        #main_wrap #tel_bnt {
            display: inline-block;
            width: 120px;
            height: 52px;

            margin-left: 2px;

            font-size: 15px;

            color: white;
            background-color: #03c75a;
        }

        #main_wrap .signup_bnt {
            width: 502px;
            padding: 15px 0;

            font-size: 18px;

            height: 50px;

            color: white;
            background-color: #03c75a;
        }

        #footer_ul_wrap {
            width: 460px;
            height: 20px;

            margin: 10px 0 10px 40px;
        }

        #footer_ul_wrap > ul > li {
            float: left;
            list-style: none;
            padding-left: 5px;

            font-size: 12px;
        }

        footer > p {
            clear: both;

            font-size: 12px;
        }

        footer > p > img {
            margin-right: 5px;
        }

        .text_right {
            text-align: right;
        }

        .text_center {
            text-align: center;
        }
    </style>
</head>
<body>

    <div id="main_wrap">
        <img src="img/naver_logo.png" alt="네이버 로고">

		<form action="naverSignupResult.jsp" method="get">
	        <label for="id">아이디</label>
	        <input type="text" id="id" class="text_right" placeholder="@naver.com" name="userID">
	        
	        <label for="password">비밀번호</label>
	        <input type="password" id="password" class="text_right" placeholder="PW" name="userPW">
	
	        <label for="password_reconfirm">비밀번호 재확인</label>
	        <input type="password" id="password_reconfirm" class="text_right" placeholder="PW">
	
	        <label for="name">이름</label>
	        <input type="text" id="name" name="userName">
	
	        <label for="year">생년월일</label>
	
	        <div id="birthday_wrap">
	            <input type="text" id="year" class="birthday" placeholder="년(4자)" name="birthYear">
	    
	            <select id="month" class="birthday" name="birthMonth">
	                <option value="월">월</option>
	                <option value="1">1</option>
	                <option value="2">2</option>
	                <option value="3">3</option>
	                <option value="4">4</option>
	                <option value="5">5</option>
	                <option value="6">6</option>
	                <option value="7">7</option>
	                <option value="8">8</option>
	                <option value="9">9</option>
	                <option value="10">10</option>
	                <option value="11">11</option>
	                <option value="12">12</option>
	            </select>
	    
	            <input type="text" id="day" class="birthday" placeholder="일" name="birthDay">
	        </div>
	
	        <label for="sex">성별</label>
	        <select id="sex" name="userSex">
	            <option value="성별">성별</option>
	            <option value="남자">남자</option>
	            <option value="여자">여자</option>
	            <option value="선택 안함">선택 안함</option>
	        </select>
	
	        <label for="email">본인 확인 이메일<span>(선택)</span></label>
	        <input type="email" placeholder="선택입력" name="userEmail">
	
	        <label for="phone">휴대전화</label>
	        <select id="phone">
	            <option value="대한민국 +82">대한민국 +82</option>
	        </select>
	        <input type="tel" id="tel_input" placeholder="전화번호 입력" name="userPhone">
	        <input type="button" id="tel_bnt" value="인증번호 받기">
	        <input type="text" placeholder="인증번호 입력하세요">
	
	        <input type="submit" value="가입하기" class="signup_bnt">
		</form>
    
        <footer>
            <div id="footer_ul_wrap">
                <ul>
                    <li>이용약관 |</li>
                    <li><strong>개인정보처리방침 |</strong></li>
                    <li>책임의 한계와 법적고지 |</li>
                    <li>회원정보 고객센터</li>
                </ul>
            </div>
            <p class="text_center"><img src="img/naver_logo.png" alt="네이버 로고" width="65px">Copyright <strong>NAVER Corp.</strong> All Rights Reserved.</p>
        </footer>
    </div>
</body>
</html>