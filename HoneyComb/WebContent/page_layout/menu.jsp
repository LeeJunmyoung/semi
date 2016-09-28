<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
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
<body>
<div id ="menu_div">
<h1 align="center">${ sessionScope.com_name }</h1>

		<h2 ><img src="${ sessionScope.profile_img }"  width="150" height="153" onerror="this.src='/HoneyComb/images/user.png'" title="내 프로필 사진"></h2>
		
		<h2 id="my_profile">${ sessionScope.name }</h2>

	<ul>     

		<li><a href="/HoneyComb/Chatting/Chat_main.chat">MESSAGE</a></li>
		<li><a href="/HoneyComb/cloud/cloudForm.cloud">CLOUD</a></li>
		<li><a href="/HoneyComb/page_layout/Option/Option_home.jsp">OPTION</a></li>
		<li><a href="#logout" onclick="logout();return false;" onkeypress="this.onclick;">LOG OUT</a></li>
		<!-- <a href="/HoneyComb/Option_user/logout_page.jsp"> -->
	
	</ul>
	
</div>
</body>
</html>
