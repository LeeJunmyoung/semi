<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="/HoneyComb/view/script.js"></script>
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
<style type="text/css">
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
	color: white;
}

#home_banner {
	width: 100%;
	height: 11%;
	background: #344d91;
	margin: 0;
	padding: 0;
}

#logo_wrapper {
	position: absolute;
	left: 250px;
	z-index: 3;
}

#logo_banner {
	display: inline;
	margin: auto;
	width: 100px;
	height: 100px;
}

#Honey_comB {
	display: inline;
	font-size: 38pt;
	color: #fff;
	vertical-align: middle;
}

#logo_a {
	text-decoration: none;
}

.container {
	position: absolute;
	left: 250px;
	padding: 0;
}

#col-md-12 {
	padding: 0;
}

hr {
	width: 500px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #bbb;
}

body {
	background: #e9ebee;
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
.cover{
background: white;
}
#admin{
width: 100%;
}
</style>

</head>
<body>
	<div id="home_banner">
		<div id="logo_wrapper">
			<img id="logo_banner" src="/HoneyComb/page_layout/page_image/logo.png" width="100"
				height="100" onclick="location.href='/HoneyComb/index.jsp'"> <a
				id="logo_a" href="/HoneyComb/index.jsp"><p id="Honey_comB">HoneyComb</p></a>
		</div>
	</div>
	<div class="container" style="height: 89%; width: 70%;">
		<div class="cover">
			<div class="navbar navbar-default"></div>

			<div class="container" style="width: 70%;">
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


			</div>
</body>
</html>