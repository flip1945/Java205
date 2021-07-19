<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Facebook - 로그인 또는 가입</title>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        #main_wrap {
            margin: 0 auto;
        }

        #content_wrap {
            background-color: #f0f2f5;
            height: 700px;
            margin: 0 auto;
        }

        #box_wrap {
            width: 1000px;
            margin: 0 auto;
        }

        #logo_wrap {
            width: 440px;
            float: left;

            margin-right: 80px;
            margin-top: 200px;
        }

        #logo_wrap > p {
            font-size: 1.5em;
            padding-left: 5px;
        }

        #login_wrap {
            width: 350px;
            height: 300px;
            background-color: white;

            border-radius: 10px;
            box-shadow: -2px 2px 2px #e2e4e7, 2px 2px 2px #e2e4e7;

            float: left;

            margin-top: 150px;
            padding: 15px;
        }

        #login_wrap input {
            display: block;
            width: 350px;
            margin: 0 auto 15px auto;

            border: 1px solid #ccc;
            border-radius: 5px;

            padding: 0 5px;
        }

        #login_wrap input[type=text], #login_wrap input[type=password] {
            height: 35px;
            width: 342px;
        }

        .button {
            height: 45px;
            color: white;
            font-weight: bold;
            font-size: 18px;
        }

        .login_bnt {
            background-color: #1877f2;
        }

        #login_wrap .new_account_bnt {
            background-color: #42b72a;
            width: 160px;
            margin-top: 25px;
        }
        
        #password_find {
            width: 300px;
            text-align: center;
            margin: 20px;
        }

        #password_find a {
            color: #1877f2;
            text-decoration: none;
        }

        #password_find a:hover {
            text-decoration: underline;
        }

        #login_wrap p {
            margin-top: 60px;
            text-align: center;
            font-family: Arial, Helvetica, sans-serif;
            font-size: 14px;
        }

        #login_wrap p > a {
            font-weight: bold;
            text-decoration: none;
            color: black;
        }

        #login_wrap p > a:hover {
            text-decoration: underline;
        }

        .div_margin_center {
            margin: 0 auto;
        }


        footer {
            background-color: white;
            width: 900px;
            margin: 0 auto;

            color: #777;
        }

        #language_wrap > ul > li {
            float: left;
            list-style: none;

            font-size: 12px;

            padding: 25px 5px 5px 8px;
        }

        .plus_bnt {
            padding: 0 10px;
            
            font-weight: bold;
            font-size: 14px;
        }

        hr {
            border-left: 0px;
            border-right: 0px;
            border-bottom: 0px;

            border-top: 1px solid #ccc;

            clear: both;
        }

        #etc_wrap > ul > li {
            float: left;
            list-style: none;

            font-size: 12px;

            padding: 5px 8px;
        }
    </style>
</head>
<body>
    <div id="main_wrap">
        <div id="content_wrap">
            <div id="box_wrap">
                <div id="logo_wrap">
                    <img src="img/facebook_logo.png" alt="페이스북 로고">
                    <p>Facebook에서 전세계에 있는 친구, 가족, 지인들과 함께 이야기를 나눠보세요.</p>
                </div>
    
                <div id="login_wrap">
                	<form action="facebookLoginResult.jsp" method="get">
	                    <input type="text" placeholder="이메일 또는 전화번호" name="userID">
	                    <input type="password" placeholder="비밀번호" name="userPW">
	                    <input type="submit" value="로그인" class="button login_bnt">
                	</form>
                	
                    <div id="password_find" class="div_margin_center">
                        <a href="#">비밀번호를 잊으셨나요?</a>
                    </div>
                    <hr>
                    <input type="button" value="새 계정 만들기" class="button new_account_bnt">
                    <p>유명인, 밴드, 비즈니스를 위한 <a href="#">페이지 만들기</a></p>
                </div>
            </div>
        </div>

        <footer>
            <div id="language_wrap">
                <ul>
                    <li>한국어</li>
                    <li>English (US)</li>
                    <li>Tiếng Việt</li>
                    <li>Bahasa Indonesia</li>
                    <li>ภาษาไทย</li>
                    <li>Español</li>
                    <li>中文(简体)</li>
                    <li>日本語</li>
                    <li>Português (Brasil)</li>
                    <li>Français (France)</li>
                    <li>Deutsch</li>
                    <li><input type="button" value="+" class="plus_bnt"></li>
                </ul>
            </div>

            <hr>

            <div id="etc_wrap">
                <ul>
                    <li>가입하기</li>
                    <li>로그인</li>
                    <li>Messenger</li>
                    <li>Facebook Lite</li>
                    <li>Watch</li>
                    <li>사람</li>
                    <li>페이지</li>
                    <li>페이지 카테고리</li>
                    <li>장소</li>
                    <li>게임</li>
                    <li>위치</li>
                    <li>Marketplace</li>
                    <li>Facebook Pay</li>
                    <li>채용 정보</li>
                    <li>Oculus</li>
                    <li>Portal</li>
                    <li>Instagram</li>
                    <li>지역</li>
                    <li>기부 캠페인</li>
                    <li>서비스</li>
                    <li>투표 정보 센터</li>
                    <li>정보</li>
                    <li>광고 만들기</li>
                    <li>페이지 만들기</li>
                    <li>개발자</li>
                    <li>채용 정보</li>
                    <li>개인정보처리방침</li>
                    <li>쿠키</li>
                    <li>AdChoices</li>
                    <li>이용 약관</li>
                    <li>고객 센터</li>
                    <li>설정</li>
                </ul>
            </div>
        </footer>
    </div>
</body>
</html>