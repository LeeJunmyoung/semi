<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%request.getSession().invalidate(); %>
<center>
<h1>승인 대기중입니다.</h1>
<img src="/HoneyComb/temp_accept_page/img/wait.gif" width="450px" height="300px">
<button onclick="location.href='/HoneyComb/index.jsp'">확인</button>
</center>
</body>
</html>