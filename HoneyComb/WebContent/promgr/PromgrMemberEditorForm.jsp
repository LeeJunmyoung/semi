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
		
		if(document.getElementById("mem_list").style.display == "block") {
			document.getElementById("mem_list").style.display = "none"
			document.getElementById("mem_search_input").style.display = "block"
			document.getElementById("mem_search_result").style.display = "block"
		}
		
	}

	function delView() {
		if(document.getElementById("mem_list").style.display == "none") {
			document.getElementById("mem_list").style.display = "block"
			document.getElementById("mem_search_input").style.display = "none"
			document.getElementById("mem_search_result").style.display = "none"
		}
	}
</script>

</head>

<body style="background-color: #e9ebee;">


<div class="text-center">

	<div class="btn-group" style="margin-bottom: 10px; margin-top: 10px;">
	
		<input type="button" class="btn btn-primary btn-md col-md-6" value="ADD"  
			onclick="addView()">
																		
		<input type="button" class="btn btn-primary btn-md col-md-6" value="DEL"  
			onclick="delView()">
																		
	</div>

</div>
	
	<div id="mem_search_input">
	
		<div class="form-group col-md-10">
			<label for="mem_name_filter">참여자 명 : </label>
			<input type="text" class="form-control" id="mem_name_filter"
			onkeyup='{filter();return false}'
			onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}'>
		</div>

	</div>
	
	<form class="col-sm-10" role="form" id="mem_search_result" name="mem_search_result" method="post"
		action="/HoneyComb/promgr/promgrMemberEditorAdd.promgr?promgr_num=${promgr_num}">

		<c:forEach var="item" items="${ memberSearchList }">

			<div id="mem_search_item" name="${item.mem_name}" class="row">
				<span class="col-md-1">
					<input type="checkbox" name="mem_add" value="${item.mem_num}" />
				</span>
				<span class="col-md-3">${item.mem_name}</span>
				<span class="col-md-6">${item.mem_email}</span>
				<span class="col-md-2">${item.mem_pos}</span>
			</div>

		</c:forEach>

		<input type="submit" class="btn btn-primary btn-xs" value="참여자추가" style="margin-top: 5px;" />

	</form>

	<form class="col-sm-10" role="form" id="mem_list" method="post" style="display: none;"
		action="/HoneyComb/promgr/promgrMemberEditorDel.promgr?promgr_num=${promgr_num}">

		<c:forEach var="item" items="${ memberList }">

			<div class="row">
				<span class="col-md-1">
					<input type="checkbox" name="mem_del" value="${item.mem_num}" />
				</span>
				<span class="col-md-3">${item.mem_name}</span>
				<span class="col-md-6">${item.mem_email}</span>
				<span class="col-md-2">${item.mem_pos}</span>
			</div>

		</c:forEach>

		<input type="submit" class="btn btn-primary btn-xs" value="참여자삭제" style="margin-top:10px;" />

	</form>

</body>

</html>
