<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- 커스텀태그 --%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checking Point</title>
</head>
<body>
	<form action="checkPoint" method="post">
	<fieldset>
	<legend>포인트 조회</legend>
		아이디 : <input type="text" name="userId"/>
    	<button type="submit">조회하기</button>
	</fieldset>
	</form>
</body>
</html>