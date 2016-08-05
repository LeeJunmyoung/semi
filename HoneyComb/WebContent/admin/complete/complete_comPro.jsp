<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>체크박스 클릭시 실행</title>
</head>
<body>

	<center>
		<form>
			<h3>선택된 사업장 정보</h3>
			<table width="400" border="1" cellpadding="1" cellspacing="0">
				<c:forEach var="comp" items="comList">
					<tr>
						<td align="center" width="100">사업장명</td>
						<td width="300">${ com_name }</td>
					</tr>
					<tr>
						<td align="center" width="100">주소</td>
						<td width="300">${ com_add }</td>
					</tr>
					<tr>
						<td align="center" width="100">사업장계열</td>
						<td width="300">${ com_aff }</td>
					</tr>
					<tr>
						<td align="center" width="100">전화번호</td>
						<td width="300">${ com_phone }</td>
					</tr>
				</c:forEach>
			</table>
			<p>
				<input type="button" value="확인" onclick="window.close()">
		</form>
	</center>

</body>
</html>