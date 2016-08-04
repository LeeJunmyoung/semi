<!-- 이메일찾기 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Email찾기</title>
</head>
<body>
	<form action="/HoneyComb/coin/FindEmailPro.coin">
	이름을 입력해주세요<br>
	<input type="text"  placeholder="Name" name="name" /><br>
	전화번호를 입력해주세요<br>
		<input type="text"  placeholder="phone1" name="phone1" /> -
		<input	type="text"  placeholder="phone2" name="phone2" />  -
		<input type="text"  placeholder="phone3" name="phone3" /><br>

	<input type="submit" value="find Email" />
	</form>
</body>
</html>