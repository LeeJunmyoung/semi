<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../complete/view/color.jsp"%>
<html>
<head>
<title>현황 확인 폼(가입인원 체크)</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<style type="text/css">
input[type=text] {
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	font-size: 16px;
	padding-left: 10px;
	text-align: lift;
}

#member_check {
	position: relative;
	top: 30px;
	width: -50px;
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
	top: 40px;
	width: 50px;
	margin: 0 auto;
	margin-bottom: 50px;
}

#back_button_div {
	width: 60px;
	margin: auto;
}

tr {
	width: 100px;
	height: 31px;
}

td {
	width: 100px;
	height: 31px;
}

#h1_tag {
	width: 500px;
	margin: auto;
	font-size: 40px;
	text-align: center;
}

h1 {
	width: 500px;
	margin: auto;
	text-align: center;
}

#no_member {
	width: 680;
	text-align: center;
	font-size: 20pt;
	margin: auto;
}

#memCheck_table {
	width: 800px;
	text-align: center;
	margin: auto;
}

input[type=text] {
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	font-size: 16px;
	padding-left: 10px;
	text-align: lift;
}
</style>



<script type='text/javascript'>
	function filter(){
		
		
		if($('#com_name_search').val()==""){
			$("#memCheck_table tr").css('display','');			
			$("#visible_tr").css('display','');
		}
		else{
			
			$("#memCheck_table tr").css('display','none');
			$("#memCheck_table tr[name*='"+$('#com_name_search').val()+"']").css('display','');
			$("#visible_tr").css('display','');		
		}
		return false;
	}
</script>


<script>

function in_focus(){
	document.join_company.com_name_search.focus();
}

	
	function memberList(com_num) {

		url = "memCheck_MemberList.mc?com_num=" + com_num;
		window.open(url, "post", "toolbar=no,width=1000,height=400,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
</script>
</head>
<body onload="in_focus()">
	<div id='h1_tag'>
		<br> Present Condition
		<hr>
	</div>
	<div id="member_check">
		<form name="join_company" align="center" method="post"
			action="/HoneyComb/memCheck/memCheck_ComSearch.mc">
			<input type="text" placeholder="COMPANY" id="com_name_search"
				onkeyup='{filter();return false}'
				onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}'>
			<p>
				<br>
				<br>
				<c:if test="${ empty companyList }">
					<tr>
					<tr colspan="5">
						<p id='no_member'>회사가 없습니다.</p>
					</tr>
				</c:if>
			<table border='1px' id="memCheck_table">
				<c:if test="${ !empty companyList }">
					<tr id='visible_tr'>
						<td width="100" class="title" align="center">Company</td>
						<td width="250" class="title" align="center">Address</td>
						<td width="70" class="title" align="center">Affiliation</td>
						<td width="150" class="title" align="center">PhoneNumber</td>
						<td width="70" class="title" align="center">Detail</td>
					</tr>
					<c:forEach var="com" items="${ companyList }">
						<tr id="text" name="${ com.com_name }">
							<td width="100" align="center">${ com.com_name }</td>
							<td width="250" align="center">${ com.com_add }</td>
							<td width="70" align="center">${ com.com_aff }</td>
							<td width="150" align="center">0${ com.com_phone }</td>
							<td><input type="button" class="btn btn-primary btn-xs"
								value="memberList" onclick="memberList(${ com.com_num })"></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<div id="back_button_div">

				<input type="button" class="btn btn-primary btn-xs" value="back"
					id='back_button' onclick="history.go(-1)">
			</div>
		</form>
	</div>
</body>
</html>
