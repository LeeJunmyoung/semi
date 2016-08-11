<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../complete/view/color.jsp"%>
<html>
<head>
<title>현황 확인 폼(가입인원 체크)</title>

<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<script type='text/javascript'>
	function filter(){
		if($('#com_name').val()=="")
			$("#modify tr").css('display','');			
		else{
			$("#modify tr").css('display','none');
			$("#modify tr[name*='"+$('#com_name').val()+"']").css('display','');
		}
		return false;
	}
</script>


<script>
	function searchClick() {
		if(!document.join_company.com_name.value) {
			alert("조회할 사업장명을 입력해주세요!");
			return false;
		}
		
		return true;
	}
	
	function memberList(com_num) {

		url = "memCheck_MemberList.mc?com_num=" + com_num;
		window.open(url, "post", "toolbar=no,width=1000,height=400,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
</script>
</head>
<body bgcolor="<%=bodyback_c%>">
	<!-- method="post" action="" -->

	<form name="join_company" align="center" method="post" action="/HoneyComb/memCheck/memCheck_ComSearch.mc">
	<!-- method="post" action="/HoneyComb/admin/memCheck/memCheck_ComSearch.mc" -->
		<h3>현황 확인</h3>
		<input type="text" placeholder="Company" id="com_name"  onkeyup='{filter();return false}' onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}'>
		<input type="submit" value="search" onclick="return searchClick()">
		<p>
		<table  border="1" cellpadding="1" cellspacing="0" align="center" >
			<tr>
				<td width="100" align="center">Company</td>
				<td width="250" align="center">Address</td>
				<td width="70" align="center">Affiliation</td>
				<td width="150" align="center">PhoneNumber</td>
				<td width="70" align="center">Detail</td>
			</tr>
			<c:if test="${ empty companyList }">
				<tr>
					<td colspan="5"><p align="center">왜 조회가 안되니 데이터가 없잖니</p></td>
				</tr>
			</c:if>
			<c:if test="${ !empty companyList }">
				<c:forEach var="com" items="${ companyList }">
					
					<tbody id = "modify">
					
					<tr  id = 'check_com' name='${ com.com_name }'>
						<td width="100" align="center" >${ com.com_name }</td>
						<td width="250" align="center">${ com.com_add }</td>
						<td width="70" align="center">${ com.com_aff }</td>
						<td width="150" align="center">0${ com.com_phone }</td>
						<td style="margin: 0">
						<input type="button" value="memberList" onclick="memberList(${ com.com_num })">
						</td>
					</tr>
					
					</tbody>
				</c:forEach>
			</c:if>
		
		</table>
	</form>

</body>
</html>
