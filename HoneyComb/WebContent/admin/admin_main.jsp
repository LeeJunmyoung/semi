<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<script>
	function logout() {

		var out = confirm("정말 로그아웃 하시겠습니까?");

		if (out) {
			location.href = "/HoneyComb/Option_user/logout_page.jsp";
		} else {
			return false;
		}
	}
</script>

</head>
<body>
	관리자 페이지
	<p>
		<tr>
			<td><input type="button" value="현황 확인"
				onClick="javascript:window.location='/HoneyComb/memCheck/memCheck_Main.mc'"></td>
		</tr>
	<p>
		<tr>
			<td><input type="button" value="회사 승인"
				onClick="javascript:window.location='/HoneyComb/complete/complete_com.admin'"></td>
		</tr>
	<p>
		<tr>
			<td><input type="button" value="관리자 공지 보내기"
				onClick="javascript:window.location='/HoneyComb/admin/complete/complete_comNotice.jsp'"></td>
		</tr>
	<p>
		<tr>
			<td><input type="button" value="로그아웃"
				onclick="logout();return false;" onkeypress="this.onclick;">
			</td>
		</tr>
</body>
</html>