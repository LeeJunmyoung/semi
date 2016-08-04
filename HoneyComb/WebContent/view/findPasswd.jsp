<!-- 비밀번호 찾기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/HoneyComb/view/script.js"  type="text/javascript" ></script>
<title>비밀번호찾기</title>
</head>
<body>
<h3>비밀번호 찾기</h3>
<form name="myform"  " action="/HoneyComb/coin/FindPasswdPro.coin" onSubmit = "return checkEmail()"method="post">
	Email을 입력해주세요<br>
    <input type="text" placeholder="email" name="email"/>
    <p id="textProp"></p>
    <input type="hidden" id="mailtext" value="" name="test">

    <input type="submit" value="비밀번호 재설정"/>
</form>
</body>
</html>