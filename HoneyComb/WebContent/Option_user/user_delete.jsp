<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>relogin</title>
<script>
	function user_check() {

		alert("님 왜 안옴? 외않되!");
		var user_passwd = document.user.session.value; // user passwd
		var pw1 = document.user.passwd1.value; // 입력 비밀번호
		var pw2 = document.user.passwd2.value; // 입력 비밀번호 확인 

		if (!(pw1 == user_passwd) || pw1 == "") {
			alert("비밀번호를 확인해주세요");
			return false;
		} else if (!(pw2 == user_passwd) || pw2 == "") {
			alert("비밀번호를 확인해주세요");
			return false;
		}

		if (pw1 == user_passwd && pw2 == user_passwd) {
			var del = confirm("정말 삭제하시겠습니까?");
			if (del) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
</script>
</head>
<body>
	<!-- method="post" action="/HoneyComb/Option_user/user_del_compl.option" -->

	<form name="user" align="center" onsubmit="return user_check()"
		method="post" action="/HoneyComb/Option_user/user_del_compl.option">
		<h2>비밀번호를 입력해주세요</h2>
		<p>
		<table align="center">
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd1"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="Password" name="passwd2"><input
					type="hidden" name="session" value="${ passwd }"></td>
			</tr>
			<tr>
				<td><input type="submit" value="계정삭제" align="center"></td>
			</tr>
		</table>
	</form>

</body>
</html>
