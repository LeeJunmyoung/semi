<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="view/color.jsp"%>
<html>
<head>
<title>비밀번호 확인</title>
<script>
	var check_pw = false;

	function PW_Check(pw) {

		var passwd = pw;
		check_pw = 0;
		if (document.pwChange.pw.value == "") {
			alert("비밀번호를 입력하세요");
			document.pwChange.pw.focus();
			check_pw = false;
			return false;
		}

		if (document.pwChange.pw.value == passwd) {
			alert("비밀번호가 일치합니다!");
			document.pwChange.newpw1.focus();
			check_pw = true;
			return false;
		}

		if (!document.pwChange.pw.value != passwd) {
			alert("비밀번호가 일치하지 않습니다!");
			document.pwChange.pw.focus();
			check_pw = false;
			return false;
		}

	}

	function PW_Same() {

		if (check_pw == false) {
			alert("인증부터 받으세요");
			return false;
		}
		if (document.pwChange.newpw1.value != document.pwChange.newpw2.value
				|| document.pwChange.newpw1.value == ""
				|| document.pwChange.newpw2.value == "") {
			alert("변경할 비밀번호를 확인하세요");
			document.pwChange.newpw1.focus();
			return false;
		} else {
			alert("비밀번호가 성공적으로 변경되었습니다");
			return true;
		}
	}
</script>
</head>
<body bgcolor="<%=bodyback_c%>">

	<form align="center" name="pwChange" method="post"
		action="/HoneyComb/Option_user/Option_Passwd_Change.option"
		onsubmit="return PW_Same()">
		<h3>비밀번호 변경</h3>
		<table align="center">
			<tr>
				<td>현재 비밀번호</td>
				<td><input width="100" height="50" type="password" id="pw"
					placeholder="PassWD"></td>
				<td><input type="button" onclick="return PW_Check('${passwd}')"
					value='Check'></td>
			</tr>
			<tr>
				<td>변경 비밀번호</td>
				<td><input type="password" id="newpw1" name='newpw1'></td>
			</tr>
			<tr>
				<td>변경 비밀번호 확인</td>
				<td><input type="password" id="newpw2"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="변경"></td>
				<td align="center"><input type="button" value="닫기"
					onclick="history.go(-1)"></td>
			</tr>
		</table>
	</form>

</body>
</html>
