<!-- 이메일인증 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원가입</title>
<script type="text/javascript" src="/HoneyComb/view/script.js"></script>
<script src=" https://code.jquery.com/jquery-3.1.0.min.js"></script>

<script type="text/javascript">
$(function() {

$('#insertKey').keyup(function(){
	var key = $('#insertKey').val();
	var key2 = '${numcheck}';
	$('ok').attr('disabled', true);
	$('#keyCheck').text('');
		if(key == key2){
			$('#keyCheck').text('');
			$('#keyCheck').html("<style='color:green'>인증키가 일치합니다<style>")
			$("#ok").removeAttr("disabled");
		} 
		if(key == ""){
			$('#keyCheck').text('');
			$('#keyCheck').html("")
		}
		else{
			$('#keyCheck').text('');
			$('#keyCheck').html("<style='color:red'>인증키가 일치하지 않습니다<style>")
		}
	
}); 
});
</script>

</head>

<body>
      <p> ${param.email}로 인증번호가 전송되었습니다.</p>
      
      <input type="text" id="insertKey" placeholder="인증번호를 입력해주세요"/>
<form name="myform">
<input type="hidden" name="email" value="${param.email}">
<div id="keyCheck"></div>
<input type="hidden" name="check" value="y"/>
<p><input type="button" id="ok" value="확인" disabled="disabled" onclick="sendChildValue()"/>
<input type="button" value="닫기" onclick="frameclose()"/></p>
</form>
</body>
</html>