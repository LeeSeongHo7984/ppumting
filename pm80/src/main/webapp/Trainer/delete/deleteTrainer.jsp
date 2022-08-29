<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>*회원삭제*</h1>
<h2>회원삭제 하시려면 ID와 PW를 입력해주세요.</h2>
	<form action="deleteTrainer" method="post">
	아이디: <input type="text" name="trainerId"><br>
	패스워드: <input type="password" name="passwd"><br>
	<input type="button" value="취소" onclick="location.href='http://localhost:8080/pm80/Trainer/mypage.jsp'"/>
	<input type="submit" value="회원삭제"><br>
	</form>

</body>
</html>