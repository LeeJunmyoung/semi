<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>



<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style type="text/css">
#member_check{
position:relative;
top:30px;
width:370px;
margin: auto;
}
td{
text-align: center;
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
 top:60px;
 
 }

#back_button{
width:50px;
margin: auto;
}
#back_button_div{
width:60px;
margin: auto;
}
tr{
height: 31px;
 }
 td{
 height: 31px;
 }
h1_tag{
width: 230px;
margin: 0px;
}
#member{

 width:200px;
 margin: auto;
}

#no_member{
width:680;
text-align:center;
font-size:20pt;
margin: auto;
}
</style>
</head>





<body>


<div id = 'h1_tag'>
<h1 id='member'>가입자 명단</h1>
</div>
<div id = "member_check">

<c:if test="${!empty temp_member }">


<table border = '1px'>
<tr>
<td style="width: 90px" class="title">이름</td>
					<td style="width: 90px" class="title">부서</td>
					<td style="width: 90px" class="title">직책</td>
					<td class="title" style="width: 90px">
					<input  type="hidden" value="승인" onclick="window.open('/HoneyComb/Option_user/accept_member.option?wait_mem_num=${member.mem_num}&wait_mem_dept_num=${member.com_dept_num}&wait_pos_num=${member.com_pos_num}')">
					<input type="hidden" value="거절" onclick="location.href='#'"></td>
</tr>

<c:forEach var="member" items="${temp_member}">

				<tr id= 'text'>
					<td style="width: 90px">${member.name}</td>
					<td style="width: 90px">${member.com_dept_name}</td>
					<td style="width: 90px">${member.com_pos_name}</td>
					<td style="width: 90px">
					<input  type="button" value="승인" class="btn btn-primary btn-xs" onclick="window.open('/HoneyComb/Option_user/accept_member.option?wait_mem_num=${member.mem_num}&wait_mem_dept_num=${member.com_dept_num}&wait_pos_num=${member.com_pos_num}')">
					<input  type="button" value="거절" class="btn btn-primary btn-xs" onclick="location.href='#'"></td>
				</tr>


			</c:forEach>
</table>
</c:if>
<c:if test="${empty temp_member }">

<p id = 'no_member'>승인대기자가 없습니다 </p>

</c:if>


</div>
<div id ="back_button_div">

<input type="button" class="btn btn-primary btn-xs" value="back" id='back_button' onclick="location.href='/HoneyComb/page_layout/Option/Option_home.jsp'">
</div>
</body>
</html>