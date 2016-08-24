<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.lang.Object"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel='stylesheet' href='/HoneyComb/Calendar/fullcalendar/fullcalendar.css' />
<script src='/HoneyComb/Calendar/fullcalendar/lib/jquery.min.js'></script>
<script src='/HoneyComb/Calendar/fullcalendar/lib/moment.min.js'></script>
<script src='/HoneyComb/Calendar/fullcalendar/fullcalendar.js'></script>
<style type="text/css">
.row{
position: relative;
top: 30px;
left:30px;

}
#calendar_more_div{

position: relative;
top: 80px;

}
#write_cal{
position: relative;
top: 100px;
}
#title{
width : 500px;
display: inline-block;

}
#start_cal_more{
display: inline;
width:210px;
}

#end_cal_more{
display: inline;
width:210px;
}
#contents{
width: 500px;
display: inline-block;
}
#write_cal_form{
width: 700px;
height:300px;
border: 1px solid #e9ebee;
}
#view{
display: block;
}

#title_form{
position: relative;
top:20px;

}
#date_form{
position: relative;
top:40px;

}

#contents_form{
position: relative;
top:60px;

}
#contents_form p {
display:inline;
position:relative;
top:-60px;
width:40px;

}
#form_submit{
display: inline;
position: relative;
width:500px;
top :80px;
}
#form_submit input{
display: inline;
position: relative;
left: 227px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
				<%boolean check = false;%>
						// page is now ready, initialize the calendar...
						var total1;
						
						
						
						$('#calendar').fullCalendar(
										{

											header : {
												left : 'prev,next,today,myCustomButton',
												center : 'title',
												right : ' '

											},
											height : 500,
											eventClick : function(event) {
											
													if (event.title) {
														
														var start = datetoHtml(event.start);
														if(event.end==null){
															event.end=Number(event.start+86400000);
														}
														var end = datetoHtml(Number(event.end)-86400000);
														
														var url = "/HoneyComb/Calendar/curd_cal_page.jsp?num="+event.number+"&title="
																+ event.title
																+ "&start="
																+ start
																+ "&end="
																+ end
																+ "&contents="
																+ event.Contents;

														open(
																url,
																"confirm",
																"toolbar=no,location=no,status=no,menubar=no,"
																		+ "scrollbars=no,resizable=no,width=450,height=300,left=400,top=200");

													}

											}
										

										});

						$('.fc-prev-button').click(function() {
							//alert('prev is clicked');
							viewScaduel();
						});

						$('.fc-next-button').click(function() {
							//alert('next is clicked');
							viewScaduel();
						});
						$('.fc-today-button').click(function() {
							//alert('next is clicked');
							viewScaduel();
						});
						viewScaduel();

						function viewScaduel() {

							if ('${count}' > 0) {
								var newEvent = new Object();
								var start ;
								var end;
								<c:forEach items = "${total}" var="total">
								start='${total.cal_start}'+"";
								end ='${total.cal_end}'+"";
								newEvent.title = '${total.cal_subject}';
								newEvent.start = start;
								newEvent.end = end;
								newEvent.Contents = '${total.cal_contents}';
								newEvent.number = '${total.cal_num}'
								newEvent.allDay = false;
								
								
								
								$('#calendar').fullCalendar('renderEvent',
										newEvent);

								</c:forEach>

							}

						}
						function datetoHtml(time) {
						
							var time_temp;//13자리
							var date = new Date(time);
							
							time_temp=(Number(date.getYear())+1900)+"-";
							if(date.getMonth()<10){
								time_temp=time_temp+"0";
							}
							time_temp=time_temp+(Number(date.getMonth())+1)+"-";
							if(date.getDate()<10){
								time_temp=time_temp+"0";
							}
							time_temp=time_temp+date.getDate();
							//alert(time_temp);
							return time_temp;

						}

						
						
						
						
						
					});
	
	
</script>

</head>
<body style="background-color: white;">
	

	<div class="row">
	
		<div class="col-md-9">
		
			<b>CALENDAR<%-- <span class="badge">${promgr_count}</span> --%></b>
			
		</div>
		
		<div class="col-md-1"></div>
		
		<div class="col-md-1">
		
			<input type="button" class="btn btn-primary btn-xs" value="뒤로가기"
		  		onclick="location.href='/HoneyComb/index.jsp'">
			
		</div>
	
	</div>
	


<div id = 'calendar_more_div'>


	<div id='calendar' style='margin: auto; font-size: 13px;width:700px;'></div>
	
	
</div>	
<div id = 'write_cal' align="center">
	
	<div id='write_cal_form' >
	
		<form action="/HoneyComb/Calendar/insert.cal" method="post" >
		
		<div id = 'title_form'>	제 목 : <input type="text" name="title" placeholder="SUBJECT" class="form-control" id = 'title'/> </div>
		
		<div id = 'date_form'>	시작 : <input type="date" name="startDate" placeholder="일"  class="form-control" id="start_cal_more"/>
		
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 종료 : <input type="date" name="endDate" placeholder="일"  class="form-control" id = "end_cal_more"/></div>
		
		<div id = 'contents_form'>	<p>내용 : </p><textarea rows="3" cols="30" name="contents" placeholder="CONTENTS" class="form-control" id='contents' ></textarea></div>

		<div id = "form_submit">	<input type="submit" id="view" class="btn btn-primary btn-xs" value ="등록"></input> <input type="reset" class="btn btn-primary btn-xs" value = "초기화">
	
		</div>
	
		</form>

	</div> 
</div>

</body>
</html>