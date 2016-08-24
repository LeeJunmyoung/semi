<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 공지작성 폼</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style>
.myButton {
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	display: inline-block;
	cursor: pointer;
	color: #fff;
	font-size: 15px;
	padding: 8px 25px;
	text-decoration: none;
	margin: 20px;
	width: 100px;
}

.myButton:hover {
	background-color: #344d91;
}

.myButton:active {
	position: relative;
	top: 1px;
}
</style>


<script>
	function writeSave() {

		if (document.writeform.notice_title.value == "") {
			alert("제목을 입력하십시요.");
			document.writeform.notice_title.focus();
			return false;
		}

		if (document.writeform.notice_content.value == "") {
			alert("내용을 입력하십시요.");
			document.writeform.notice_content.focus();
			return false;
		}
	}
</script>

</head>
<body>

	<form class="col-sm-10" role="form" method="post" name="writeform"
		action="/HoneyComb/complete/complete_comNotice_admin.admin"
		onsubmit="return writeSave()">

		<div class="form-group">
			<label for="notice_admin_title">공지제목:</label> <input type="text"
				class="form-control" id="notice_admin_title"
				name="notice_admin_title">
		</div>
		<div class="form-group">
			<label for="notice_admin_content">공지내용:</label>
			<textarea class="form-control" rows="5" id="notice_admin_content"
				name="notice_admin_content"></textarea>
		</div>
		<input type="submit" class="btn btn-primary btn-xs" value="공지작성">
		<input type="button" class="btn btn-primary btn-xs" value="back"
			onclick="history.go(-1)">
	</form>
</body>
</html>