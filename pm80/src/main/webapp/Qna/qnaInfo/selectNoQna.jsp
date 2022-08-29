<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="../findqna/selectNoQna.css" rel="stylesheet">

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
	<script>
		function back() {
			history.back();
		}
	</script>
	<header>
		<nav class="navbar navbar-expand-md fixed-top">
			<div class="container-fluid">
				<a class="navbar-brand" href="../../User/mypage/home.jsp">PPUMTING</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
					aria-controls="navbarCollapse" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<ul class="navbar-nav me-auto mb-2 mb-md-0">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href='<c:url value="/Qna/qnaInfo/find.do"/>'>게시판</a></li>
						<li class="nav-item"><a class="nav-link"
							href="../../Trainer/mypage.jsp">P.P.T</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Info</a></li>
					</ul>
					<div class="login_info">
						쪽지함 : <a type="hidden"
							href='<c:url value="/Note/selectTitleMsg"/>'>${countNote}</a>
						${userId}님
						<button class="login_btn">
							<a href='<c:url value="/User/mypage/userUpdate/userSelect"/>'>수정</a>
						</button>
						<%
						String point = (String) request.getAttribute("checkPoint");
						%>
						포인트 :
						<%=point%>p
						<button class="login_btn">
							<a href='<c:url value="/point/addPoint"/>'>충전</a>
						</button>
						<button class="login_btn">
							<a href='<c:url value="/User/mypage/loginout/logout"/>'>로그아웃</a>
						</button>
					</div>
				</div>
			</div>
		</nav>
	</header>
	<div class="trainer-wrapper">
		<div class="inner">
			<div class="trainer-container">
				<h1
					style="margin-top: 50px; text-align: center; margin-bottom: 30px;">
					<span class="trainer-hover" style="font-weight: bold;">게시글
						보기</span>
				</h1>
			</div>
		</div>
	</div>
	<div class="board">
		<!-- qnas는 servlet에 있는 setAttribute안에 키값이랑 같아야 함 -->
		<div
			style="font-size: xx-large; margin-bottom: 20px; margin-top: 20px;">No
			: ${qnas.qnaNo}</div>
		<br>
		<div style="font-size: xx-large; margin-bottom: 20px;">제목 :
			${qnas.qnaTitle}</div>
		<br>
		<div style="font-size: xx-large; margin-bottom: 20px;">게시글 내용 :
			${qnas.qnaContent}</div>
		<br>
		<div style="font-size: xx-large; margin-bottom: 20px;">작성자 아이디 :
			${qnas.userId}</div>
		<br>
		<div style="font-size: xx-large; margin-bottom: 20px;">등록 일자 :
			${qnas.qnaRegDate}</div>
	</div>
	<c:if test="${check == false}">
		<div
			style="width: 100%; height: 50px; display: flex; text-align: center; font-size: 30px; line-height: 38px;">
			<a class="addBu" onclick="back()" style="text-decoration: none;">뒤로가기</a>
		</div>
	</c:if>
	<c:if test="${check == true}">
		<form action="modifyQna.do" method="post">
			<!--  <button type="submit" value="${qnas.qnaNo}" name="qnaNo">수정</button> -->
			<button type="submit" value="${qnas.qnaNo}" name="qnaNo"
				onclick="location.href='modifyQna.jsp'" class="addBu">
				<span style="font-size: 30px; line-height: 38px;" class="ft">수정</span>
			</button>
		</form>
		<form action="deleteQna.do" method="post">
			<button type="submit" value="${qnas.qnaNo}" name="qnaNo"
				class="addBu">
				<span style="font-size: 30px; line-height: 38px;" class="ft">삭제</span>
			</button>
		</form>
		<div
			style="width: 100%; height: 50px; display: flex; text-align: center; font-size: 30px; line-height: 38px;">
			<a class="addBu" onclick="back()" style="text-decoration: none;">뒤로가기</a>
		</div>
	</c:if>


	<!-- FOOTER -->
	<footer class="container">
		<p class="float-end">
			<a href="#" style="position: fixed; bottom: 20px;">Back to top</a>
		</p>
		<p style="position: fixed; bottom: 0;">
			&copy; 2017–2021 Company, Inc. &middot; <a href="#">Privacy</a>
			&middot; <a href="#">Terms</a>
		</p>
	</footer>
</body>
</html>