<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../complete/view/color.jsp"%>
<html>
<head>
<title>현황 확인 폼(가입인원 체크)</title>

<style>
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}

article, aside, details, figcaption, figure, footer, header, hgroup,
	menu, nav, section {
	display: block;
}

body {
	line-height: 1;
}

ol, ul {
	list-style: none;
}

blockquote, q {
	quotes: none;
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

input[type=text] {
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	font-size: 16px;
	padding-left: 10px;
	text-align: lift;
}

.myButton {
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	display: inline-block;
	cursor: pointer;
	color: #fff;
	font-size: 15px;
	padding: 8px 25px;
	text-decoration: none;
	margin: 20px;
}

.myButton:hover {
	background-color: #344d91;
}

.myButton:active {
	position: relative;
	top: 1px;
}

hr {
	width: 400px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #bbb;
}

#memCheck_name {
	font-size: 37px;
}

table, tr, th, td {
	border-collapse: collapse;
	border: 1px solid #ffffff; cellpadding =0; cellspacing =0;
	font-size: 14px;
	padding: 8px;
	margin: 0 auto;
}

#memCheck_title th {
	color: white;
	font-size: 16px; letter-spacing : 1.5px;
	font-weight: bold;
	padding: 10px;
	text-align: center;
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
						<tr colspan="5"><p align="center">왜 조회가 안되니 데이터가 없잖니</p></td>
					</tr>
				</c:if>
			<table border="1" id="memCheck_title"cellpadding="1" cellspacing="0" align="center">
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
