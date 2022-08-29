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
<title>쪽지내용 확인</title>
<script type="text/javascript">
	
	function toDelete() {
	        if(confirm("삭제 하시겠습니까?")) {
	          alert("삭제를 완료했습니다.");
	          if(${sendNotes.sendnote}) {
		          window.opener.location.href="deleteSend?no=${sendNotes.no}";
		          opener.location.reload();
		          window.close();
		          opener.location.reload();
	          }else {
		          window.opener.location.href="deleteRcv?no=${rcvNotes.no}";
		  		  window.close();
		  		  opener.location.reload();
	          }

	        } else {
	          alert("삭제를 취소했습니다.");
	        }
	      }
	function toReply() {
		window.opener.location.href="sendMsg.jsp";
		window.close();
	}
	function reload(){
    window.opener.location.reload();
    window.close();
	}
	
</script>
  <body>
    <div id="smWrap">
      <form action="sendMsg" method="post">
      <h1 class="sendMsg">쪽지 조회</h1>
      보낸이 : &nbsp;<input class="receiveUserId" value=" ${sendNotes.sendnote == true ? sendNotes.sendUserId : rcvNotes.sendUserId }">
      받은이 : &nbsp;<p class="receiveUserId"> ${sendNotes.sendnote == true ? sendNotes.receiveUserId : rcvNotes.receiveUserId }</p>
      <input type="text" readonly name="title" maxlength="30" value=" ${sendNotes.sendnote == true ? sendNotes.title : rcvNotes.title }" class="title"><br>
      <div class= "text_box">
      <textarea name="msg" readonly > ${sendNotes.sendnote == true ? sendNotes.msg : rcvNotes.msg }</textarea><br>
      </div>
      <input class="submit_btn" onclick="window.open('../Note/resendMsg?receiveUserId=${sendNotes.sendnote == true ? sendNotes.sendUserId : rcvNotes.sendUserId }', '_blank', 'width=600, height=600') " type="button" value="답장">
      <input id="Delete" class="submit_btn" onclick="toDelete()" type="submit" value="삭제">
      </form>
    </div>
  <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
  </body>
</head>

</html>