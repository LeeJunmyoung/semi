<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>공지팝업</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<style>
.title {
	background: #344d91;
	color: white;
}

#title {
	table-layout: fixed;
	position: relative;
	margin: 0 auto;
}

#close_button {
	margin: auto;
}
</style>
<script>
	function setCookie(name, value, expiredays) {
		var todayDate = new Date();
		todayDate.setDate(todayDate.getDate() + expiredays);
		document.cookie = name + "=" + escape(value) + "; path=/; expires="
				+ todayDate.toGMTString() + ";"
	}

	function closeWin() {
		{
			if (document.noticeform.notice.checked)
				setCookie("CookieName", "no", 1);
		}
		top.close();
	}
</script>
</head>
<body>

	<form name="noticeform">
		<c:if test="${ !empty popup }">
			<c:forEach var="pop" items="${ popup }">
				<br>
				<table width="320" border="1" bordercolor="#cccccc" align="center"
					cellpadding="5" cellspacing="0">
					<tr>
						<td align="center" class="title" colspan="2"><h4>공지사항</h4></td>
					</tr>
					<tr>
						<td align="center">${pop.notice_admin_title}</td>
					</tr>
					<tr>
						<td align="center" colspan="2">${pop.notice_admin_content }</td>
					</tr>
				</table>
				<p align="center">
					<font size="1">작성일 ${pop.notice_admin_date }</font>
				</p>
			</c:forEach>
		</c:if>

		<table align="center">
			<tr>
				<td><input
					type="checkbox" name="notice" onchange="closeWin()">하루동안
					띄우지않기 <input type="button" class="btn btn-primary btn-xs"
					value="close" id='close_button' onclick="window.close()"></td>
			</tr>
		</table>

	</form>

</body>
</html>
