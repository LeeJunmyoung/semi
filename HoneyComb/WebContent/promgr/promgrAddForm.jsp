<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>promgr write</title>

<script>
	function writeSave() {

		if (document.promgrAddform.promgr_title.value == "") {
			alert("프로젝트 명을 입력하십시요.");
			document.promgrAddform.promgr_title.focus();
			return false;
		}

		if (document.promgrAddform.promgr_content.value == "") {
			alert("프로젝트 내용을 입력하십시요.");
			document.promgrAddform.promgr_content.focus();
			return false;
		}
		
		return true;

	}
</script>

</head>
<body>

	<form method="post" name="promgrAddform" action="/HoneyComb/promgr/promgrAddPro.promgr" onsubmit="return writeSave()">
	
		<input type="text" name="promgr_title" size="40" maxlength="50" placeholder="project name" /> <br>
		<textarea name="promgr_content" rows="15" cols="30" placeholder="project described"></textarea> <br>
		
		<input type="submit" value="Add Project"/>

	</form>
	
</body>
</html>