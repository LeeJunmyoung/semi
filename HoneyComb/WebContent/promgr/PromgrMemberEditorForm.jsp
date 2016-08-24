<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<title>member editor</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>

<script>
	$(document).ready(function() {
		$("#mem_search_result div").css('display', 'none');
	});

	function filter() {

		if ($('#mem_name_filter').val() == "") {
			$("#mem_search_result div").css('display', 'none');
		} else {
			$("#mem_search_result div").css('display', 'none');
			$(
					"#mem_search_result div[name*='"
							+ $('#mem_name_filter').val() + "']").css(
					'display', '');
		}

		return false;

	}

	function addView() {
		if (document.getElementById("add").checked == true) {
			document.getElementById("mem_list").hidden = true;
			document.getElementById("mem_search_input").hidden = false;
			document.getElementById("mem_search_result").hidden = false;
		}
	}

	function delView() {
		if (document.getElementById("del").checked == true) {
			document.getElementById("mem_list").hidden = false;
			document.getElementById("mem_search_input").hidden = true;
			document.getElementById("mem_search_result").hidden = true;
		}
	}
</script>

</head>

<body>

	<div id="tab_editor">

		add <input type="radio" id="add" name="tab_editor"
			onchange="addView()" checked="true" />
		del <input type="radio"
			id="del" name="tab_editor" onchange="delView()" />

	</div>

	<div id="mem_search_input">

		참여자 명 : <input type="text" id="mem_name_filter"
			onkeyup='{filter();return false}'
			onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}' />

	</div>

	<form id="mem_search_result" name="mem_search_result" method="post"
		action="/HoneyComb/promgr/promgrMemberEditorAdd.promgr?promgr_num=${promgr_num}">

		<c:forEach var="item" items="${ memberSearchList }">

			<div id="mem_search_item" name="${item.mem_name}">
				<input type="checkbox" name="mem_add" value="${item.mem_num}" />
				${item.mem_num} / ${item.mem_name} / ${item.mem_email} /
				${item.mem_pos}
			</div>

		</c:forEach>

		<input type="submit" value="add" />

	</form>

	<form id="mem_list" hidden="true" method="post"
		action="/HoneyComb/promgr/promgrMemberEditorDel.promgr?promgr_num=${promgr_num}">

		<c:forEach var="item" items="${ memberList }">

			<div>
				<input type="checkbox" name="mem_del" value="${item.mem_num}">${item.mem_num}
				/ ${item.mem_name} / ${item.mem_email} / ${item.mem_pos}
			</div>

		</c:forEach>

		<input type="submit" value="del" />

	</form>

</body>

</html>
