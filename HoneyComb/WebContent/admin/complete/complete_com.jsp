<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>사업장 승인폼</title>

<style>
.myButton {
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	display: inline-block;
	cursor: pointer;
	color: #fff;
	font-size: 15px;
	padding: 8px 25px;
	text-decoration: none;
	margin: 20px;
}

.myButton:hover {
	background-color: #344d91;
}

.myButton:active {
	position: relative;
	top: 1px;
}
</style>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>

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
	 
	 url = "complete_comIn.admin?com_num="+num;
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


	<form align="center">
		<h3>사업장 신청 목록</h3>
		<table width="400" border="1" cellpadding="1" cellspacing="0" align="center">
			<tbody>
				<c:if test="${ empty comList }">
					<tr>
						<td align="center">신청한 사업장이 없습니다</td>
					</tr>
				</c:if>
				<c:if test="${ !empty comList }">
					<c:forEach var="compl" items="${comList}">
						<tr>
							<td><a onclick="listCheck(${compl.com_num})">${compl.com_name}</a><input
								type="submit" id="submit" value="등록"
								onclick="submitCheck(${compl.com_num})"> <input
								type="button" id="delete" value="삭제"
								onclick="del(${compl.com_num})"></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<tr>
			<td align="center"><a onclick="history.go(-1)" class="myButton">back</a></td>
		</tr>

	</form>


</body>
</html>
