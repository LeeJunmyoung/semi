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
	$(document)
			.ready(
					function() {
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
						

					});
	
	function check(){
		<%check = true;
		request.getSession().setAttribute("check", check); %>
		
	}
</script>

</head>
<body style="background-color: white;">
<div align="right"><input type="button" value="+" onclick="location.href='/HoneyComb/page_layout/Calendar/Calendar_home.jsp'"></div>
	<div id='calendar' style='margin: auto; font-size: 13px; width: 30%'></div>
	
	
	



</body>
</html>