<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>공지완료폼</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<style>
#back_button {
	position: relative;
	top: 40px;
	width: 50px;
	margin: 0 auto;
	margin-bottom: 50px;
}

#back_button_div {
	width: 60px;
	margin: auto;
}

.title {
	background: #344d91;
	color: white;
}

#title {
	table-layout: fixed;
	position: relative;
	margin: 0 auto;
}
</style>
</head>
<br>
<c:forEach var="notice" items="${noticeList}">
	<table width="320" border="1" bordercolor="#cccccc" align="center"
		cellpadding="5" cellspacing="0">
		<tr bgcolor="#ffcc00">
			<td align="center" class="title"><B>공지사항</B></td>
		</tr>
		<tr bordercolor="white">
			<td align="center">${notice.notice_admin_title}<br>
				${notice.notice_admin_content}<br> ${notice.notice_admin_date}<br>
			</td>
		</tr>
	</table>
	<br />
	<div id="back_button_div">

		<input type="button" class="btn btn-primary btn-xs" value="back"
			id='back_button'
			onclick="javascript:window.location='/HoneyComb/admin/admin_main.jsp'">
	</div>
</c:forEach>
</body>
</html>