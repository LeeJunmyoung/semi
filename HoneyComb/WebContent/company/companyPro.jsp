<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>사업장 등록 완료</title>
<script type="text/javascript">
function tomain(){
	location="/HoneyComb/coin/LogOnCheck.coin"
}
</script>
</head>
<body bgcolor="<%=bodyback_c%>" onLoad="setTimeout('tomain()',5000)">

	<center>
		<form>
			<h3>사업장 등록 완료</h3>
			<h5>다음과 같이 성공적으로 신청이 완료되었습니다!</h5>

			<table align="center" border="1"  cellpadding="0" cellspacing="0" >
				<tr>
					<td align="center" width="80">사업장명</td>
					<td width="300">${com_name}</td>
				</tr>
				<tr>
					<td align="center" width="80">주소</td>
					<td width="300">${com_add}</td>
				</tr>
				<tr>
					<td align="center" width="80">전화번호</td>
					<td width="300">${com_phone}</td>
				</tr>
				<tr>
					<td align="center" width="80">계열</td>
					<td width="300">${com_aff}</td>
					
				</tr>
				
			</table>
		</form>
		<br>5초후 사업장 등록 페이지로 이동합니다.
	</center>

</body>
</html>
