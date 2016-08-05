<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>content</title>
</head>
<body>
	<form>
		<table width="500" border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center" width="125">작성자</td>
				<td align="center" width="125" align="center">${article.notice_member}</td>
				<td align="center" width="125">작성일</td>
				<td align="center" width="125" align="center">${article.notice_date}</td>
			</tr>
			<tr>
				<td align="center" width="125">글제목</td>
				<td align="center" width="375" colspan="3">${article.notice_title}</td>
			</tr>
			<tr>
				<td align="center" width="125">글내용</td>
				<td align="left" width="375" colspan="3"><div>${article.notice_content}</div></td>
			</tr>
		</table>
	</form>

</body>
</html>