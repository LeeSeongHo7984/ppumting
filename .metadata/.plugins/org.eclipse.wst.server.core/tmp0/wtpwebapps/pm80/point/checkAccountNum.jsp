<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- 커스텀태그 --%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checking AccountNum</title>
</head>
<body>
	<form action="checkAccountNum" method="post">
	<fieldset>
	<legend>본인 계좌번호 조회</legend>
		아이디 : <input type="text" name="userId"/>
    	<button type="submit">조회하기</button>
	</fieldset>
	</form>
</body>
</html>