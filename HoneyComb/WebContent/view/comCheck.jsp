<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
${mem_num} mem_num<br>
${com_num} ccom_num<br>
${com_dept_num} dept num<br>
${com_pos_num} pos num<br>
${name} name<br>
${email} email<br>
<% response.sendRedirect("/HoneyComb/coin/Com_check.coin"); %> 
</body>
</html>