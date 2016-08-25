<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>채팅 멤버 추가</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style type="text/css">

#member_check{
position:relative;
top:30px;
width:370px;
margin: auto;
}
td{
text-align: center;
}


form{

margin: auto;
}

.title {
	background: #344d91;
	color: white;
}

#title {
	table-layout: fixed;
	position: relative;
	margin: 0 auto;
}

#title>tbody {
	overflow-y: auto;
	overflow-x: hidden;
	max-height: 150px;
}

#title th {
	background: #344d91;
	color: white;
	font-size: 16px;
	letter-spacing: 1.5px;
	font-weight: bold;
	padding: 10px;
	text-align: center;
	color: white;
}

#text:nth-child(odd) {
	background-color: #e9ebee;
	color: black;
}

#text:hover {
	background-color: #A4A4A4;
	color: black;
}

#title_option tr{
height: 31px;

}
td{
vertical-align: middle;
}
 #back_button{
 position: relative;
 top:60px;
 
 }

#back_button{
width:50px;
margin: auto;
}
#back_button_div{
width:60px;
margin: auto;
}
tr{
height: 31px;
 }
 td{
 height: 31px;
 }
h1_tag{
width: 230px;
margin: 0px;
}
h1{

 width:200px;
 margin: auto;
}

#no_member{
width:680;
text-align:center;
font-size:20pt;
margin: auto;
}
#invite_button{
position: relative;
top:30px;

}
#invite_form{
position: relative;
top: 10px;
}

</style>
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript">
$("input", opener.document).css("color","black");


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


	<div  id ='invite_form'align = "center">
	<div id = "name_search">
		<input type="text" placeholder="이름" id='search_name'  onkeyup='{filter();return false}' onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}'>
	</div>
	<br>
<div id = "search_member">

<form action="/HoneyComb/Chatting/Invite_member.chat"  method="post" >
		<table  >
		
			<tr class='title'>
				<td id='title' width='80px'>이름</td>
				<td id='title'width='80px'>직책</td>
				<td id='title'width='80px'>부서</td>
			</tr>
			
			
			<c:if test="${ !empty chat_members }">
				<c:forEach var="members" items="${chat_members}">
			
			<tbody id='membersTbody'>
					<tr name="${members.name}" id='text'>
						<td width="100px"><input type="checkbox" id ='${members.name}' name='check' value="${members.mem_num}"><label for='${members.name}'>${members.name}</label></td>
						<td>${members.com_pos_name}</td>
						<td>${members.com_dept_name}</td>
					</tr>
					
					</tbody>
				</c:forEach>
			</c:if>
			
	
					

		</table>
		<input type ="submit" class="btn btn-primary btn-xs"  value="초대" id = 'invite_button' > 
		 </form>	
	</div>
	
 
	</div>



</body>
</html>