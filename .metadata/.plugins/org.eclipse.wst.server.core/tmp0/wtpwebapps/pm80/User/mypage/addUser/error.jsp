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
<div>
	<h4>회원가입 실패</h4>
	<c:if test="${not empty errorMsgs}">
		<h4>실패 이유.</h4>
		<ul>
		<c:forEach var="message" items="${errorMsgs}"> 
			<li>${message}</li>
		</c:forEach>
		</ul>
	</c:if>
</div>
</body>
</html>