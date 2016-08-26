<%@ page import="com_bean.HoneyCombDBBean"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회사 검색</title>
<script>
	function in_focus() {
		document.comSearch.com_name.focus();
	}
	
	function comCheck() {
		if (document.comSearch.com_name.value == "") {
			alert("검색할 사업장명을 입력하세요");
			return false;
		}

		return true;
	}
	function send_com_name(conName, com_num) {
		var sendcom = conName;
		var send_num = com_num;
		opener.document.com_search.com_num.value = com_num;
		opener.document.com_search.com_name.value = sendcom;
		window.close();
	}
</script>

<style>
#content {
	position: absolute;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 100;
	filter: alpha(opacity = 50);
	background: #e9ebee;
}

#main {
	background: #fff;
	position: relative;
	height: 100%;
	width: 600px;
	margin: 0 auto;
	text-align: center;
}

.down {
	position: relative;
	top: 30px;
	background: #fff;
}

input[type=text] {
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	font-size: 16px;
	padding-left: 10px;
	text-align: lift;
	width: 220px;
}

table, tr, th, td {
	border-collapse: collapse;
	border: 1px solid #fff;
	cellpadding: 0;
	cellspacing: 0;
	font-size: 14px;
	padding: 8px;
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

#add {
	padding-left: 60px;
	padding-right: 60px;
}

#phone {
	padding-left: 40px;
	padding-right: 40px;
}

.title {
	background: #344d91;
	color: white;
}

p {
	font-size: 15px;
}

.close {
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
	margin: 0 auto;
	text-align: center;
	margin-bottom: 50px;
}

.close:hover {
	background-color: #344d91;
}

.close:active {
	position: relative;
	top: 1px;
}

hr {
	width: 400px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #fff
}

hr : after {
	content: '';
	display: block;
	margin-top: 2px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #fff
}

h3 {
	font-size: 18px;
	font-weight: 700;
}

#com_add {
	text-overflow: ellipsis;
}

#search {
	width: 20px;
	height: 20px;
}

#com_name {
	text-decoration: none;
	color: black;
}

.s {
	position: relative;
	left: 15px;
}
</style>
</head>
<body style="background: #e9ebee;" onload="in_focus()">

	<div id="content">
		<div id="main">


			<div class="down">
				<form name="comSearch" method="post"
					action="/HoneyComb/company/companyCheckPro.company"
					onsubmit="return comCheck()">
					<h3>사업장 검색</h3>
					<hr class="subject">
					<input type="text" name="com_name" placeholder="COMPANY NAME SEARCH" class="s">
					<input type="image" value="찾기" src="view/search.png" id="search" class="s">
					<!-- <table width="300" border="1" cellspacing="0" cellpadding="3"
				align="center"> -->
				</form>
			</div>


			<div class="down">
				<c:if test="${ empty comList }">
					<br>
					<p>검색된 결과가 없습니다</p>
				</c:if>
				<c:if test="${ !empty comList }">
					<br>
					<p>※ 아래 회사명을 클릭하면 자동으로 입력됩니다</p>
					<br>
					<table id="title">
						<tr>
							<td class="title">Company name</td>
							<td class="title" id="add">Address</td>
							<td class="title">Affiliate</td>
							<td class="title" id="phone">Phone</td>
						</tr>
						<c:forEach var="search" items="${ comList }">
							<tbody>
								<tr id="text">
									<td><a
										href="javascript:send_com_name('${search.com_name}','${search.com_num}' )"
										id="com_name"> ${search.com_name} </a></td>
									<td id="com_add">${search.com_add}</td>
									<td>${search.com_aff}</td>
									<td>${search.com_phone}</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</c:if>
				<br> <a href="javascript:this.close();" class="close">닫기</a>
			</div>
		</div>
	</div>


</body>
</html>
