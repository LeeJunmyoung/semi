<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../complete/view/color.jsp"%>
<html>
<head>
<title>Insert title here</title>



<script>

	function memberList(com_num) {

		url = "memCheck_MemberList.mc?com_num=" + com_num;
		window.open(url, "post", "toolbar=no,width=1000,height=500,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
</script>
</head>
<body bgcolor="<%=bodyback_c%>">

	<form align="center">
		<h3>현황 확인</h3>
		<input type="text" placeholder="Company" name="com_name">
		<input type="submit" value="search" onclick="return searchClick(this)">
		<p>
		<table width="800" border="1" cellpadding="1" cellspacing="0" align="center">
			<tr>
				<td width="100" align="center">Company</td>
				<td width="250" align="center">Address</td>
				<td width="70" align="center">Affiliation</td>
				<td width="150" align="center">PhoneNumber</td>
				<td width="50" align="center">Detail</td>
			</tr>
			<c:if test="${ empty comSearchList }">
				<tr>
					<td colspan="5"><p align="center">왜 조회가 안되니 데이터가 없잖니</p></td>
				</tr>
			</c:if>
			<c:if test="${ !empty comSearchList }">
				<c:forEach var="search" items="${ comSearchList }">
					<tr>
						<td width="100" align="center">${ search.com_name }</td>
						<td width="250" align="center">${ search.com_add }</td>
						<td width="70" align="center">${ search.com_aff }</td>
						<td width="150" align="center">0${ search.com_phone }</td>
						<td align="center"><input type="submit" value="memberList" onclick="memberList(${ search.com_num })"></td>
				</c:forEach>
			</c:if>
		</table>
		<p>
		<tr>
		<td align="center"><input type="button" value="back" onclick="history.go(-1)"></td>
		</tr>
	</form>

</body>
</html>
