<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 조회 성공</title>
</head>
<body>
	<c:forEach var="x" items="${successPrice}"> 
		현재 사용가능한 포인트 : ${x} point
  	</c:forEach>
</body>
</html>