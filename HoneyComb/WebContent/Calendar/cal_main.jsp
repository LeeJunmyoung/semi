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
											height : 'auto',
											eventClick : function(event) {
												if ('${count}' > 0) {
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
																		+ "scrollbars=no,resizable=no,width=550,height=400");

													}

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
	
	function check(){
		<%check = true;
		request.getSession().setAttribute("check", check); %>
		
	}
</script>

</head>
<body style="background-color: white;">
	<div id='calendar' style='margin: auto; font-size: 13px; width: 30%'></div>
	
	
	

	<div style="width: 30%; margin: auto;">
		<form action="/HoneyComb/Calendar/insert.cal" method="post" onsubmit="check()">
			<input type="text" name="title" placeholder="SUBJECT" /><br> <input
				type="date" name="startDate" placeholder="일" /> <br> <input
				type="date" name="endDate" placeholder="일" /><br>
			<textarea rows="3" cols="30" name="contents" placeholder="CONTENTS"></textarea>

			<input type="submit" id="view">
		</form>

	</div>


</body>
</html>