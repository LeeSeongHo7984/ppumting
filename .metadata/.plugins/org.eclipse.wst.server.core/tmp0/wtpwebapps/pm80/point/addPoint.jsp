<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%String accountNum = (String) request.getAttribute("accountNum");%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" sizes="32x32" href="../ico/favicon-32x32.png">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="logincss/style.css">
    <link rel="icon" type="image/png" sizes="32x32" href="../../ico/favicon-32x32.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>HOME | PUMTTING</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/carousel/">



    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

   


    <!-- Custom styles for this template -->
    <link href="homecss/carousel.css" rel="stylesheet">
  </head>
  <body>

<header>
  <nav class="navbar navbar-expand-md fixed-top">
    <div class="container-fluid">
      <a class="navbar-brand" aria-current="page" href='<c:url value="/User/mypage/home"/>'>PPUMTING</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href='<c:url value="/Qna/qnaInfo/find.do"/>'>게시판</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href='<c:url value="/Trainer/mypage"/>'>P.P.T</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Info</a>
          </li>
        </ul>
        <div class="login_info">
          쪽지함 :
          <a type="hidden" href='<c:url value="/Note/selectTitleMsg"/>'>${countNote}</a>
          ${userId}
          <button class="login_btn"><a href='<c:url value="/User/mypage/userUpdate/userSelect"/>'>수정</a></button>
          포인트 : ${checkPoint}p
          <button class="login_btn"><a href='<c:url value="/point/addPoint"/>'>충전</a></button>
          <button class="login_btn"><a href='<c:url value="/User/mypage/loginout/logout"/>'>로그아웃</a></button>
        </div>
      </div>
    </div>
  </nav>
</header>

<main>
	
	 <div id="wrap">
      <header id="header">
        <h1 class="logo">Point Charging<h1>
      </header>
      <div id="login_wrap">
        <form class="login_form" action="addPoint" method="post">
        <div class="id_input">
        	<div>
	          개인 입금 계좌 : <%=accountNum%> 
        	</div>
        </div>
        <div class="pw_input">
        <input type="number" min="10000" step="10000" name="point" value="" placeholder=" 입금 할 포인트                              단위 : 10,000" />
        </div>
        <button class="login" type="submit">충전하기</button>
        </form>
      </div>
      <footer id="footer">
        <span class="text">Copyright</span>
        <span class="corp">© PPUMTING Corp.</span>
        <span class="text">All Rights Reserved.</span>
      </footer>
    </div>
  
</main>
    <script src="../../assets/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
