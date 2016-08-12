<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<title>member editor</title>

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>

<script>
$(document) .ready(
		function() {
		$("#mem_search_result div").css('display','none');
		});


function filter(){
	
	if($('#mem_name_filter').val()==""){
		$("#mem_search_result div").css('display','none');}			
	else{
		$("#mem_search_result div").css('display','none');
		$("#mem_search_result div[name*='"+$('#mem_name_filter').val()+"']").css('display','');
	}
	
	return false;
	
}	

	function writeCheck() {
		if (document.getElementById("mem_name").value == "") {
			alert("참여자명을 입력하세요");
			return false;
		}

		return true;
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
	
	function memberUpdate(promgr_num, actionChecked) { // 참여자 수정
		
		url = "/HoneyComb/promgr/promgrMemberEditorPro.promgr?promgr_num="+promgr_num+"&actionChecked="+actionChecked;
		window.open(
						url,
						"post",
						"toolbar=no ,width=550 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
</script>

</head>

<body>

	<div id="tab_editor">

		add <input type="radio" id="add" name="tab_editor" onchange="addView()" checked="true" />
		del <input type="radio" id="del" name="tab_editor" onchange="delView()" />

	</div>

	<div id="mem_search_input">
	
		참여자 명 : <input type="text" id="mem_name_filter"
			onkeyup='{filter();return false}'
			onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}' />
			
	</div>

	<div id="mem_search_result">

		<c:forEach var="item" items="${ memberSearchList }">

			<div id="mem_search_item" name="${item.mem_name}">
				<input type="checkbox" name="${item.mem_num}" /> ${item.mem_num} / ${item.mem_name} / ${item.mem_email} / ${item.mem_pos}
			</div>

		</c:forEach>

		<input type="button" value="add" onclick="memberUpdate(${promgr_num}, '1')" />

	</div>

	<div id="mem_list" hidden="true">

		<c:forEach var="item" items="${ memberList }">

			<div>
				<input type="checkbox" name="${item.mem_num}">${item.mem_num} / ${item.mem_name} / ${item.mem_email} / ${item.mem_pos}
			</div>

		</c:forEach>

		<input type="button" value="delete" onclick="memberUpdate(${promgr_num}, '-1')" />

	</div>

</body>

</html>
