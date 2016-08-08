<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>사업장 승인폼</title>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script>
	$(document).ready(function() {
		//최상단 체크박스 클릭
		$("#chkall").click(function() {
			//클릭되었으면
			if ($("#chkall").prop("checked")) {
				//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
				$("input[name=com_name]").prop("checked", true);
				//클릭이 안되있으면
			} else {
				//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
				$("input[name=com_name]").prop("checked", false);
			}
		});

	});
</script>

<script>
	function listCheck(come_num) {;
		var num = come_num;
		
		url = "complete_comPro.admin?com_num=" + num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=500,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
 
	}

	 function del(come_num) {;
		var num = come_num;
		
		
		url = "complete_comDel.admin?com_num=" + num;

			  window
					.open(
							url,
							"post",
							"toolbar=no,width=500,height=300,directories=no,status=yes,scrollbars=yes,menubar=no"); 
			  
	} 
	 
	 function submitCheck(come_num){;
	 var num = come_num;
	 /* if($("#chkall").prop("checked",true)){ */
	 
	 url = "complete_comIn.admin?com_num=" + num;
	 window
		.open(
				url,
				"post",
				"toolbar=no,width=500,height=300,directories=no,status=yes,scrollbars=yes,menubar=no"); 
	 /* }else{
		 alert("등록할 사업장을 선택해주세요.");
	 } */
	 }
	 
</script>
</head>
<body bgcolor="<%=bodyback_c%>">


	<form name="wtf">
		<h3>사업장 신청 목록</h3>
		<table width="400" border="1" cellpadding="1" cellspacing="0">
			<tbody>
				<tr>
					<td align="center">AllSelect<input id="chkall" type="checkbox">
					</td>
				</tr>
				<c:if test="${ empty comList }">
					<tr>
						<td align="center">신청한 사업장이 없습니다</td>
					</tr>
				</c:if>
				<c:if test="${ !empty comList }">
					<c:forEach var="compl" items="${comList}">
						<tr>
							<td><input type="checkbox" id="company"> <a onclick="listCheck(${compl.com_num})">${compl.com_name}</a>
								<input type="button" id="delete" value="삭제" onclick="del(${compl.com_num})"></td>
						</tr>

				<tr>
						<td align="center"><input type="submit" id="submit" value="등록" onclick="submitCheck(${compl.com_num})"></td>
						</tr>
											</c:forEach>
				</c:if>
			</tbody>
		</table>

	</form>


</body>
</html>
