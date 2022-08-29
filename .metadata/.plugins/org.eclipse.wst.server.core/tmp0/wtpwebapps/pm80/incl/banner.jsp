<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<div id="banner">
	<header>
		<nav class="navbar navbar-expand-md fixed-top">
			<div class="container-fluid">
				<a class="navbar-brand" aria-current="page"
					href='<c:url value="/User/mypage/home"/>'>PPUMTING</a>
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
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href='<c:url value="/point/minusPoint"/>'>P.P.T</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Info</a></li>
					</ul>
					<div class="login_info">
						쪽지함 : <a type="hidden"
							href='<c:url value="/Note/selectTitleMsg"/>'>${countNote}</a>
						${userId}님
						<button class="login_btn">
							<a href='<c:url value="/User/mypage/userUpdate/userSelect"/>'>수정</a>
						</button>
						포인트 : ${checkPoint}p
						<button class="login_btn">
							<a href='<c:url value="/point/addPoint"/>'>충전</a>
						</button>
						<button class="login_btn">
							<a href='<c:url value="/User/mypage/loginout/login.jsp"/>'>로그아웃</a>
						</button>
					</div>
				</div>
			</div>
		</nav>
	</header>
</div>