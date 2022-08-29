<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 충전 성공</title>
</head>
<body>

	<%=request.getAttribute("userId") %> 님 <br>
	<%=request.getAttribute("point") %> 포인트 충전 완료
  	
</body>
</html>