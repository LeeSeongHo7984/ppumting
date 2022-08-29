<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러</title>
</head>
<body>
      <h3>다음과 같은 에러가 발생했습니다.</h3>

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

</body>
</html>