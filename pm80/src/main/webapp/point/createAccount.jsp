<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
</head>
<body>
	<form action="createAccount" method="post">
	<fieldset>
    <legend>가상계좌 생성</legend>
    아이디 : <input type="text" name="userId"/>
    	<button type="submit">생성하기</button>
    </fieldset>
    </form>
</body>
</html>