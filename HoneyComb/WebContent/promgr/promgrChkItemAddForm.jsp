<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>checkitem write</title>

<script>
	function writeSave() {

		if (document.chkItemAddform.promgr_list_item.value == "") {
			alert("내용을 입력하십시요.");
			document.chkItemAddform.promgr_list_item.focus();
			return false;
		}

		return true;
	}
</script>

</head>
<body>

	<form method="post" name="chkItemAddform"
		action="/HoneyComb/promgr/PromgrChkItemAddPro.promgr?promgr_num=${promgr_num}&list_num=${list_num}"
		onsubmit="return writeSave()">

		<input type="text" name="promgr_list_item" size="30" maxlength="40" placeholder="check item name" />
		<input type="submit" value="Add Item" />

	</form>

</body>
</html>