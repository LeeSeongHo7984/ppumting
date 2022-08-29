<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		
	</div>
	<div id="content-wrapper">
		<h3>트레이너 조회되었습니다.</h3>
		<c:forEach var="trainer" items="${trainerList}">
         	트레이너 ID : ${trainer.trainerId}<br>
         	트레이너 이름 : ${trainer.name}<br>
         	트레이너 PW : ${trainer.passwd}<br>
         	<br>
   		</c:forEach>
	</div>
</div>
</body>
</html>