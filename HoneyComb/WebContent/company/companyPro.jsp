<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>사업장 등록 완료</title>
<script type="text/javascript">
	function tomain() {
		location.href="/HoneyComb/temp_accept_page/wait_accept_company.jsp"
	}
</script>

<!-- css 초기화 START -->
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
</style>
<!-- css 초기화 END -->

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
	top: 100px;
	height: 80%;
	width: 450px;
	margin: 0 auto;
	border-radius: 10px 10px 10px 10px;
}

#text {
	position: relative;
	top: 20px;
	text-align: center;
}

h1 {
	font-size: 20px;
}

h2 {
	font-size: 15px;
}

#line_one {
	height: 1px;
	background: #bbb;
	width: 350px;
	background-image: -webkit-linear-gradient(left, #eee #777, #eee);
	background-image: -moz-linear-gradient(left, #eee #777, #eee);
	background-image: -ms-linear-gradient(left, #eee #777, #eee);
	background-image: -o-linear-gradient(left, #eee #777, #eee);
}

#line_two {
	width: 400px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #fff;
	width: 100px;
}

#compl_view {
	position: relative;

	text-align: center;
	top: 50px;
	margin: 0 auto;
	width: 400px;
	height: 300px;
}

p {
	top: 70px;
	position: relative;
	text-align: center;
	font-size: 5px;
}

#title {
	table-layout: fixed;
	position: relative;
	margin: 0 auto;
}

table {
position:relative;
top:30px;
	text-align: center;
	margin: 0 auto;
	
}

#table th {
	background: #344d91;
	color: white;
	font-size: 16px;
	letter-spacing: 1.5px;
	font-weight: bold;
	padding: 10px;
	text-align: center;
	color: white;
}
#table tr{
height: 40px;
border: 3px solid white;
}
#table tr td{
height: 40px;
border-right: 5px solid white;
}



.a {
	background: #344d91;
	color: #fff;
	text-align:center;
	vertical-align:middle;
	width: 120px;
	padding: 2px;
}

.b {
	background: #e9ebee;
	text-align:center;
	vertical-align:middle;
	color:black;
	width: 270px;
	padding:2px;
}
</style>
</head>
<body onLoad="setTimeout('tomain()',3000)">
	<!-- onLoad="setTimeout('tomain()',5000)" -->

	<div id="content">
		<div id="main">
			<form>
				<div id="text">
					<h1>사업장 등록 완료</h1>
					<hr id="line_one">
					<h2>Completed Successfully</h2>
				</div>


				<div id="compl_view">
					<h3>신청 정보</h3>
					<hr id="line_two">
					<table align="center" border="1" cellpadding="0" cellspacing="0" id="table">
						<tr>
							<td class="a">Company name</td>
							<%-- ${com_name} --%>
							<td class="b"> ${com_name}</td>
						</tr>
						
						<tr>
							<td class="a">Address</td>
								<td class="b">${com_add} </td>
							<%-- ${com_add} --%>
						</tr>
						
						<tr>
							<td class="a">Phone number</td>
							<%-- ${com_phone} --%>
							
							<td class="b">${com_phone}</td>
						</tr>
					
						<tr>
							<td class="a">Affiliate</td>
							<%-- ${com_aff} --%>
							<td class="b">${com_aff}</td>
						</tr>
					
					</table>
				</div>
			</form>
			<p>3초후 사업장 등록 페이지로 이동합니다.</p>
		</div>
	</div>


</body>
</html>
