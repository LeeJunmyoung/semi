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

	<div class="row">
	
		<div class="col-md-9">
		
			<b>PROJECT MANAGER <span class="badge">${promgr_count}</span></b>
			
		</div>
		
		<div class="col-md-1"></div>
		
		<div class="col-md-1">
		
			<input type="button" class="btn btn-primary btn-xs" value="더보기"
		  		onclick="location.href='/HoneyComb/promgr/promgrMore.promgr'">
			
		</div>
	
	</div>
	
	<div class="row">
	
		<div class="col-md-11">
		
			<c:if test="${promgr_count == 0}">
				
				<table class="table">
						<thead>
							<tr>
								<th class="text-center">프로젝트 명</th>
								<th class="text-center">프로젝트 시작일</th>
								<th class="text-center">진행률</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>프로젝트가 없습니다.</td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				
			</c:if>
	
			<c:if test="${promgr_count > 0}">
			
				<table class="table">
					<thead>
						<tr>
							<th class="col-md-2 text-center">프로젝트 명</th>
							<th class="col-md-4 text-center">프로젝트 시작일</th>
							<th class="col-md-6 text-center">진행률</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="article" items="${ pro_articleList}">
							<tr>
								<td class="col-md-2 text-center">${article.promgr_name}</td>
								<td class="col-md-4 text-center">${article.promgr_date}</td>
								<td class="col-md-6 text-center">
									<div id="promgr_${article.promgr_num}_ing">
										<div class="progress">
				    						<div class="progress-bar" role="progressbar" aria-valuenow="${article.promgr_ing}" aria-valuemin="0" aria-valuemax="100" style="width:${article.promgr_ing}%">
				    							${article.promgr_ing}%
											</div>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</c:if>
		
		</div>
		
	</div>

</body>
</html>