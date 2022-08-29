<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/normalize.css">
    <link href="../User/homecss/carousel.css" rel="stylesheet">
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/sendMsg.css">
    <link rel="icon" type="image/png" sizes="32x32" href="../ico/favicon-32x32.png">
 	<meta charset="utf-8">
<title>쪽지보내기 | PPUMTING</title>
</head>

<script type="text/javascript">
function sendComplete() {
	alert('쪽지 전송 완료');
	window.opner.location.href="/Note/sendMsg";
    window.close();
    window.close();
    opener.location.reload();
    opener.location.reload();
}
</script>

  <body>
    <div id="smWrap">
      <form action="sendMsg" method="post">
      <h1 class="sendMsg">답장 보내기</h1>
      보내실 분 ID : <input class="receiveUserId" type="text" value = "${receiveUserId }" readonly name="receiveUserId">
      <input type="text" name="title" maxlength="30" placeholder="제목은 최대 30자까지 입력가능합니다." class="title"><br>
      <div class= "text_box">
      <textarea name="msg"></textarea><br>
      <div class="count">
      <span>0</span>/200<br>
      <p class="gray">쪽지 내용은 최대 200자까지만 입력가능합니다.</p>
      </div>
      </div>
      <input class="submit_btn" type="submit" onclick="sendComplete()" value="전송">
      </form>
    </div>
  <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
  <script type="text/javascript">
  $('.text_box textarea').keyup(function(){
  	  var content = $(this).val();
  	  $('.text_box .count span').html(content.length);
  	  if (content.length > 200){
  	    alert("최대 200자까지 입력 가능합니다.");
  	    $(this).val(content.substring(0, 200));
  	    $('.text_box .count span').html(200);
  	  }
  	});
  </script>
  </body>

</html>