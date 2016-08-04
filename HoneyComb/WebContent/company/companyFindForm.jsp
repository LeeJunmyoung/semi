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

		if (document.com_search.com_dept_name.value == "선택하세요") {
			alert("부서를 입력하세요");
			return false;
		}

		if (document.com_search.com_pos_name.value == "선택하세요") {
			alert("직책을 입력하세요");
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
					<select name="com_dept_name">
						<option value="선택하세요">선택하세요</option>
						<option value="총무">총무</option>
						<option value="경리(회계)">경리(회계)</option>
						<option value="경영지원">경영지원</option>
						<option value="인사">인사</option>
						<option value="재경">재경</option>
						<option value="고객만족">고객만족</option>
						<option value="구매">구매</option>
						<option value="관리">관리</option>
						<option value="기술지원">기술지원</option>
						<option value="기획">기획</option>
						<option value="연구기획">연구기획</option>
						<option value="비서">비서</option>
						<option value="생산관리">생산관리</option>
						<option value="등등듣">등등듣</option>
						<option value="멀랄">멀랄</option>
					</select><br>
					직급 <select name="com_pos_name">
						<option value="선택하세요">선택하세요</option>
						<option value="사원">사원</option>
						<option value="선임">선임</option>
						<option value="책임">책임</option>
						<option value="수석">수석</option>
						<option value="이사">이사</option>
						<option value="상무">상무</option>
						<option value="전무">전무</option>
						<option value="대표">대표</option>
					</select><br><br>
					<input type="submit" value="등록하기">
			</form>
		
	</table>

</body>
</html>
