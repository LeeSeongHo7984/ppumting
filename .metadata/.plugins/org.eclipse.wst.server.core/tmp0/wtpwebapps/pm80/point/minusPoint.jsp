<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 커스텀태그 --%>
<%@ page import="java.net.URLEncoder"%>
<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="ko" dir="ltr">
<head>
<meta charset="utf-8">
<link rel="icon" type="image/png" sizes="32x32"
	href="../ico/favicon-32x32.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>HOME | PUMTTING</title>




<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

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
<link href="homecss/carousel.css" rel="stylesheet">
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
	<main>

		<div class="container marketing">
			<form action="minusPoint" method="post">
				<!-- Three columns of text below the carousel -->
				<div class="row" style="margin-top: 200px; margin-bottom: 200px;">
					<div class="col-lg-4">
						<img class="radius_img" src="../img/radius_img01.jpg" alt="">
						<h2>김종국</h2>
						<p>"포기란 없다"</p>
						<p>1개월 - 300,000원</p>
						<input type="radio" name="trainerPrice" value="300000">
					</div>
					<!-- /.col-lg-4 -->
					<div class="col-lg-4">
						<img class="radius_img" src="../img/radius_img02.jpg" alt="">
						<h2>마동석</h2>
						<p>"좋은 몸은 하루아침에 만들어지지 않는다."</p>
						<p>1개월 - 200,000원</p>
						<input type="radio" name="trainerPrice" value="200000">
					</div>
					<!-- /.col-lg-4 -->
					<div class="col-lg-4">
						<img class="radius_img" src="../img/radius_img03.jpg" alt="">
						<h2>양치승</h2>
						<p>'한계'라고 느낄 때 '한 개'를 더 해야 성장한다.</p>
						<p>1개월 - 400,000원</p>
						<input type="radio" name="trainerPrice" value="400000">
					</div>
					<!-- /.col-lg-4 -->
					<div class="col-lg-4 input" style="margin-left: 420px;">
						<input class="input-man" type="text" name="month"
							placeholder="개월 수 입력란  ">
						<button class="button-man" type="submit">결제하기</button>
					</div>
				</div>
				<!-- /.row -->
			</form>
		</div>


		<%-- footer Area --%>
		<div id="footer">
			<%@ include file="/incl/footer.jsp"%>
		</div>
	</main>
	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
