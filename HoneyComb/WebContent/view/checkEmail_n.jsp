<!-- //이메일이 중복일때  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>회원가입</title>
<script language="javascript" src="/HoneyComb/view/script.js"></script>
<body>
	<p>
		입력하신 ${param.email}은 사용중인 이메일 입니다.<Br> 다른 이메일을 입력해주세요
	</p>
	<form action="/HoneyComb/coin/MailCheck.coin" onsubmit="return checkEmail()" name="myform">
		<input type="text" placeholder="email을 입력해주세요" name="email"> <input type="submit" value="확인">
		<br> 
		<div id="clicktext"><input type="button" onclick="window.close()" value="닫기"></div>
	</form>



</body>
</html>