<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>

		<h2>사용자 이름</h2>

	<ul>

		<tiles:importAttribute name="userMenus" />
		<c:forEach var="menu" items="${userMenus}">
			<li><a href="${menu.link}">${menu.name}</a></li>
		</c:forEach>
		<li><a  href="/HoneyComb/Option_user/logout_page.jsp" >log out</a></li>
	</ul>

</body>
</html>


