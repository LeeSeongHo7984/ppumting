<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/normalize.css">
    <link href="../User/mypage/homecss/carousel.css?after" rel="stylesheet">
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/selectMsg.css">
    <link rel="icon" type="image/png" sizes="32x32" href="../ico/favicon-32x32.png">
 	<meta charset="utf-8">
<title>쪽지함 | PPUMTING</title>
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

    <div id="note_wrap">

      <h1>받은 쪽지함</h1>
      <div class="note_area rcv_note">
       <span class="users">보낸이</span>
       <span class="titles">제목</span>
       <span class="dates">보낸 날짜</span>
       <hr>
       <c:forEach var = "receiveTitle" items="${receiveTitles}">
		<a class="notes" onclick="window.open('notemsg?no=${receiveTitle.no}', '_blank', 'width=600 height=600')">
		<span class="user">${receiveTitle.sendUserId}</span>
		<span class="title">${receiveTitle.title} </span>
		<span class="date">${receiveTitle.regDate}</span>
		</a>
		<br>
		</c:forEach>
      </div>
      <h1>보낸 쪽지함</h1>
      <div class="note_area send_note">
       <span class="users">받은이</span>
       <span class="titles">제목</span>
       <span class="dates">보낸 날짜</span>
       <hr>
       <c:forEach var = "sendTitle" items="${sendTitles}">
		<a class="notes" onclick="window.open('notemsg?no=${sendTitle.no}', '_blank', 'width=600 height=600')">
		 <span class="user">${sendTitle.receiveUserId}</span> 
		 <span class="title">${sendTitle.title}</span> 
		 <span class="date">${sendTitle.regDate}</span>
		</a>
		<br>
		</c:forEach>
      </div>
      <button class="sendnote_btn" onclick="window.open('sendMsg.jsp', '_blank', 'width=600, height=600')" type="button">쪽지 쓰기</button>
    </div>
  </body>
</html>