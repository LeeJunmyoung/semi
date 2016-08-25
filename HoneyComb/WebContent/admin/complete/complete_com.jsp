<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>사업장 승인폼</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>

<style>
#back_button {
	position: relative;
	top: 60px;
}

#back_button {
	width: 50px;
	margin: auto;
}

#submit {
	width: 50px;
	margin: auto;
}

#delete {
	width: 50px;
	margin: auto;
}

#back_button_div {
	width: 60px;
	margin: auto;
}

#h1_tag {
	width: 500px;
	margin: auto;
	font-size: 40px;
	text-align: center;
}

h1 {
	width: 500px;
	margin: auto;
	text-align: center;
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
	 
	 url = "complete_comIn.admin?com_num="+num;
	 window
		.open(
				url,
				"post",
				"toolbar=no,width=500,height=300,directories=no,status=yes,scrollbars=yes,menubar=no"); 
	 }
	 
</script>
</head>
<body>
	<div id='h1_tag'>
		<br>Company Approval
		<hr>
	</div>
	<br>
	<form align="center">
		<table width="400" border="1" cellpadding="1" cellspacing="0"
			align="center">
			<tbody>
				<c:if test="${ empty comList }">
					<tr>
						<td align="center">신청한 사업장이 없습니다</td>
					</tr>
				</c:if>
				<c:if test="${ !empty comList }">
					<c:forEach var="compl" items="${comList}">
						<tr>
							<td><a onclick="listCheck(${compl.com_num})" id="compl">${compl.com_name}</a></td>
							<td id="compl_button"><input type="submit"
								class="btn btn-primary btn-xs" id="submit" value="등록"
								onclick="submitCheck(${compl.com_num})"> <input
								type="button" class="btn btn-primary btn-xs" id="delete"
								value="삭제" onclick="del(${compl.com_num})"></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div id="back_button_div">

			<input type="button" class="btn btn-primary btn-xs" value="back"
				id='back_button' onclick="history.go(-1)">
		</div>

	</form>


</body>
</html>
