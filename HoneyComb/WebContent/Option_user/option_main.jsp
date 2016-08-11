<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>


<body>

<input type = "button" value="현재원" onclick="location.href='/HoneyComb/Option_user/option_check.option'"/>
<c:if test="${com_pos_num < 3 }">
<input type = "button" value="가입승인" onclick="location.href='/HoneyComb/Option_user/company_accept_member.option'"/>

<input type="button" value ="공지작성" onclick="location.href='/HoneyComb/notice/noticeWriteForm.notice'" /> 
</c:if>
<input type = "button" value="마이페이지" onclick="href.location='#'"/>





<input type="button" value="back" onclick="history.go(-1)">
</body>
</html>