<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../complete/view/color.jsp"%>
<html>
<head>
<title>현황 확인 폼(가입인원 체크)</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style type="text/css">
#member_check {
	position: relative;
	top: 30px;
	width: 370px;
	margin: auto;
}

td {
	text-align: center;
}

form {
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

#title_option tr {
	height: 31px;
}

td {
	vertical-align: middle;
}

#back_button {
	position: relative;
	top: 60px;
}

#back_button {
	width: 50px;
	margin: auto;
}

#back_button_div {
	width: 60px;
	margin: auto;
}

tr {
	height: 31px;
}

td {
	height: 31px;
}

h1_tag {
	width: 230px;
	margin: 0px;
}

h1 {
	width: 200px;
	margin: auto;
}

#no_member {
	width: 680;
	text-align: center;
	font-size: 20pt;
	margin: auto;
}
</style>


<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<script type='text/javascript'>
	function filter(){
		if($('#com_name').val()=="")
			$("#modify tr").css('display','');			
		else{
			$("#modify tr").css('display','none');
			$("#modify tr[name*='"+$('#com_name').val()+"']").css('display','');
		}
		return false;
	}
</script>


<script>

function in_focus(){
	document.join_company.com_name.focus();
}

	function searchClick() {
		if(!document.join_company.com_name.value) {
			alert("조회할 사업장명을 입력해주세요!");
			return false;
		}
		
		return true;
	}
	
	function memberList(com_num) {

		url = "memCheck_MemberList.mc?com_num=" + com_num;
		window.open(url, "post", "toolbar=no,width=1000,height=400,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
</script>
</head>
<body bgcolor="#e9ebee" onload="in_focus()">
	<div id="admin">
		<form name="join_company" align="center" method="post"
			action="/HoneyComb/memCheck/memCheck_ComSearch.mc">
			<h1 id="memCheck_name">Present Condition</h1>
			<hr>
			<input type="text" placeholder="Company" id="com_name"
				onkeyup='{filter();return false}'
				onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}'>
			<p>
				<c:if test="${ empty companyList }">
					<tr>
					<tr colspan="5">
						<p align="center">왜 조회가 안되니 데이터가 없잖니</p>
						</td>
					</tr>
				</c:if>
			<table border="1" id="memCheck_title" cellpadding="1" cellspacing="0"
				align="center">
				<c:if test="${ !empty companyList }">
					<tr>
						<td width="100" align="center">Company</td>
						<td width="250" align="center">Address</td>
						<td width="70" align="center">Affiliation</td>
						<td width="150" align="center">PhoneNumber</td>
						<td width="70" align="center">Detail</td>
					</tr>
					<c:forEach var="com" items="${ companyList }">

						<tbody id="modify">

							<tr id="check_com" name="${ com.com_name }">
								<td width="100" align="center">${ com.com_name }</td>
								<td width="250" align="center">${ com.com_add }</td>
								<td width="70" align="center">${ com.com_aff }</td>
								<td width="150" align="center">0${ com.com_phone }</td>
								<td><input type="button" value="memberList"
									onclick="memberList(${ com.com_num })"></td>
							</tr>
						</tbody>
					</c:forEach>
				</c:if>
			</table>
			<tr>
				<td align="center"><a onclick="history.go(-1)" class="myButton">back</a></td>
			</tr>
		</form>
	</div>
</body>
</html>
