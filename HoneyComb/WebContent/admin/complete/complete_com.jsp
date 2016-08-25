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


#complete_com_div{
width: 70%;
height:89%;
background: white;
position: relative;
left: 250px;

}
#home_banner {
	width: 100%;
	height: 11%;
	background-color: #344d91;
	margin: 0;
	padding: 0;
}

#logo_wrapper {
	position: relative	;
	left: 250px;
	
}

#logo_banner {
	display: inline;
	margin: auto;
	width: 100px;
	height: 100px;
}

#Honey_comB {
	display: inline;
	font-size: 38pt;
	color: #fff;
	vertical-align: middle;
}

#logo_a {
	text-decoration: none;
}


#back_button {
	
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


html{
width: 100%;
height: 100%;
}
 body{
 
background:#e9ebee;
height: 100%;
 }


</style>
<script>
	function listCheck(come_num) {;
		var num = come_num;
		
		url = "complete_comPro.admin?com_num=" + num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=700,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
 
	}

	 function del(come_num) {;
		var num = come_num;
		
		
		url = "complete_comDel.admin?com_num=" + num;

			  window
					.open(
							url,
							"post",
							"toolbar=no,width=600,height=300,directories=no,status=yes,scrollbars=yes,menubar=no"); 
			  
	} 
	 
	 function submitCheck(come_num){;
	 var num = come_num;
	 
	 url = "complete_comIn.admin?com_num="+num;
	 window
		.open(
				url,
				"post",
				"toolbar=no,width=600,height=300,directories=no,status=yes,scrollbars=yes,menubar=no"); 
	 }
	 
</script>
</head>
<body background='e9ebee'>




<div id="home_banner">
		<div id="logo_wrapper">
			<img id="logo_banner" src="/HoneyComb/page_layout/page_image/logo.png" width="100"
				height="100" onclick="location.href='/HoneyComb/index.jsp'"> <a id="logo_a" href="/HoneyComb/index.jsp"><p id="Honey_comB">HoneyComb</p></a>
		</div>
</div>



<div id = 'complete_com_div'>

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

</div>
</body>
</html>
