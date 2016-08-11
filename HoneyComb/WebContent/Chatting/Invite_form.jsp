<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>채팅 멤버 추가</title>
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript">



function filter(){
	if($('#search_name').val()=="")
		$("#membersTbody tr").css('display','');			
	else{
		$("#membersTbody tr").css('display','none');
		$("#membersTbody tr[name*='"+$('#search_name').val()+"']").css('display','');
	}
	return false;
}

</script>

</head>
<body>


	<div align = "center">
	<div id = "name_search">
		<input type="text" placeholder="이름" id='search_name'  onkeyup='{filter();return false}' onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}'>
	</div>
	<br>
<div id = "search_member">

<form action="/HoneyComb/Chatting/Invite_member.chat"  method="post" onsubmit="#" >
		<table border = "1px">
		
			<tr>
				<td>이름</td>
				<td>직책</td>
				<td>부서</td>
			</tr>
			
			
			<c:if test="${ !empty chat_members }">
				<c:forEach var="members" items="${chat_members}">
			
			<tbody id='membersTbody'>
					<tr name="${members.name}">
						<td width="100px"><input type="checkbox" id ='${members.name}' name='check' value="${members.mem_num}"><label for='${members.name}'>${members.name}</label></td>
						<td>${members.com_pos_name}</td>
						<td>${members.com_dept_name}</td>
					</tr>
					
					</tbody>
				</c:forEach>
			</c:if>
	

		</table>
		<input type ="submit" value="초대" > 
		 </form>	
	</div>
	
 
	</div>



</body>
</html>