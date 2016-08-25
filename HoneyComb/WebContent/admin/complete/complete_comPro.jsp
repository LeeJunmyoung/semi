<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>사업장 누를시 띄움</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<style>
#h1_tag {
	width: 300px;
	margin: auto;
	font-size: 20px;
	text-align: center;
}

h1 {
	width: 200px;
	margin: auto;
	text-align: center;
}

#close_button {
	position: relative;
	top: 60px;
}

#close_button {
	width: 50px;
	margin: auto;
}

#close_button_div {
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

#title>tbody {
	overflow-y: auto;
	overflow-x: hidden;
	max-height: 150px;
}

#title th {
	background: #344d91;
	color: white;
	font-size: 16px;
	letter-spacing: 1.5px;
	font-weight: bold;
	padding: 10px;
	text-align: center;
	color: white;
}
</style>
</head>
<body bgcolor="<%=bodyback_c%>">

	<div id='h1_tag'>
		<br>선택된 사업장 정보
		<hr>
	</div>
	<br>
	<center>
		<form>
			<table width="400" border="1" cellpadding="1" cellspacing="0">
				<c:forEach var="comp" items="${comList}">
					<tr>
						<td align="center" class="title" width="100">사업장명</td>
						<td align="center" class="title" width="100">주소</td>
						<td align="center" class="title" width="100">사업장계열</td>
						<td align="center" class="title" width="100">전화번호</td>
					</tr>
					<tr>
						<td width="300" align="center">${comp.com_name}</td>
						<td width="300" align="center">${comp.com_add}</td>
						<td width="300" align="center">${comp.com_aff}</td>
						<td width="300" align="center">${comp.com_phone}</td>
					</tr>
				</c:forEach>
			</table>
			<div id="close_button_div">

				<input type="button" class="btn btn-primary btn-xs" value="close"
					id='close_button' onclick="window.close()">
			</div>
		</form>
	</center>

</body>
</html>
