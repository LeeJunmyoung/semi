<!-- 회원가입창 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/HoneyComb/view/script.js"  type="text/javascript" ></script>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<!-- /* 이메일인증후 확인 */ -->
<script>
$(function(){
	$('#mailcheck').blur(function(){
		var text = "y"
		if($('#mailtext').val()==text){
		$('#textProp').html("이메일 확인 완료!");
			
		}else{
			$('#textProp').html("이메일 확인 버튼을 눌러주세요");
		}
	});
});
/* 이메일인증후 확인  끝*/

/* 패스워드 일치확인  */
$(function(){
$('#passfunc').keyup(function(){
	if($('#passwd').val() == ""){
		$('#passwdcheck').html("");
		return
	}
	if($('#checkpasswd').val() == ""){
		$('#passwdcheck').html("비밀번호 확인을 해주세요");
		return
	}
	if($('#passwd').val() == $('#checkpasswd').val()){
    $('#passwdcheck').html("비밀번호가 일치합니다");
	
	}else{
		$('#passwdcheck').html("비밀번호가 일치하지않습니다");
	}
	
	});
});
/* 패스워드 일치 확인끝 */







function filter(){
	if($('#phone1').val().length==3){
	
		$('#phone2').focus();
	 
	
	return false;

	}
	if($('#phone2').val().length==4){
		
		$('#phone3').focus();
	 
	
	return false;

	}
}


function filter1(){
	if($('#phone2').val().length==4){
		
		$('#phone3').focus();
	 
	
	return false;

	}
}
</script>
<title>회원가입</title>
</head>
<body>
<form name="myform" OnSubmit="return checkIt()" action="/HoneyComb/coin/SignInpro.coin" method="post">
	<!-- 이메일 입력창 -->
    <input type="text" value="${email}" placeholder="email" name="email"/>
    <input type="button"  id="mailcheck" value="Email확인" OnClick="checkmail(this.form)">
    <p id="textProp"></p>
    <input type="hidden" id="mailtext" value="" name="test">
     	
    <!-- 비밀번호 입력창 -->
    <div id="passfunc">
    <p><input type="password" placeholder="passwd" name="passwd" id="passwd"/></p>
    <p><input type="password" placeholder="checkpasswd" name="checkpasswd" id="checkpasswd"></p>
    <p id="passwdcheck"/>
    </div>
    
   	
    	
    <!-- 전화번호 입력창 -->
    <p><input type="text" placeholder="name" name="name"/></p>
    <p><input type="text" placeholder="phone1" name="pnum1" maxlength="3" id='phone1' onkeyup='{filter();return false}' onkeypress='javascript:if(event.keyCode==3){ filter(); return false;}' /> - 
       <input type="text" placeholder="phone2" name="pnum2" maxlength="4" id='phone2' onkeyup='{filter1();return false}' onkeypress='javascript:if(event.keyCode==4){ filter1(); return false;}' /> - 
       <input type="text" placeholder="phone3" name="pnum3" maxlength="4" id='phone3' /></p>
     <p>
     <input type="submit" value="회원가입" name="signin"/></p>
</form>
</body>
</html>