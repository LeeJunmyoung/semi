<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<tiles:insertDefinition name="home" />
<c:if test="${notice_insert_count==1}">
	<%-- insert 후 main reflash, write 화면 종료 --%>
		<script>
			window.opener.top.location.href="/HoneyComb/notice/noticeMain.notice"
		</script>
		
	</c:if>
