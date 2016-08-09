<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>채팅 멤버 추가</title>
</head>
<body>


	<div align = "center">
		<input type="text" placeholder="이름">

		<table>
		
			<tr>
				<td>이름</td>
				<td>직책</td>
				<td>부서</td>
			</tr>
			<c:if test="${ !empty chat_members }">
				<c:forEach var="members" items="${chat_members}">
					<tr>
						<td>${members.name}</td>
						<td>${members.com_pos_name}</td>
						<td>${members.com_dept_name}</td>
					</tr>
				</c:forEach>
			</c:if>

		</table>
	</div>



</body>
</html>