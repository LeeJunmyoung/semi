<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	function pop_up() {
		var noticeCookie = getCookie("CookieName");
		if (noticeCookie != "no") {

			window.open("/HoneyComb/complete/popup_main.admin", '', "toolbar=no,location=no,status=no,menubar=no scrollbars=no,resizable=no,left=400, top=100,width=400,height=350");
		}
	}

	function getCookie(name) {
		var Found = false
		var start, end
		var i = 0
		while (i <= document.cookie.length) {
			start = i
			end = start + name.length

			if (document.cookie.substring(start, end) == name) {
				Found = true
				break;
			}
			i++
		}

		if (Found == true) {
			start = end + 1
			end = document.cookie.indexOf(";", start)

			if (end < start)
				end = document.cookie.length

			return document.cookie.substring(start, end)
		}
		return ""
	}
</script>

<body onload="pop_up()">

	<div id="main_notice">
		<jsp:include page="/notice/noticeMain.jsp"></jsp:include>
	</div>
	<div id="main_project_manage">
	<jsp:include page="/promgr/promgrMain.jsp"></jsp:include>
	</div>
	<div id="main_cal">
		<jsp:include page="/Calendar/cal_user_main.jsp"></jsp:include>
	</div>
</body>
</html>
