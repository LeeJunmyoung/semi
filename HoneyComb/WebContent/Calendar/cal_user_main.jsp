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
#calendar{
position: relative;
top:50px;


}

</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						// page is now ready, initialize the calendar...
						var total1;

						$('#calendar').fullCalendar(
										{

											header : {
												left : 'prev,next,today,myCustomButton',
												center : 'title',
												right : ' '

											},
											height : 'auto',
											
											eventClick : function(event) {
												
												if (event.title) {
													
													var start = datetoHtml(event.start);
													if(event.end==null){
														event.end=Number(event.start+86400000);
													}
													var end = datetoHtml(Number(event.end)-86400000);
													
													var url = "/HoneyComb/Calendar/main_curd_cal_page.jsp?num="+event.number+"&title="
															+ event.title
															+ "&start="
															+ start
															+ "&end="
															+ end
															+ "&contents="
															+ event.Contents;
															+ "&type=nonono"

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
<body >
	<div class="row">
	
		<div class="col-md-9">
		
			<b>CALENDAR<%-- <span class="badge">${promgr_count}</span> --%></b>
			
		</div>
		
		<div class="col-md-1"></div>
		
		<div class="col-md-1">
		
			<input type="button" class="btn btn-primary btn-xs" value="더보기"
		  		onclick="location.href='/HoneyComb/page_layout/Calendar/Calendar_home.jsp'">
			
		</div>
	
	</div>
	



<br>
<br>
<br>
	<div id='calendar' style='margin: auto; font-size: 13px; width:60%'></div>
	
	
	



</body>
</html>