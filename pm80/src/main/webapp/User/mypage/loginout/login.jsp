<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
<head>
<meta charset="utf-8">
<link rel="icon" type="image/png" sizes="32x32"
	href="../../../ico/favicon-32x32.png">
<link rel="stylesheet" href="logincss/normalize.css">
<link rel="stylesheet" type="text/css" href="logincss/style.css">
<title>로그인 | ppumting</title>
</head>
<body>
	<div id="admin">
		<img src="./img/setting.png"
			style="width: 30px; height: 30px; cursor: pointer; position: absolute; top: 50px; right: 50px;"
			onclick="location.href='http://localhost:8080/pm80/Trainer/loginout/admin'" />
	</div>
	<div id="wrap">
		<header id="header">
			<h1 class="logo">
				PPUMTING | 건강한 만남의 시작
				<h1>
		</header>
		<div id="login_wrap">
			<form class="login_form" action="login" method="post">
				<div class="id_input">
					<input type="text" name="userId" placeholder="아이디" />
				</div>
				<div class="pw_input">
					<input type="password" name="pw" placeholder="비밀번호" />
				</div>
				<input class="login" type="submit" value="로그인" />
			</form>
		</div>
		<div class="sign_up">
			<span>아직 ppumting 회원이 아니시라면 지금 바로 <a
				href='<c:url value="../addUser/addUser.jsp"/>'>회원가입</a>해보세요!
			</span>
		</div>
		<footer id="footer">
			<span class="text">Copyright</span> <span class="corp">©
				PPUMTING Corp.</span> <span class="text">All Rights Reserved.</span>
		</footer>
	</div>
</body>
</html>
