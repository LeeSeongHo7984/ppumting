<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
</head>
<style>
   #header {
      color: #055123;
   }
   
   #content-wrapper {
      padding: 30px;
   }
   
   #footer {
      font-size: 32px;
      font-weight: bold;
   }
</style>
<body>
<div id="wrapper">
  
   <div id="content-wrapper">
      <h3>회원가입되었습니다.</h3>
      <jsp:useBean id="trainer" class="com.ppumting.pm80.trainer.domain.Trainer" scope="request"/>
      아이디 : <jsp:getProperty property="trainerId" name="trainer"/><br>
      이름 : <jsp:getProperty property="name" name="trainer"/><br>
   </div>
   
<input type="button" value="로그인하기" onclick="location.href='http://localhost:8080/pm80/Trainer/loginout/admin.jsp'"/>
</div>
 
</body>
</html>