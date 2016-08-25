<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>checkitem write</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>
	function writeSave() {

		if (document.chkItemModform.promgr_list_item.value == "") {
			alert("내용을 입력하십시요.");
			document.chkItemModform.promgr_list_item.focus();
			return false;
		}

		return true;
	}
</script>

</head>
<body style="background-color: #e9ebee;">

	<form class="col-sm-10" role="form" method="post" name="chkItemModform" 
		action="/HoneyComb/promgr/promgrChkItemModPro.promgr?item_num=${item_num}" 
		onsubmit="return writeSave()" >
		
		<div class="form-group" style="margin-top: 10px;">
			<label for="promgr_list_item">항목 명:</label>
			<input type="text" class="form-control" id="promgr_list_item" name="promgr_list_item">
		</div>
		
		<input type="submit" class="btn btn-primary btn-xs" value="항목수정">

	</form>

</body>
</html>