<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>사업장 등록 폼</title>
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
</head>
<body bgcolor="<%=bodyback_c%>">

	<center>
		<form  name="com_regi" action="/HoneyComb/company/companyPro.company" onSubmit="return inputCheck()">
			<h3>사업장 등록</h3>
			<p>
				사업장명 <input type="text" name="com_name" size="10"><br>
				주소 <input type="text" name="com_add" size="30"><br>
				전화번호 <input type="text" name="com_phone1" size="3" maxlength="3"> - <input
					type="text" name="com_phone2" size="4" maxlength="4"> - <input
					type="text" name="com_phone3" size="4" maxlength="4"><br> 
			   <br>
			   계열 <select name="com_aff">
					<option value="선택하세요">선택하세요</option>
					<option value="Sample1">Sample1</option>
					<option value="Sample2">Sample2</option>
					<option value="Sample3">Sample3</option>
					<option value="Sample4">Sample4</option>
					<option value="Sample5">Sample5</option>
					<option value="Sample6">Sample6</option>
					<option value="Sample7">Sample7</option>
				 </select>
				<br><br> 
				<input type="submit" value="등록하기"/>
		</form>
	</center>

</body>
</html>
