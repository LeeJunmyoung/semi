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
<body style="background-color: #e9ebee;">

	<form class="col-sm-10" role="form" method="post" name="promgrAddform" 
		action="/HoneyComb/promgr/promgrAddPro.promgr" onsubmit="return writeSave()" >
		
		<div class="form-group" style="margin-top: 10px;">
			<label for="promgr_title">프로젝트제목:</label>
			<input type="text" class="form-control" id="promgr_title" name="promgr_title">
		</div>
		
		<div class="form-group">
			<label for="promgr_content">프로젝트내용:</label>
			<textarea class="form-control" rows="5" id="promgr_content" name="promgr_content"></textarea>
		</div>
		
		<input type="submit" class="btn btn-primary btn-xs" value="프로젝트생성">

	</form>
	
</body>
</html>