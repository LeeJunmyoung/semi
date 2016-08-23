<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function inputCheck() {

		if (!document.com_regi.com_name.value) {
			alert("사업장명을 입력하세요");
			return false;
		}

		if (!document.com_regi.com_add.value) {
			alert("주소를 입력하세요");
			return false;
		}

		if (!document.com_regi.com_phone1.value) {
			alert("전화번호를 입력하세요");
			return false;
		}

		if (!document.com_regi.com_phone2.value) {
			alert("전화번호를 입력하세요");
			return false;
		}

		if (!document.com_regi.com_phone3.value) {
			alert("전화번호를 입력하세요");
			return false;
		}

		if (document.com_regi.com_aff.value == "선택하세요") {
			alert("계열을 선택하세요");
			return false;
		}

		return true;

	}
</script>
<script>
	function searchCheck() {

		if (!document.com_search.com_name.value) {
			alert("사업장명을 입력하세요");
			return false;
		}

		if (document.com_search.com_dept_num.value == "-1") {
			alert("부서를 입력하세요");
			return false;
		}

		if (document.com_search.com_pos_name.value == "선택하세요") {
			alert("직급을 입력하세요");
			return false;
		}

		return true;

	}

	function companyCheck() {

		url = "companyCheck.jsp";

		window
				.open(
						url,
						"post",
						"toolbar=no,width=500,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
</script>
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<script>
	$(document).ready(function() {
		$("#one").click(function() {
			$("#one").css("background", "#fff");
			$("#one").css("color", "black");
			$("#two").css("background", "#344d91");
			$("#two").css("color", "white");
			$("#company_form").css("display", "block");
			$("#company_find_form").css("display", "none");
		});
		$("#two").click(function() {
			$("#one").css("background", "#344d91");
			$("#one").css("color", "white");
			$("#two").css("background", "#fff");
			$("#two").css("color", "black");
			$("#company_form").css("display", "none");
			$("#company_find_form").css("display", "block");
		});
	});
</script>
<!-- $("#one").css("border-bottom", "none");
$("#two").css("border-bottom", "1px solid");
$("#one").css("border-bottom", "1px solid");
$("#two").css("border-bottom", "none"); -->
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
	background: #e9ebee;
	position: relative;
	top: 100px;
	height: 80%;
	width: 450px;
	margin: 0 auto;
}

#menu {
	display: block;
	height: 30px;
	width: 100%;
	z-index: -99;
}

input[type=radio].ch {
	display: none;
}

#menu>label {
	/* 수평 정렬 */
	display: block;
	float: left;
	/* 크기 및 글자 위치 지정*/
	width: 225px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	/* 테두리 지정 */
	box-sizing: border-box;
	border: 1px solid;
}

#menu>label[for=menu_one]:HOVER, #menu>label[for=menu_two]:HOVER {
	background: #fff;
	color: black;
}

#menu>label#one {
	border-right: none;
	border-top-left-radius: 10px;
	background: #fff;
	color: black;
}

#menu>label#two {
	border-left: none;
	border-top-right-radius: 10px;
	background: #344d91;
	color: white;
}

#company_form {
	display: block;
	position: absolute;
	top: 70px;
	width: 100%;
	margin: 0 auto;
	text-align: center;
}

#company_find_form {
	display: none;
	position: absolute;
	top: 70px;
	width: 100%;
	margin: 0 auto;
	text-align: center;
}

#company_contents {
	background: #fff;
	margin: 0 auto;
	display: block;
	z-index: 3;
	width: 100%;
	height: 90%;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
}

#search {
	width: 20px;
	height: 20px;
}

.submit {
	-moz-box-shadow: inset 0px 0px 0px 0px #54a3f7;
	-webkit-box-shadow: inset 0px 0px 0px 0px #54a3f7;
	box-shadow: inset 0px 0px 0px 0px #54a3f7;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #007dc1
		), color-stop(1, #0061a7));
	background: -moz-linear-gradient(top, #007dc1 5%, #0061a7 100%);
	background: -webkit-linear-gradient(top, #007dc1 5%, #0061a7 100%);
	background: -o-linear-gradient(top, #007dc1 5%, #0061a7 100%);
	background: -ms-linear-gradient(top, #007dc1 5%, #0061a7 100%);
	background: linear-gradient(to bottom, #007dc1 5%, #0061a7 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#007dc1',
		endColorstr='#0061a7', GradientType=0);
	background-color: #007dc1;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
	border: 2px solid #124d77;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 13px;
	padding: 6px 22px;
	text-decoration: none;
	text-shadow: 0px 1px 0px #154682;
}

.submit:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #0061a7
		), color-stop(1, #007dc1));
	background: -moz-linear-gradient(top, #0061a7 5%, #007dc1 100%);
	background: -webkit-linear-gradient(top, #0061a7 5%, #007dc1 100%);
	background: -o-linear-gradient(top, #0061a7 5%, #007dc1 100%);
	background: -ms-linear-gradient(top, #0061a7 5%, #007dc1 100%);
	background: linear-gradient(to bottom, #0061a7 5%, #007dc1 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0061a7',
		endColorstr='#007dc1', GradientType=0);
	background-color: #0061a7;
}

.submit:active {
	position: relative;
	top: 1px;
}

input[type=text] {
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	font-size: 16px;
	text-align: center;
}

.cname {
	width: 200px;
	margin: 10px;
}

.cadd {
	width: 300px;
	margin: 10px;
}

.cphone {
	width: 70px;
	margin-top: 10px;
}

select {
	width: 120px;
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	margin: 10px;
	font-size: 16px;
}
</style>
</head>
<body>

	<div id="content">
		<div id="main">


			<div id="menu">
				<input type="radio" id="menu_one" value="사업장 등록" class="ch">
				<input type="radio" id="menu_two" value="내 회사 등록" class="ch">
				<label for="menu_one" id="one">사업장 등록</label> <label for="menu_two"
					id="two">내 회사 등록</label>
			</div>


			<div id="company_contents">
				<div id="company_form">
					<form name="com_regi"
						action="/HoneyComb/company/companyPro.company">
						<input type="text" placeholder=" company name" name="com_name"
							class="cname" size="10"><br> <input type="text"
							placeholder="address" name="com_add" class="cadd" size="30"><br>
						전화번호 <input type="text" name="com_phone1" size="3" class="cphone"
							maxlength="3"> - <input type="text" name="com_phone2"
							size="4" class="cphone" maxlength="4"> - <input
							type="text" name="com_phone3" size="4" class="cphone"
							maxlength="4"><br> <br> 회사 계열<select
							name="com_aff">
							<option value="선택하세요">선택하세요</option>
							<option value="Sample1">Sample1</option>
							<option value="Sample2">Sample2</option>
							<option value="Sample3">Sample3</option>
							<option value="Sample4">Sample4</option>
							<option value="Sample5">Sample5</option>
							<option value="Sample6">Sample6</option>
							<option value="Sample7">Sample7</option>
						</select> <br> <br> <a href="javascript:com_regi.submit();"
							onclick="return inputCheck()" class="submit">등록완료</a>
						<!-- <input type="submit" value="등록하기" /> -->
					</form>
				</div>


				<div id="company_find_form">
					<form name="com_search" method="post"
						action="Company_Temp_Join.company">
						<!-- onSubmit="return searchCheck()" -->
						<input type="text" placeholder="company name" name="com_name"
							class="cname" readonly> <img src="view/search.png"
							id="search" value="찾기" onClick="companyCheck();"><br>
						<input type="hidden" name="com_num" /> 부서<select
							name="com_dept_num">
							<option value="-1">선택하세요</option>
							<option value="0">총무</option>
							<option value="1">경리(회계)</option>
							<option value="2">경영</option>
							<option value="3">인사</option>
							<option value="4">재경</option>
							<option value="5">고객만족</option>
							<option value="6">구매</option>
							<option value="7">관리</option>
							<option value="8">기술지원</option>
							<option value="9">기획</option>
							<option value="10">비서</option>
							<option value="11">생산</option>
							<option value="12">etc</option>
						</select><br> 직급<select name="com_pos_name">
							<option value="선택하세요">선택하세요</option>
							<option value="사원">사원</option>
							<option value="대리">대리</option>
							<option value="팀장">팀장</option>
							<option value="부장">부장</option>
							<option value="과장">과장</option>
						</select><br> <br> <a href="javascript:com_search.submit();"
							onclick="return searchCheck()" class="submit">등록완료</a>
						<!-- <input type="submit" value="등록하기"> -->
					</form>
				</div>
			</div>

		</div>
	</div>


</body>
</html>
