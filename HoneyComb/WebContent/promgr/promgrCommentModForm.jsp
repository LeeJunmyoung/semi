<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>promgr write</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>
	function writeSave() {
	
		if (document.commentModform.promgr_comment.value == "") {
			alert("내용을 입력하십시요.");
			document.commentModform.promgr_comment.focus();
			return false;
		}
		
		return true;
	
	}
</script>

</head>
<body style="background-color: #e9ebee;">

	<form class="col-sm-10" role="form" method="post" name="commentModform" 
		action="/HoneyComb/promgr/promgrCommentModPro.promgr?comment_num=${comment_num}" 
		onsubmit="return writeSave()" >
		
		<div class="form-group" style="margin-top: 10px;">
			<label for="promgr_comment">댓글내용:</label>
			<textarea class="form-control" rows="5" id="promgr_comment" name="promgr_comment"></textarea>
		</div>
		
		<input type="submit" class="btn btn-primary btn-xs" value="댓글수정">

	</form>

</body>
</html>