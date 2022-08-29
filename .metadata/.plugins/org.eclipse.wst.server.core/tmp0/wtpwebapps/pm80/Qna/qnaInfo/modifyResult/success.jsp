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
	<form action="modifyQna.do" method="post">
		제목: <input type="text" name="qna_title"><br> 내용: 
		<input type="text" name="qna_content"><br>
		<input type="submit" value="수정"> <input type="submit" value="취소">
	</form>
게시글 수정 완료
</body>
</html>