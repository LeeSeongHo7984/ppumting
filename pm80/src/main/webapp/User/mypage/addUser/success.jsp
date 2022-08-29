<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ppumting</title>
</head>
<body>
	<h3>회원가입 성공</h3>
	<h4>${userId}</h4>
	<button><a href='<c:url value="../loginout/login.jsp"/>'>로그인 페이지로</button>
</body>
</html>