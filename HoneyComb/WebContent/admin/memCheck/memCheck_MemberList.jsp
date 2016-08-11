<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../complete/view/color.jsp"%>
<html>
<head>
<title>Company MemberView</title>
</head>
<body bgcolor="<%=bodyback_c%>">

<form align="center">
	<table width="800" border="1" cellpadding="1" cellspacing="0" align="center">
		<c:if test="${ empty comMemberList }">
			<p align="center"><font color="red">Warning : Have No ComMemberList</font></p>
		</c:if>
			<c:if test="${ !empty comMemberList }">
				<h3>Detail</h3>
					<tr>
						<td width="70" align="center">MemberName</td>
						<td width="150" align="center">Email</td>
						<td width="100" align="center">PhoneNumber</td>
						<td width="70" align="center">Department</td>
						<td width="70" align="center">position</td>
					</tr>
			<c:forEach var="mem" items="${ comMemberList }">
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
		<tr>
			<td align="center"><br> <a href="javascript:this.close();">닫기</a></td>
		</tr>

</form>

</body>
</html>
