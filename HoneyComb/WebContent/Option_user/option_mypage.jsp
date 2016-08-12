<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Mypage</title>
</head>

<script type="text/javascript">

function passwd_confirm() {
	alert("!");
	
	var url = '/HoneyComb/Option_user/modify_passwd_confirm.option';
	open(
			url,
			"confirm",
			"toolbar=no,location=no,status=no,menubar=no,"
					+ "scrollbars=no,resizable=no,width=550,height=400");

}

function user_del() {
	
	var url = '/HoneyComb/Option_user/modify_passwd_cofirm.jsp';
	open(
			url,
			"confirm",
			"toolbar=no,location=no,status=no,menubar=no,"
					+ "scrollbars=no,resizable=no,width=550,height=400");

}

</script>
<body>
<div align="center">
<table border="1" cellpadding="1" cellspacing="0" align="center">
<tr><td>사진</td><td> 사진 넣기  </td></tr>
<tr><td>이름</td><td>${name}</td></tr>
<tr><td>비밀번호 변경하기</td><td><input type="button" value="변경" onclick="passwd_confirm()"></td></tr>
<tr><td>계정삭제</td><td><input type = "button" value="계정삭제" onclick="user_del()" /></td></tr>
</table>
</div>

</body>
</html>