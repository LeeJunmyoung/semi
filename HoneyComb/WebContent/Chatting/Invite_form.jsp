<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>채팅 멤버 추가</title>
</head>
<body>

<input type="text" placeholder="이름">

<table>
<tr><td>이름</td><td>직책</td><td>부서</td></tr>
<c:if test="${members}!=null">
<c:forEach var="members" items="${members}" >


</c:forEach>
</c:if>

</table> 



</body>
</html>