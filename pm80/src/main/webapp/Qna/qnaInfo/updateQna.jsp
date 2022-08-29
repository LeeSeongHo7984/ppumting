<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link rel="icon" type="image/png" sizes="32x32"
	href="../../ico/favicon-32x32.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<link href="../findqna/success.css" rel="stylesheet">

<title>HOME | PUMTTING</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/carousel/">

<!-- Bootstrap core CSS -->
<link href="../../assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

<!-- Custom styles for this template -->
<link href="../qnacss/carousel.css" rel="stylesheet">
</head>
<body>
	<%-- header Area --%>
	<div id="header">
		<jsp:include page="/incl/banner.jsp">
			<jsp:param name="subtitle"
				value="<%=URLEncoder.encode(\"mod010: Login.jsp\", \"UTF-8\")%>" />
		</jsp:include>
	</div>
	<%-- content Area --%>
	<div class="trainer-wrapper">
		<div class="inner">
			<div class="trainer-container">
				<h1>
					<span class="trainer-hover" style="font-weight: bold;">게시글
						수정이 완료 되었습니다.</span>
				</h1>
			</div>
		</div>
	</div>
<body>
	<form action="find.do" method="post" style="text-align: center;">
		<br>
		<div style="width: auto; height: 100px; text-align: center;">
			<a style="color: black; text-decoration: none; border:3px solid black;"
				aria-current="page" href='<c:url value="/Qna/qnaInfo/find.do"/>'>완료</a>
		</div>
	</form>

	<%-- footer Area --%>
	<div id="footer">
		<%@ include file="/incl/footer.jsp"%>
	</div>
</body>
</html>