<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>relogin</title>
<script>
	function user_check() {

		var user_passwd = document.user.session.value; // user passwd
		var pw1 = document.user.passwd1.value; // 입력 비밀번호
		var pw2 = document.user.passwd2.value; // 입력 비밀번호 확인 

		if (pw1 == "" || pw2 == "") {
			alert("비밀번호를 입력해주세요");
			return false;
		} else if (!(pw1 == user_passwd)) {
			alert("비밀번호가 틀렸습니다\n다시 입력해주세요");
			return false;
		} else if (!(pw2 == user_passwd)) {
			alert("비밀번호 확인이 틀렸습니다\n다시 입력해주세요");
			return false;
			;
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
<style>
#title {
	font-size: 25px;
}

hr {
	width: 300px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #bbb;
}

.button {
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	display: block;
	cursor: pointer;
	color: #fff;
	font-size: 15px;
	padding: 5px 10px;
	text-decoration: none;
	margin: 0 auto;
}

.button:hover {
	background-color: #344d91;
	color: white;
}

.button:active {
	position: relative;
	top: 1px;
}

input[type=password], input[type=text] {
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	font-size: 16px;
	padding-left: 10px;
	text-align: lift;
	margin-top: 5px;
}
</style>
</head>
<body>

			<form name="user" align="center" onsubmit="return user_check()"
				method="post" action="/HoneyComb/Option_user/user_del_compl.option">
				<h1 id="title">Delete Account</h1>
				<hr>
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
				</table>
				<br> <input type="submit" value="계정삭제" align="center"
					class="button">
			</form>

</body>
</html>