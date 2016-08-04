<!-- 로그인창 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="/HoneyComb/view/script.js"  type="text/javascript" ></script>
<title>LogIn</title>
</head>
<body>
<form action="/HoneyComb/coin/LogInPro.coin" method="post" onsubmit="return checkEmail()" name="myform">
	<div id="infotext">
		<p><input type="text"  placeholder="email" name="email"/></p>
		<p><input type="password"  placeholder="password" name="passwd"></p>
	</div>
	
	<div id="buttoncheck">
		<input type="submit" value="LogOn"/>
	</div>
</form>
<div id="clicktext">
	<span>
		<a href="/HoneyComb/coin/FindEmail.coin">find Email</a>
	</span>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<span>
		<a href="/HoneyComb/coin/FindPasswd.coin">find Password</a>
	</span>
</div>
</body>
</html>