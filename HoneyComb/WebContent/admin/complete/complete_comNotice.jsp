<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 공지작성 폼</title>
<script>
	function writeSave() {

		/* if (document.writeform.notice_title.value == "") {
			alert("제목을 입력하십시요.");
			document.writeform.notice_title.focus();
			return false;
		} */

		if (document.writeform.notice_content.value == "") {
			alert("내용을 입력하십시요.");
			document.writeform.notice_content.focus();
			return false;
		}else{
			var num = notice_num;
			
			url = "complete_comNotice.admin?notice_num=" + num;

				  window
						.open(
								url,
								"post",
								"toolbar=no,width=300,height=500,directories=no,status=yes,scrollbars=yes,menubar=no");
		}

	}
</script>

</head>
<body>

	<form method="post" name="writeform" action="/HoneyComb/complete/complete_comNoticeAction.admin" onsubmit="return writeSave()">
	
		<!-- 글제목 <input type="text" name="notice_title" size="40" maxlength="50" /> <br> -->
		공지팝업창 내용 <textarea name="notice_admin_content" rows="15" cols="30"></textarea> <br>
		
		<input type="reset" value="reset"> 
		<input type="submit" value="submit">

	</form>
	<input type="button" value="back" onclick="history.go(-1)">
</body>
</html>