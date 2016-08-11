<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
관리자 페이지
<p>
	<tr>
		<td><input type="button" value="현황 확인"
				onClick="javascript:window.location='/HoneyComb/memCheck/memCheck_Main.mc'"></td>
	</tr>
	<p>
		<tr>
			<td><input type="button" value="회사 승인"
				onClick="javascript:window.location='/HoneyComb/complete/complete_com.admin'"></td>
		</tr>
	<p>
		<tr>
			<td><input type="button" value="리포트 확인"></td>
		</tr>
	<p>
		<tr>
			<td><input type="button" value="관리자 공지 보내기"></td>
		</tr>
</body>
</html>