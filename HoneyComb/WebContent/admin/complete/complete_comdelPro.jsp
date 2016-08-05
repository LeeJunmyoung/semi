<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>삭제폼</title>
<c:if test="${check==1}">
<meta http-equiv="Refresh" content="0;url=/admin/complete/complete_com.admin">
alert("삭제 되었습니다")
</c:if>
<c:if test="${check==0}">
<meta http-equiv="Refresh" content="0;url=/admin/complete/complete_com.admin">
alert("삭제에 실패했습니다")
</c:if>
</head>
<body>

</body>
</html>