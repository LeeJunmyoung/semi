<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>write check</title>
</head>
<body>

	<c:if test="${promgr_insert_count==1}">
		<%-- insert 후 main reflash, write 화면 종료 --%>
		<script>
			window.opener.top.location.href = "/HoneyComb/promgr/promgrMore.promgr"
			window.close()
		</script>

	</c:if>

</body>
</html>