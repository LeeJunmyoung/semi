<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>promgr write</title>

<script>
	function writeSave() {

		if (document.commentAddform.promgr_content.value == "") {
			alert("내용을 입력하십시요.");
			document.commentAddform.promgr_content.focus();
			return false;
		}
		
		return true;

	}
</script>

</head>
<body>

	<form method="post" name="commentAddform" 
		action="/HoneyComb/promgr/PromgrCommentAddPro.promgr?promgr_num=${promgr_num}"
		onsubmit="return writeSave()">
	
		<textarea name="promgr_comment" rows="15" cols="30" placeholder="comment"></textarea> <br>
		
		<input type="submit" value="Add Comment"/>

	</form>
	
</body>
</html>