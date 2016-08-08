<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>삭제 완료 폼</title>
</head>
<script type="text/javascript">
opener.location.reload();
</script>
<body bgcolor="<%=bodyback_c%>">

<center>
삭제가 완료 되었습니다.<p>
				<input type="button" value="확인" onclick="window.close()">
	</center>
	
</body>
</html>