<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 페이지</title>
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
	background: #e9ebee;
	position: relative;
	top: 150px;
	height: 60%;
	width: 200px;
	margin: 0 auto;
}

#admin {
	margin: 0 auto;
	width: 300px;
	height: 600;
}

#admin_name{
font-size: 37px;
}

hr{
width:300px;
border-top:1px solid #bbb;
border-bottom:1px solid #bbb;
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
   width: 200px;
}

.myButton:hover {
   background-color: #344d91;
}

.myButton:active {
   position: relative;
   top: 1px;
}
</style>

<script>
	function logout() {

		var out = confirm("정말 로그아웃 하시겠습니까?");

		if (out) {
			location.href = "/HoneyComb/Option_user/logout_page.jsp";
		} else {
			return false;
		}
	}
</script>

</head>
<body>

	<div id="content">
		<div id="main">

			<div id="admin">
				<center>
				<h1 id=admin_name>Admin Page</h1>
				<hr>
					<p>
						<tr>
							<td><a
								href="javascript:window.location='/HoneyComb/memCheck/memCheck_Main.mc'"
								class="myButton">Present Condition</a></td>
						</tr>
					<p>
						<tr>
							<td><a
								href="javascript:window.location='/HoneyComb/complete/complete_com.admin'"
								class="myButton">Company Approval</a></td>
						</tr>
					<p>
						<tr>
							<td><a
								href="javascript:window.location='/HoneyComb/admin/complete/complete_comNotice.jsp'"
								class="myButton">Notice</a></td>
						</tr>
					<p>
						<tr>
							<td><a onclick="logout();return false;"
								onkeypress="this.onclick;" class="myButton">Log Out</a></td>
						</tr>
				</center>
			</div>
		</div>
	</div>
</body>
</html>