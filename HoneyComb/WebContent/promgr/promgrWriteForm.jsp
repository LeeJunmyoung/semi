<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>promgr write</title>

<script>
	function writeSave() {

		if (document.writeform.promgr_title.value == "") {
			alert("프로젝트 명을 입력하십시요.");
			document.writeform.promgr_title.focus();
			return false;
		}

		if (document.writeform.promgr_content.value == "") {
			alert("프로젝트 내용을 입력하십시요.");
			document.writeform.promgr_content.focus();
			return false;
		}

	}
</script>

</head>
<body>

	<form method="post" name="writeform" action="/HoneyComb/promgr/promgrWritePro.promgr" onsubmit="return writeSave()">
	
		프로젝트 명 <input type="text" name="promgr_title" size="40" maxlength="50" /> <br>
		프로젝트 내용 <textarea name="promgr_content" rows="15" cols="30"></textarea> <br>
		
		<input type="reset" value="reset"> 
		<input type="submit" value="submit">

	</form>
	
</body>
</html>