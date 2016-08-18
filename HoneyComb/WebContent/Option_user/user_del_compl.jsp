<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<%
	session.invalidate();
%>

<script>
	var Backlen = history.length;
	history.go(-Backlen);
	window.location.href = '/HoneyComb/index.jsp';
</script>

<body>

</body>
</html>