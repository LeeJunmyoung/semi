<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>promgr main</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</head>
<body>
<input type = "button" value="+" onclick="location.href='/HoneyComb/promgr/promgrMore.promgr'">
<div align="center">
	<b>프로젝트 목록 (전체 프로젝트 : ${promgr_count})</b>
</div>

	<c:if test="${promgr_count == 0}">
			<div align="center">프로젝트가 없습니다.</div>
		</c:if>

	<c:if test="${promgr_count > 0}">
	
		<c:forEach var="article" items="${ pro_articleList}">
			
			<div id="promgr_${article.promgr_num}">
			
				<div>프로젝트 명 : ${article.promgr_name} (${article.promgr_num})</div>
					
				<div>시작일 : ${article.promgr_date}</div>
					
				<div id="promgr_${article.promgr_num}_ing">
					<div class="progress">
	    				<div class="progress-bar" role="progressbar" aria-valuenow="${article.promgr_ing}" aria-valuemin="0" aria-valuemax="100" style="width:${article.promgr_ing}%">
	    					${article.promgr_ing}%
						</div>
					</div>
				</div>
					
			</div>
				
		</c:forEach>
		
	</c:if>

</body>
</html>