<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
  <head>
    <link rel="icon" type="image/png" sizes="32x32" href="../../../ico/favicon-32x32.png">
    <meta charset="utf-8">
    <link rel="stylesheet" href="signupcss/normalize.css">
    <link rel="stylesheet" type="text/css" href="signupcss/style.css?after">
    <title>회원가입 | ppumting</title>
  </head>
  
  <body>
    <div id="wrap">
      <header id="header">
        <h1 class="logo">PPUMTING | 회원가입<h1>
      </header>
      
      
      <div id="login_wrap">
        <form class="login_form" action="addUser" method="post">
        <div class="name_input">
          <input type="text" name="name" placeholder="이름" required>
        </div>
        
        
        <div class="ssn_input">
          <input type="text" name="ssn" maxlength="6" placeholder="주민번호 앞자리" required>
        </div>
        
        
        <div class="phone_input">
          <input type="tel" name="phone" maxlength="13" placeholder="휴대전화" required>
        </div>
        
        
        <div class="id_input">
          <input type="text" name="userId" maxlength="13" placeholder="아이디" required>
        </div>
        
        
        <div class="pw_input">
          <input type="password" name="pw" maxlength="13" placeholder="비밀번호" required>
        </div>
        
        <div class="addr_input">
          <select name = "addr1" required>
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
		<input class="addr_input_1"type = "text" name="addr2" placeholder="상세 주소를 적어주세요" required><br>
        </div>
        <button class="login" type="submit">회원가입</button> 
        </form>
        
        
      </div>
      
      
      <footer id="footer">
        <span class="text">Copyright</span>
        <span class="corp">© PPUMTING Corp.</span>
        <span class="text">All Rights Reserved.</span>
      </footer>
    </div>
<!--     <script>
    	function btn(){
    	   	if(true){
        		alert();
        	}
    	}
 
    </script> -->
  </body>
</html>
