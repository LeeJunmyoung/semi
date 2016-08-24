<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>write</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<script>
	function writeSave() {

		if (document.noticeWriteform.notice_title.value == "") {
			alert("제목을 입력하십시요.");
			document.noticeWriteform.notice_title.focus();
			return false;
		}

		if (document.noticeWriteform.notice_content.value == "") {
			alert("내용을 입력하십시요.");
			document.noticeWriteform.notice_content.focus();
			return false;
		}

	}
</script>

</head>
<body style="background-color: #e9ebee;">

	<form class="col-sm-10" role="form" method="post" name="noticeWriteform" 
		action="/HoneyComb/notice/noticeWritePro.notice" onsubmit="return writeSave()" >
		
		<div class="form-group">
			<label for="notice_title">공지제목:</label>
			<input type="text" class="form-control" id="notice_title" name="notice_title">
		</div>
		
		<div class="form-group">
			<label for="notice_content">공지내용:</label>
			<textarea class="form-control" rows="5" id="notice_content" name="notice_content"></textarea>
		</div>
		
		<input type="submit" class="btn btn-primary btn-xs" value="공지작성">
		
	</form>
	
</body>
</html>