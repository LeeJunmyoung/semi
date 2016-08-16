<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>현재원</title>
</head>
<body bgcolor="<%=bodyback_c%>">

		<form name="memberCheck" align="center">
			<h3 align="center">회사원</h3>
			<table align="center" border="1" cellpadding="1" cellspacing="0">
			<tbody>
			<c:if test="${ empty memberlist }">
					<tr>
						<td colspan="5" align="center">회사원이 없습니다</td>
					</tr>
				</c:if>
				<c:if test="${ !empty memberlist }">
			<tr>
				<td width="80">부서</td>
				<td width="80">직급</td>
				<td width="70">이름</td>
				<td width="200">전화번호</td>
				<td width="250">이메일</td>
			</tr>
					<c:forEach var="member" items="${memberlist}">
				<tr>
				<td>${member.com_dept_name}</td>
				<td>${member.com_pos_name}</td>
				<td>${member.name}</td>
				<td>${member.phone_num}</td>
				<td>${member.email}</td>
				</tr>
				</c:forEach>
				</c:if>
				</tbody>
			</table>
			<p>
			<input type="button" value="back" align="center" onclick="history.go(-1)">
	</form>

</body>
</html>