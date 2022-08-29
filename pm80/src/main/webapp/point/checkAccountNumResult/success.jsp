<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌번호 조회</title>
</head>
<body>
	<c:forEach var="x" items="${accountNum}"> 
		사용자의 계좌번호 : ${x}
  	</c:forEach>
</body>
</html>