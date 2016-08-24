<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>현재원</title>


<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>

#member_check{
width:  680px;
}
form{

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

#text:nth-child(odd) {
	background-color: #e9ebee;
	color: black;
}

#text:hover {
	background-color: #A4A4A4;
	color: black;
}

#title_option tr{
height: 31px;

}
td{
vertical-align: middle;
}
 #back_button{
 position: relative;
 top:30px;
 
 }
</style>


</head>
<body bgcolor="<%=bodyback_c%>">
<div id = "member_check">
		<form name="memberCheck" align="center">
			<h3 align="center">회사원</h3>
			<table align="center" border="1" cellpadding="1" cellspacing="0"  id="title_option">
				<c:if test="${ !empty memberlist }">
			<tr>
				<td  class="title" width="80">부서</td>
				<td  class="title" width="80">직급</td>
				<td  class="title" width="70">이름</td>
				<td  class="title" width="200">전화번호</td>
				<td  class="title" width="250">이메일</td>
			</tr>
					<c:forEach var="member" items="${memberlist}">
				<tr id="text">
				<td>${member.com_dept_name}</td>
				<td>${member.com_pos_name}</td>
				<td>${member.name}</td>
				<td>${member.phone_num}</td>
				<td>${member.email}</td>
				</tr>
				</c:forEach>
				</c:if>
				
			<c:if test="${ empty memberlist }">
					<tr>
						<td colspan="5" align="center">회사원이 없습니다</td>
					</tr>
				</c:if>
			
			</table>
			<p>
			<input type="button" value="back"  class="btn btn-primary btn-xs" id ='back_button' align="center" onclick="history.go(-1)">
	</form>
</div>
</body>
</html>