<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>checkitem write</title>

<script>
	function writeSave() {

		if (document.addItemform.promgr_list_item.value == "") {
			alert("내용을 입력하십시요.");
			document.addItemform.promgr_list_item.focus();
			return false;
		}

		return true;
	}
</script>

</head>
<body>

	<form method="post" name="addItemform"
		action="/HoneyComb/promgr/PromgrChkListAddItemPro.promgr?promgr_num=${promgr_num}&chklist_title=${title_num}"
		onsubmit="return writeSave()">

		항목 명 : <input type="text" name="promgr_list_item" size="30"
			maxlength="40" /> <input type="submit" value="추가" />

	</form>

</body>
</html>