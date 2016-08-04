<!-- 비밀번호 찾기_이메일 전송후 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/HoneyComb/view/script.js"  type="text/javascript" ></script>
<script src=" https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
$(function(){
	$('#key').keyup(function(){
		var key = ${key}; 
		
		$('#setkey').css("visibility","hidden");
		if($('#key').val() == ""){
			$('#checkkey').html("");
			$('#setkey').css("visibility","visible");
		}else if($('#key').val() == key){
			$('#checkkey').html("인증번호가 일치합니다.");
			$('#changepasswd').removeAttr('disabled');
			$('#newpasswd').removeAttr('disabled');
			
		}else{
			$('#checkkey').html("인증번호가 일치하지 않습니다");
			
		};
	});
});
</script>
<title>비밀번호찾기</title>
</head>

<body>
<form action="/HoneyComb/coin/UpdatePasswd.coin" method="post">
	<h3>${email}로 인증번호를 전송하였습니다.</h3>
	<p id="setkey" >인증번호를 입력해 주세요</p>
	<input type="text" id = "key">
	<p id = "checkkey"></p>
	<input type="text" id="newpasswd" name="newpasswd" disabled="disabled" >
	<input type="hidden" value="${email}" name="email">
	<input type="submit" value="비밀번호 변경" id="changepasswd" disabled="disabled"><br>
	<a href = "/HoneyComb/index.jsp">메인으로</a>
</form>
</body>
</html>