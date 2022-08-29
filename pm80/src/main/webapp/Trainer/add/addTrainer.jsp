<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
  <head>
    <link rel="icon" type="image/png" sizes="32x32" href="../../../ico/favicon-32x32.png">
    <meta charset="utf-8">
    <link rel="stylesheet" href="signupcss/normalize.css">
    <link rel="stylesheet" type="text/css" href="signupcss/style.css?after">
    <title>회원가입 | PPUMTING Trainer</title>
  </head>
  <body>
    <div id="wrap">
      <header id="header">
        <h1 class="logo">PPUMTING | 트레이너 회원가입</h1>
      </header>
      
      
      <div id="login_wrap">
        <form class="login_form" action="addTrainer" method="post">
        <div class="name_input">
          <input type="text" name="name" placeholder="이름">
        </div>
        
        
        <div class="ssn_input">
          <input type="text" name="ssn" maxlength="6" placeholder="주민번호 앞자리">
        </div>
        
        
        <div class="phone_input">
          <input type="tel" name="phone" maxlength="13" placeholder="휴대전화">
        </div>
        
        
        <div class="id_input">
          <input type="text" name="trainerId" maxlength="13" placeholder="아이디">
        </div>
        
        
        <div class="pw_input">
          <input type="password" name="passwd" maxlength="13" placeholder="비밀번호">
        </div>
        
        
        <div class="addr_input">
          <select name = "addr1">
			<option>지역 선택</option>
			<option>서울</option>
			<option>대구</option>
			<option>대전</option>
			<option>부산</option>
			<option>포항</option>
			<option>제주</option>
			<option>울산</option>
			<option>경기도</option>
			<option>강원도</option>
			<option>경상 북도</option>
			<option>경상 남도</option>
			<option>전라 북도</option>
			<option>전라 남도</option>
		</select>
		<input class="addr_input_1"type = "text" name="addr2" placeholder="상세 주소를 적어주세요"><br>
        </div>
        <div class="price">

        </div>
        <input class="login" type="submit" value="회원가입">
        </form>
        
        
      </div>
      <footer id="footer">
        <span class="text">Copyright</span>
        <span class="corp">© PPUMTING Corp.</span>
        <span class="text">All Rights Reserved.</span>
      </footer>
    </div>
  </body>
</html>