<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>회사 찾기 폼</title>
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

		window.open(
						url, "post",
						"toolbar=no,width=500,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
</script>
</head>
<body bgcolor="<%=bodyback_c%>">

	<table>
	
			<form name="com_search" onSubmit="return searchCheck()" method="post" action="Company_Temp_Join.company">
				<!-- onSubmit="return searchCheck()" -->
				<h3>회사 찾기</h3>
				<p>
					사업장명 <input type="text" name="com_name" readonly>
					<input type="button" value="찾기" onClick="companyCheck();"><br>
					<input type="hidden" name="com_num" />
					부서
					<select name="com_dept_num">
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
					</select><br>
					직급 <select name="com_pos_name">
						<option value="선택하세요">선택하세요</option>
						<option value="사원">사원</option>
						<option value="대리">대리</option>
						<option value="팀장">팀장</option>
						<option value="부장">부장</option>
						<option value="과장">과장</option>
					</select><br><br>
					<input type="submit" value="등록하기">
			</form>
	</table>

</body>
</html>
