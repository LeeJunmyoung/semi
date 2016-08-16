<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="view/color.jsp"%>

<html>
<head>
<title>MypageMain</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

	function init() {
		window.location.reload();
	}
	
	function passwd_confirm() {
		// 비밀번호 찾기 폼

		var url = '/HoneyComb/Option_user/modify_passwd_confirm.option';
		open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"
				+ "scrollbars=no,resizable=no,width=550,height=400");

	}

	function user_del() {
		// 계정 삭제 폼

		var url = '/HoneyComb/Option_user/user_delete_reLogin.jsp';
		open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"
				+ "scrollbars=no,resizable=no,width=550,height=400");

	}

	function file_extension() {
		// img파일인지 확인

		var check = document.myPage.profile_img.value;
		var extension = check.substr(check.length-3);
			
		if (!(extension == 'png' || extension == 'bmp' || extension == 'gif' || extension == 'jpg')) {
			
			alert("사진 파일만 선택해주세요\n * png, bmp, gif, jpg \n");
			return false;
			
		}else if (extension == 'png' || extension == 'bmp' || extension == 'gif' || extension == 'jpg') {

			return true;
		}

	}
</script>
<body bgcolor="<%=bodyback_c%>">

	<form name="myPage" align="center"
		action="/HoneyComb/Option_user/in_Profile_Img.option" method="post"
		enctype="multipart/form-data" onsubmit="return file_extension();">
		<h3>My Page</h3>
		<p>
		<table border="1" cellpadding="1" cellspacing="0" align="center">

			<tr>
				<td align="center"><%-- ${ sessionScope.profile_img } --%>
				<img src="${ sessionScope.profile_img }" name="profile_img" width="68" height="70"
					onerror="this.src='/HoneyComb/images/user.png'" title="내 프로필 사진"></td>
				<td><p><font size="1.5"> * '파일선택'을 클릭하여 프로필사진을 등록하세요</font></p>
				<input type="file" value="선택" name="profile_img">
				<br>
				<input type="submit" value="등록"></td>
			</tr>

			<tr>
				<td align="center">이름</td>
				<td>${name}</td>
			</tr>
			
			<tr>
				<td align="center">이메일</td>
				<td>${ sessionScope.email }</td>
			</tr>

			<tr>
				<td align="center">비밀번호 변경하기</td>
				<td><input type="button" value="변경" onclick="passwd_confirm()"></td>
			</tr>

			<tr>
				<td align="center">계정삭제</td>
				<td><input type="button" value="계정삭제" onclick="user_del()" /></td>
			</tr>

		</table>
		<p>
			<input type="button" value="back" align="center" onclick="history.go(-1)">
	</form>

</body>
</html>