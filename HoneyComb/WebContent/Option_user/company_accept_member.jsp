<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty temp_member }">
<table border = 1px>
<c:forEach var="member" items="${temp_member}">
				<tr>
					<td>${member.name}</td>
					<td>${member.com_dept_name}</td>
					<td>${member.com_pos_name}</td>
					<td>
					<input type="button" value="승인" onclick="location.href='/HoneyComb/Option_user/accept_member.option'">
					<input type="button" value="거절" onclick="location.href='#'"></td>
				</tr>


			</c:forEach>
</table>
</c:if>
</body>
</html>