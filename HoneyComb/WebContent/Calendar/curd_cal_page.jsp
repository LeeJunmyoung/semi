<%@page import="org.apache.jasper.tagplugins.jstl.core.Param" pageEncoding="utf-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.title }</title>

<script type="text/javascript">
function deleteCal() {
	<%
	String number = request.getParameter("num");
	request.setAttribute("calnum", number); 
	%>
	var cc = true;
	var url = "del_cal.cal?number="+<%=request.getParameter("num")%>;
	open(url,"confirm","toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=550,height=400");

	

	
	
}


</script>

</head>
<body >
	<form action="/HoneyComb/Calendar/modify.cal" method="post"  >
			 <input type="text" name="title" placeholder="SUBJECT" value="${param.title }"/><br>
			 <input type="date"	name="startDate" placeholder="일" value="${param.start}"/> <br>
			 <input type="date"	name="endDate" placeholder="일" value="${param.end}"/><br> 
			 <textarea rows="3" cols="30" name="contents" placeholder="CONTENTS">${param.contents}</textarea>
			 <input type="hidden" name = "cal_num" value="${param.num}">

			 <br>
			 <input type="submit" id="modify" value="수정"/>
			 <input type="button" id ="del" value = "삭제" onclick="location.href='del_cal.cal?number=<%=request.getParameter("num")%>'"/>
			 <input type="button" value="닫기" onclick="window.close()">
</form>
</body>
</html>