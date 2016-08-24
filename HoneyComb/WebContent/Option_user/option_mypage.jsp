<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="view/color.jsp"%>

<html>
<head>
<title>MypageMain</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function init() {
		window.location.reload(true);
	}

	function passwd_confirm() {
		// 비밀번호 찾기 폼

		var url = '/HoneyComb/Option_user/modify_passwd_confirm.option';
		open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"
				+ "scrollbars=no,resizable=no,width=550,height=400");

	}

	function user_del() {
		// 계정 삭제 폼

		var url = '/HoneyComb/Option_user/user_delete.option';
		open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"
				+ "scrollbars=no,resizable=no,width=550,height=400");

	}

	function file_extension() {
		// img파일인지 확인

		var check = document.myPage.profile_img.value; // 파일명 (확장자 포함)
		var extension = check.substr(check.length - 3); // 확장자

		if (!(extension == 'png' || extension == 'bmp' || extension == 'gif' || extension == 'jpg')) {
			// 사진파일이 아닐때
			alert("사진 파일만 선택해주세요\n * png, bmp, gif, jpg \n");
			return false;

		} else if (extension == 'png' || extension == 'bmp'
				|| extension == 'gif' || extension == 'jpg') {
			// 사진파일일때 action실행
			window.location.reload();
			return true;
		}

	}
</script>

<style>
#content {
	position: absolute;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 100;
	filter: alpha(opacity = 50);
	margin-top: 50px;
}

#main {
	background: #fff;
	position: relative;
	height: 700px;
	width: 700px;
	margin: 0 auto;
	text-align: center;
}

#my_page {
	font-size: 37px;
}

hr {
	width: 300px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #bbb;
}

table, tr, th, td {
	border-collapse: collapse;
	border: 1px solid #bbb;
	cellpadding: 0;
	cellspacing: 0;
	font-size: 14px;
	padding: 8px;
}

#table {
	margin-top: 100px;
	width: 488px;
	margin: 0 auto;
}

/* table {
	border: 1px solid;
	cellpadding: 1;
	cellspacing: 0;
	text-align: center;
} */
#img_myprofile {
	margin-top: 20px;
	width: 100px;
	height: 104px;
}

#back {
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
   width: 100px;
   margin-top: 100px;
   margin-bottom: 30px;
}

#back:hover {
   background-color: #344d91;
   color: white;
}

#back:active {
   position: relative;
   top: 1px;
}

.a {
	width: 200px;
}

.b {

}

#image {
	height: 80px;
}
#image td{
height: 100px;
padding: 0;
}

#image_b{
padding: 0;
margin:0;
width: 400px;
height:100px;
}

#image_a{
padding: 0;
margin:0;
width: 287px;
height:100px;
}
</style>
<body>

	<div id="content">
		<div id="main">
			<form name="myPage"
				action="/HoneyComb/Option_user/in_Profile_Img.option" method="post"
				enctype="multipart/form-data" onsubmit="return file_extension();">
				<h1 id="my_page">My Page</h1>
				<hr>
				<p>
				<div id="table">
					<table>

						<tr id="image">
							<td class="a" id = 'image_a'>
								<%-- ${ sessionScope.profile_img } --%> <img
								src="${ sessionScope.profile_img }" name="profile_img"
								onerror="this.src='/HoneyComb/images/user.png'" title="내 프로필 사진" id = 'img_myprofile'>
							</td>
							<td class="b" id = 'image_b'> * '파일선택'을 클릭하여 프로필사진을 등록하세요 
							<input 	type="file" value="선택" name="profile_img"> 
							<br> 
							<input type="submit" value="등록"></td>
						</tr>

						<tr>
							<td class="a">Name</td>
							<td class="b">${name}</td>
						</tr>

						<tr>
							<td class="a">Email</td>
							<td class="b">${ sessionScope.email }</td>
						</tr>

						<tr>
							<td class="a">Change Password</td>
							<td class="b"><input type="button" value="변경"
								onclick="passwd_confirm()"></td>
						</tr>

						<tr>
							<td class="a">Delete Account</td>
							<td class="b"><input type="button" value="계정삭제" onclick="user_del()" /></td>
						</tr>
					</table>
				</div>

				<p>
					<a href="/HoneyComb/page_layout/Option/Option_home.jsp" id="back">뒤로가기</a>
			</form>
		</div>
	</div>

</body>
</html>
