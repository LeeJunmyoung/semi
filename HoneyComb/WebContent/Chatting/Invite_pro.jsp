<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>

<script type="text/javascript">

opener.location.href='/HoneyComb/page_layout/Chat/Chat_home.jsp';




 window.close(); 
</script>

<body>
<c:forEach var="chat_list" items="${current_chat_list}">
chat_Num : ${chat_list.chat_Num} <br>
chat_Member_Participation : ${chat_list.chat_Member_Participation}<br>

</c:forEach>
</body>
</html>