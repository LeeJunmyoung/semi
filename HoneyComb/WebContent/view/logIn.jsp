<!-- 로그인창 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 

H    H  EEEEEE  L       L        OOO    
H    H  E       L       L       O   O    
HHHHHH  EEEEEE  L       L      O     O    
H    H  E       L       L       O   O      
H    H  EEEEEE  LLLLLL  LLLLLL   OOO       


W           W    OOO    RRRRRR     L       DDDD     !!!
 W         W    O   O   R    R     L       D   D    !!!
  W   W   W    O     O  RRRRR      L       D	D   !!!
   W W W W      O   O   R    R     L       D   D      
    W   W        OOO    R     R    LLLLLL  DDDD     !!!

 -->

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
		<a href="/HoneyComb/view/findEmail.jsp">find Email</a>
	</span>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<span>
		<a href="/HoneyComb/view/findPasswd.jsp">find Password</a>
	</span>
</div>
</body>
</html>