<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>member editor</title>

<script>
	function writeCheck() {
		if (document.getElementById("mem_name").value == "") {
			alert("참여자명을 입력하세요");
			return false;
		}

		return true;
	}

	function addView() {
		if (document.getElementById("add").checked == true) {
			document.getElementById("member_search").hidden = false;
		}
	}

	function delView() {
		if (document.getElementById("del").checked == true) {
			document.getElementById("member_search").hidden = true;
		}
	}
</script>

</head>

<body>

	<div id="tab_editor">

		add <input type="radio" id="add" name="tab_editor" onclick="addView()" checked="true" />
		del <input type="radio" id="del" name="tab_editor" onclick="delView()" />

	</div>

	<form id="member_search" method="post"
		action="/HoneyComb/promgr/promgrMemberEditorPro.promgr"
		onsubmit="return writeCheck()">

		<div>
			참여자 명 : <input type="text" id="mem_name"/>
			<input type="submit" value="찾기"/>
		</div>

	</form>

	<div id="mem_list">
		<!-- 회원 번호 가져와서 이름 select해서 list화 -->

		<c:forEach var="item" items="${ memberList }">

			<input type="checkbox">${item.mem_num}/${item.mem_name}</input>
			<br />

		</c:forEach>

	</div>

	<c:if test="${ empty comList }">

		<div id="search" align="center">검색된 결과가 없습니다</div>

	</c:if>

	<c:if test="${ !empty comList }">

		<c:forEach var="search" items="${ comList }">
		
			${search.com_name}&nbsp; ${search.com_add}&nbsp; ${search.com_phone}&nbsp;
			
		</c:forEach>

	</c:if>

</body>

</html>
