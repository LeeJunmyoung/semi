<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>공지팝업</title>
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
				<table width="320" border="1" bordercolor="#cccccc" align="center"
					cellpadding="5" cellspacing="0">
					<tr bgcolor="#ffcc00">
						<td aling="center" colspan="2"><B>공지사항</B></td>
					</tr>
					<tr>
						<td align="center">Subject</td>
						<td align="center">${pop.notice_admin_title}</td>
					</tr>
					<tr>
						<td align="center" colspan="2">Content</td>
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
		<br />

		<table align="center">
		<tr>
			<td><a href="javascript:this.close();">닫기</a>
			<input type="checkbox" name="notice" onchange="closeWin()">하루동안 띄우지않기</td>
			</tr>
		</table>

	</form>

</body>
</html>
