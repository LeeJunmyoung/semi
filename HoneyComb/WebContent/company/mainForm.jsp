<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body bgcolor="<%=bodyback_c%>">

	<center>
		<form name="main">
			<tr>
				<td><input type="button" value="사업장 등록하기"
					onClick="javascript:window.location='/HoneyComb/company/companyForm.jsp'"></td>
			</tr>
			<p>
				<tr>
					<td><input type="button" value="내 회사 등록하기"
						onClick="javascript:window.location='/HoneyComb/company/companyFindForm.jsp'"></td>
				</tr>
		</form>
	</center>

</body>
</html>
