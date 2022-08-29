<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" sizes="32x32" href="../../ico/favicon-32x32.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <link href="../findqna/modify.css" rel="stylesheet">
    
    <title>HOME | PUMTTING</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/carousel/">
    
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

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    <!-- Custom styles for this template -->
    <link href="../qnacss/carousel.css" rel="stylesheet">
  </head>
<body>
<header>
  <nav class="navbar navbar-expand-md fixed-top">
    <div class="container-fluid">
     <a class="navbar-brand" href="../../User/mypage/home.jsp">PPUMTING</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href='<c:url value="/Qna/qnaInfo/find.do"/>'>게시판</a> 
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../../Trainer/mypage.jsp">P.P.T</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Info</a>
          </li>
        </ul>
        <div class="login_info">
          쪽지함 :
          <a type="hidden" href='<c:url value="/Note/selectTitleMsg"/>'>${countNote}</a>
          ${userId}님
          <button class="login_btn"><a href='<c:url value="/User/mypage/userUpdate/userSelect"/>'>수정</a></button>
          <% String point = (String)request.getAttribute("checkPoint"); %>
          포인트 : <%=point%>p
          <button class="login_btn"><a href='<c:url value="/point/addPoint"/>'>충전</a></button>
          <button class="login_btn"><a href='<c:url value="/User/mypage/loginout/logout"/>'>로그아웃</a></button>
        </div>
      </div>
    </div>
  </nav>
</header>
  <div class="trainer-wrapper">
        <div class="inner">
          <div class="trainer-container">
            <h1 style="margin-top: 50px; text-align: center; margin-bottom: 30px;"><span class="trainer-hover" 
            style=" font-weight: bold;">게시글 보기</span></h1>
          </div>
        </div>
      </div>   
	<h4 style="margin-left: 800px;">제목 or 내용을 변경해 주세요</h4>
	<div>
	<form action="update.do" method="post" class="form">
	<div><span style="font-weight: bold; font-size: 25px;">게시글 번호: </span> <input type="text" name="qna_no" value="${qnas.qnaNo}" readonly></div><br>
	<div><span style="font-weight: bold; font-size: 25px;">제목 </span> <input type="text" name="qna_title" value="${qnas.qnaTitle}"></div><br>
	<div><span style="font-weight: bold;font-size: 25px;">내용 </span><br> <input type="text" name="qna_content" value="${qnas.qnaContent}" class="content"></div><br>
	<div><span style="font-weight: bold; font-size: 25px;">게시일자 </span> <input type="text" name="qna_reg_date" value="${qnas.qnaRegDate}" disabled></div><br>
	</div>
		<input type="submit" value="게시글 수정 완료" class="addBu">
	</form>
  	
  	<!-- FOOTER -->
  <footer class="container">
    <p class="float-end"><a href="#" style="position: fixed; bottom: 20px;">Back to top</a></p>
    <p style="position: fixed; bottom: 0;">&copy; 2017–2021 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
  </footer>
</body>
</html>