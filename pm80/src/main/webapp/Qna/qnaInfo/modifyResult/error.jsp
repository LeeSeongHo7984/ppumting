<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<div>
<h4>게시글수정 실패</h4>
   <%
   List<String> errorMsgs = (List<String>)request.getAttribute("errorMsgs");
   %>
   <%
      for(String x : errorMsgs){
   %>
   <%=
      x
   %><br>
   <%
   } 
   %>
</div>
</body>
</html>