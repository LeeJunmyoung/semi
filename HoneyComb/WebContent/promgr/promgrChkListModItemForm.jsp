<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>checkitem write</title>

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
<body>

	<form method="post" name="chkItemModform"
		action="/HoneyComb/promgr/PromgrChkListModItemPro.promgr?item_num=${item_num}"
		onsubmit="return writeSave()">

		항목 명 : <input type="text" name="promgr_list_item" size="30"
			maxlength="40" /> <input type="submit" value="추가" />

	</form>

</body>
</html>