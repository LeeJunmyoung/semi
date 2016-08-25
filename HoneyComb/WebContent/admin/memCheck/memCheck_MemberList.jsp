<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../complete/view/color.jsp"%>
<html>
<head>
<title>Company MemberView</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>

<style>
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

#memCheck_table {
	width: 800px;
	text-align: center;
	margin: auto;
}

#h1_tag {
	width: 300px;
	margin: auto;
	font-size: 40px;
	text-align: center;
}

h1 {
	width: 500px;
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
</style>

</head>
<body bgcolor="<%=bodyback_c%>">

	<div id='h1_tag'>
		<br> Detail
		<hr>
	</div>
	<form align="center">
		<table width="800" border="1" cellpadding="1" cellspacing="0"
			align="center" id="memCheck_table">
			<c:if test="${ empty comMemberList }">
				<p align="center">
					<font color="red">Warning : Have No ComMemberList</font>
				</p>
			</c:if>
			<c:if test="${ !empty comMemberList }">
				<tr>
					<td width="70" class="title" align="center">MemberName</td>
					<td width="150" class="title" align="center">Email</td>
					<td width="100" class="title" align="center">PhoneNumber</td>
					<td width="70" class="title" align="center">Department</td>
					<td width="70" class="title" align="center">position</td>
				</tr>
				<c:forEach var="mem" items="${ comMemberList }">
					<br>
					<tr>
						<td width="70" align="center">${ mem.name }</td>
						<td width="150" align="center">${ mem.email }</td>
						<td width="100" align="center">${ mem.phone_num }</td>
						<td width="70" align="center">${ mem.com_dept_name }</td>
						<td width="70" align="center">${ mem.com_pos_name }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<div id="close_button_div">

			<input type="button" class="btn btn-primary btn-xs" value="close"
				id='close_button' onclick="window.close()">
		</div>

	</form>

</body>
</html>
