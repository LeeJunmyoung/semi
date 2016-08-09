<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>write</title>

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

	<form method="post" name="writeform" action="/HoneyComb/notice/noticeWritePro.notice" onsubmit="return writeSave()">
	
		글제목 <input type="text" name="notice_title" size="40" maxlength="50" /> <br>
		글내용 <textarea name="notice_content" rows="15" cols="30"></textarea> <br>
		
		<input type="reset" value="reset"> 
		<input type="submit" value="submit">

	</form>
	
</body>
</html>