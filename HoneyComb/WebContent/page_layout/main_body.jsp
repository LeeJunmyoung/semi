<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href="/HoneyComb/page_layout/home.css" rel="stylesheet" type="text/css" />
<body>

<c:if test="${noticeList_check==1}">
	<%-- insert 후 main reflash, write 화면 종료 --%>
		<script>
			window.opener.top.location.href="/HoneyComb/notice/noticeMain.notice"
			window.close()
		</script>
		
	</c:if>

<div id = "main_notice">
 <jsp:include page="/notice/noticeMain.jsp"></jsp:include>
</div>
<div id = "main_project_manage">

</div>
<div id = "main_cal">
<jsp:include page="/Calendar/cal_user_main.jsp"></jsp:include>
</div>
</html>


