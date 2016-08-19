<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>공지팝업</title>
</head>
<body>
	<table width="320" border="1" bordercolor="#cccccc" align="center"
		cellpadding="5" cellspacing="0">
		<tr bgcolor="#ffcc00">
			<td aling="center"><B>공지사항</B></td>
		</tr>
		<tr bordercolor="white">
			<td align="center">${popup}</td>
		</tr>
	</table>
	<br />
	<center>
		<a href="javascript:this.close();">닫기</a>
	</center>


</body>
</html>