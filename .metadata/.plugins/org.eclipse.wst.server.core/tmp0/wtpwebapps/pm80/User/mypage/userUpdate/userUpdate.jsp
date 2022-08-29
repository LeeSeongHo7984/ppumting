<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
<head>
<link rel="icon" type="image/png" sizes="32x32"
	href="../../../ico/favicon-32x32.png">
<meta charset="utf-8">
<link rel="stylesheet" href="userUpdatecss/normalize.css">
<link rel="stylesheet" type="text/css" href="userUpdatecss/style.css?after">
<title>정보수정 | ppumting</title>
</head>

<body>
	<div id="wrap">
		<header id="header">
			<h1 class="logo">
				PPUMTING | 회원정보수정
				<h1>
		</header>


		<div id="login_wrap">
			<form class="login_form" action="userUpdate" method="Post">

				<div class="name_input">
					<input type="text" name="name" value="${user.name}" required="이름을 입력하세요">
				</div>

				<div class="phone_input">
					<input type="text" name="phone" value="${user.phone}" maxlength="13" required>
				</div>

				<div class="id_input">
					<input type="text" name="userId" value="${userId}" maxlength="13" readonly required>
				</div>
				
				<div class="id_input">
					<input type="password" name="pw" value="${user.pw}" maxlength="20" required>
				</div>

				<div class="addr_input">
					<input type="text" name="addr" value="${user.addr}" required><br>
				</div>
				<button class="update_btn" type="submit">회원정보 수정완료</button>
			</form>
				<form action="/User/mypage/loginout/login">
					<button class="delete_btn" type="submit">회원탈퇴</button>
				</form>



		</div>


		<footer id="footer">
			<span class="text">Copyright</span> <span class="corp">©
				PPUMTING Corp.</span> <span class="text">All Rights Reserved.</span>
		</footer>
	</div>
</body>
</html>