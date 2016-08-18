<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<%
	session.invalidate();
%>

<script>
	function opener_close() {
		opener.window.location.href = "/HoneyComb/view/mainPage.jsp";
		this.window.close();
	}
</script>

<body onload="setTimeout('opener_close()', '3000')">
<h3 align="center">3초후 메인화면으로 이동합니다</h3>
</body>
</html>