<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ppumting</title>
</head>
<body>
<h4>원하는 항목을 변경해주세요</h4>
<form action="updateTrainer" method="post">
아이디: <input type="text" name="trainerId" value="${trainer.trainerId}" readonly><span> *아이디 변경은 불가능합니다.</span><br>
비밀번호: <input type="text" name="passwd" value="${trainer.passwd}"><br>
이름: <input type="text" name="name" value="${trainer.name}"><br>
전화번호: <input type="text" name="phone" value="${trainer.phone}"><br>
주소: <input type = "text" name="addr" value="${trainer.addr}"><br>
<input type="submit" value="회원정보 수정 완료">
</form>
</body>
</html>