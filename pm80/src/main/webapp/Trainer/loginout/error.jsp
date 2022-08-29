<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
   <script type="text/javascript">
      var message = "로그인 정보 불일치";
      var returnUrl = "admin.jsp";
      alert(message);
      document.location.href = returnUrl;
   </script>
</body>
</html>