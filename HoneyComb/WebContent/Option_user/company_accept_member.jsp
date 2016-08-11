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
					<input type="button" value="승인" onclick="window.open('/HoneyComb/Option_user/accept_member.option?wait_mem_num=${member.mem_num}&wait_mem_dept_num=${member.com_dept_num}&wait_pos_num=${member.com_pos_num}')">
					<input type="button" value="거절" onclick="location.href='#'"></td>
				</tr>


			</c:forEach>
</table>
</c:if>
<c:if test="${empty temp_member }">
<h1>승인대기자가 없습니다 </h1>

</c:if>
<input type="button" value="back" onclick="history.go(-1)">
</body>
</html>