<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>등록 완료 폼</title>
</head>
<script>
	opener.location.reload();
</script>
<body bgcolor="<%=bodyback_c%>">
	<center>
		등록이 완료 되었습니다.
		<p>
			<input type="button" value="확인" onclick="window.close()">
	</center>

</body>
</html>