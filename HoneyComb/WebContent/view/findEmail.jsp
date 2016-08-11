<!-- 이메일찾기 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<title>Email찾기</title>
<script type="text/javascript">



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

</head>
<body>
	<form action="/HoneyComb/coin/FindEmailPro.coin">
	이름을 입력해주세요<br>
	<input type="text"  placeholder="Name" name="name" /><br>
	전화번호를 입력해주세요<br>
		<input type="text"  placeholder="phone1" id='phone1'  name="phone1" maxlength="3"  onkeyup='{filter();return false}' onkeypress='javascript:if(event.keyCode==3){ filter(); return false;}'/> -
		<input	type="text"  placeholder="phone2" id='phone2' name="phone2" maxlength="4"  onkeyup='{filter1();return false}' onkeypress='javascript:if(event.keyCode==4){ filter1(); return false;}'/>  -
		<input type="text"  placeholder="phone3" id='phone3' name="phone3" maxlength="4"/><br>

	<input type="submit" value="find Email" />
	</form>
</body>
</html>