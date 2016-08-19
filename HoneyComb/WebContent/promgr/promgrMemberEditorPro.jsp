<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>member check</title>
</head>
<body>

	<c:if test="${promgr_update_count > 0}">
		<script>
			window.opener.top.location.reload(true);
			window.close();
		</script>
	</c:if>

	<c:if test="${promgr_update_count == 0}">
		<script>
			alert("선택한 인원이 없습니다. 다시 선택하십시요.");
			history.go(-1);
		</script>
	</c:if>

</body>
</html>