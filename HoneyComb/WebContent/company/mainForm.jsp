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
			alert("사업장을 선택해주세요");
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

		url = "/HoneyComb/company/companyCheck.jsp";

		window
				.open(
						url,
						"post",
						"toolbar=no, left=200, top=100, width=700, height=400, directories=no, status=yes, scrollbar=yes, menubar=no");
	}
</script>
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<script>
	$(document).ready(function() {
		$("#one").click(function() {
/* 			$("#one").css("background", "#fff");
			$("#one").css("color", "black");
			$("#two").css("background", "#344d91");
			$("#two").css("color", "white"); */
			$("#company_form").css("display", "block");
			$("#company_find_form").css("display", "none");
		});
		$("#one").mouseenter(function() {
			$("#one").css("background", "#fff");
			$("#one").css("color", "black");
		});
		$("#one").mouseleave(function() {
			$("#one").css("background", "#344d91");
			$("#one").css("color", "#fff");
		});
		
		
		$("#two").mouseenter(function() {
			$("#two").css("background", "#fff");
			$("#two").css("color", "black");
		});
		
		$("#two").mouseleave(function() {
			$("#two").css("background", "#344d91");
			$("#two").css("color", "#fff");
		});
		$("#two").click(function() {
			/* $("#one").css("background", "#344d91");
			$("#one").css("color", "white");
			$("#two").css("background", "#fff");
			$("#two").css("color", "black"); */
			$("#company_form").css("display", "none");
			$("#company_find_form").css("display", "block");
		});
	});
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
/* 4367b0 */
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
	border-right: 0.5px solid;
	border-top-left-radius: 10px;
	background: #344d91;
	color: white;
}

#menu>label#two {
	border-left: 0.5px solid;
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
}

.submit:hover {
	background-color: #344d91;
}

.submit:active {
	position: relative;
	top: 1px;
}

input[type=text] {
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	font-size: 16px;
	padding-left: 10px;
	text-align: lift;
}

.cname {
	width: 340px;
	margin: 10px;
}

.cadd {
	width: 340px;
	margin: 10px;
}

.cphone {
	width: 70px;
	margin-top: 10px;
}

select {
	width: 120px;
	height: 30px;
	padding-left: 5px;
	border-radius: 5px 5px 5px 5px;
	margin: 10px;
	font-size: 16px;
}

hr {
	width: 400px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #fff;
}

hr : after {
	content: '';
	display: block;
	margin-top: 3px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #fff;
}

h3 {
	font-size: 18px;
	font-weight: 700;
}

.subject {

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
						<h3>사업장 등록</h3>
						<hr class="subject">
						<input type="text" placeholder="COMPANY NAME" name="com_name"
							class="cname" size="10"><br> <input type="text"
							placeholder="ADDRESS" name="com_add" class="cadd" size="30"><br>
						PHONE <input type="text" name="com_phone1" size="3" class="cphone"
							maxlength="3"> - <input type="text" name="com_phone2"
							size="4" class="cphone" maxlength="4"> - <input
							type="text" name="com_phone3" size="4" class="cphone"
							maxlength="4"><br> <br> AFFILIATE<select
							name="com_aff">
							<option value="선택하세요">선택하세요</option>
							<option value="IT">IT</option>
							<option value="Design">Design</option>
							<option value="Logistics">Logistics</option>
							<option value="Fashion">Fashion</option>
							<option value="Food">Food</option>
							<option value="Accountant">Accountant</option>
							<option value="Cosmetics">Cosmetics</option>
							<option value="etc">etc</option>
						</select>
						<hr>
						<br> <br> <a href="javascript:com_regi.submit();"
							onclick="return inputCheck()" class="submit">등록완료</a>
						<!-- <input type="submit" value="등록하기" /> -->
					</form>
				</div>


				<div id="company_find_form">
					<form name="com_search" method="post"
						action="/HoneyComb/company/Company_Temp_Join.company">
						<!-- onSubmit="return searchCheck()" -->
						<h3>내 회사 등록</h3>
						<hr class="subject">
						<input type="text" placeholder="COMPANY NAME SEARCH" name="com_name"
							class="cname" readonly> <img src="/HoneyComb/company/view/search.png"
							id="search" value="찾기" onClick="companyCheck();"><br>
						<input type="hidden" name="com_num" />DEPARTMENT<select
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
						</select><br>POSITION<select name="com_pos_name">
							<option value="선택하세요">선택하세요</option>
							<option value="사원">사원</option>
							<option value="대리">대리</option>
							<option value="팀장">팀장</option>
							<option value="부장">부장</option>
							<option value="과장">과장</option>
						</select>
						<hr>
						<br> <br> <a href="javascript:com_search.submit();"
							onclick="return searchCheck()" class="submit">등록완료</a>
					</form>
				</div>
			</div>

		</div>
	</div>


</body>
</html>
