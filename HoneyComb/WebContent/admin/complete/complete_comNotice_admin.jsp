<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>공지완료폼</title>
</head>

<c:forEach var="notice" items="${noticeList}">
<table width="320" border="1" bordercolor="#cccccc" align="center" cellpadding="5" cellspacing="0">
<tr bgcolor="#ffcc00">
<td aling="center"><B>공지사항</B></td>
</tr>
<tr bordercolor="white">
<td align="center">
${notice.notice_admin_content}
</td>
</tr>
</table>
<br/>
<center>
<a href="javascript:this.close();">닫기</a>
</center>
</c:forEach>
</body>
</html>