<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	function opencenter(winNM, width, height) {

		window
				.open(
						"/HoneyComb/complete/popup_main.admin",
						'',
						"toolbar=no,location=no,status=no,menubar=no scrollbars=no,resizable=no,width=400,height=350");
	}
</script>
<link href="/HoneyComb/page_layout/home.css" rel="stylesheet"
	type="text/css" />
<body onload="opencenter()">

	<div id="main_notice">
		<jsp:include page="/notice/noticeMain.jsp"></jsp:include>
	</div>
	<div id="main_project_manage"></div>
	<div id="main_cal">
		<jsp:include page="/Calendar/cal_user_main.jsp"></jsp:include>
	</div>
</html>


