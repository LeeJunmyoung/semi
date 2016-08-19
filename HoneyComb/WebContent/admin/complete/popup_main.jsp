<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>공지팝업</title>
</head>
<body>
	<c:if test="${ !empty popup }">
		<c:forEach var="pop" items="${ popup }">
			<table width="320" border="1" bordercolor="#cccccc" align="center"
				cellpadding="5" cellspacing="0">
				<tr bgcolor="#ffcc00">
					<td aling="center" colspan="2"><B>공지사항</B></td>
				</tr>
				<tr>
					<td>Subject</td>
					<td align="center">${pop.notice_admin_title}</td>
				</tr>
				<tr>
					<td colspan="2">Content</td>
				</tr>
				<tr>
					<td colspan="2">${pop.notice_admin_content }</td>
				</tr>
			</table>
			<p align="center"><font size="1">작성일
					${pop.notice_admin_date }</font></p>
		</c:forEach>
	</c:if>
	<br />
	<center>
		<a href="javascript:this.close();">닫기</a>
	</center>


</body>
</html>