<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 공지작성 폼</title>

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
	z-index: 5;
	
}

#logo_wrapper {
	position: absolute;
	left: 250px;
	z-index: 5;
}

#logo_banner {
	display: inline;
	margin: auto;
	width: 100px;
	height: 100px;
	z-index: 5;
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
	width: 100px;
}

.myButton:hover {
	background-color: #344d91;
}

.myButton:active {
	position: relative;
	top: 1px;
}


#admin_notice_div{
position: absolute;
width:70%;
background:#fff;
height:100%;
top:11%;
left:250px;
z-index: 2;

}
body{
background-color: #e9ebee;
z-index: 1;
}

#notice_h{
position:relative;
top:150px;
width: 200px;
height:100px;
margin: auto;

}

#form_div{
position:relative;
top:150px;
width: 700px;
height:800px;
margin: auto;

}
.form-group input{
width: 700px

}
.form-group textarea{
width:700px;

}
</style>


<script>
	function writeSave() {

		if (document.writeform.notice_title.value == "") {
			alert("제목을 입력하십시요.");
			document.writeform.notice_title.focus();
			return false;
		}

		if (document.writeform.notice_content.value == "") {
			alert("내용을 입력하십시요.");
			document.writeform.notice_content.focus();
			return false;
		}
	}
</script>

</head>
<body >

<div id="home_banner">
		<div id="logo_wrapper">
			<img id="logo_banner" src="/HoneyComb/page_layout/page_image/logo.png" width="100"
				height="100" onclick="location.href='/HoneyComb/index.jsp'"> <a
				id="logo_a" href="/HoneyComb/index.jsp"><p id="Honey_comB">HoneyComb</p></a>
		</div>
	</div>


<div id='admin_notice_div'>
<div id='notice_h'>
<h1>팝업창 작성</h1>
</div>
<div id ='form_div'>
	<form class="col-sm-10" role="form" method="post" name="writeform"
		action="/HoneyComb/complete/complete_comNotice_admin.admin"
		onsubmit="return writeSave()">

		<div class="form-group">
			<label for="notice_admin_title">공지제목:</label> <input type="text"
				class="form-control" id="notice_admin_title"
				name="notice_admin_title">
		</div>
		<div class="form-group">
			<label for="notice_admin_content">공지내용:</label>
			<textarea class="form-control" rows="5" id="notice_admin_content"
				name="notice_admin_content"></textarea>
		</div>
		<input type="submit" class="btn btn-primary btn-xs" value="공지작성">
		<input type="button" class="btn btn-primary btn-xs" value="back"
			onclick="history.go(-1)">
	</form>
</div>
</div>	
	
</body>
</html>