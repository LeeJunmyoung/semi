<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>promgr write</title>

<script>
	function writeSave() {

		if (document.commentModform.promgr_content.value == "") {
			alert("내용을 입력하십시요.");
			document.commentAddform.promgr_content.focus();
			return false;
		}
		
		return true;

	}
</script>

</head>
<body>

	<form method="post" name="commentModform" 
		action="/HoneyComb/promgr/PromgrCommentModPro.promgr?comment_num=${comment_num}"
		onsubmit="return writeSave()">
	
		<textarea name="promgr_comment" rows="15" cols="30" placeholder="comment"></textarea> <br>
		
		<input type="submit" value="Mod Comment"/>

	</form>
	
</body>
</html>