<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
<title>notice</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>
	
 	function writeView() { // 공지 작성
		url = "/HoneyComb/notice/noticeWriteForm.notice";
		window.open(
						url,
						"post",
						"toolbar=no ,width=550 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no"
					);
	}
	
</script>

</head>
<body>
	<div class="row">
	
		<div class="col-md-9">
		
			<b>NOTICE <span class="badge">${notice_count}</span></b>
			
		</div>
		
		<div class="col-md-1" style="margin-right: 3px;">	
		
			<input type="button" class="btn btn-primary btn-xs btn-lg" value="공지작성"
				onclick="writeView()" >
					
		</div>
		
		<div class="col-md-1">
		
				<input type="button" class="btn btn-primary btn-xs" value="더보기"
			  		onclick="location.href='/HoneyComb/notice/noticeMore.notice'">
			
		</div>
		
	</div>

	<div class="row">
	
		<div class="col-md-11">
			
			<c:if test="${notice_count == 0}">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="text-center">제목</th>
							<th class="text-center">작성자</th>
							<th class="text-center">작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>공지 글이 없습니다.</td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</c:if>
		
			<c:if test="${notice_count > 0}">
			
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="text-center">제목</th>
							<th class="text-center">작성자</th>
							<th class="text-center">작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="article" items="${articleList}">
							<tr data-toggle="modal" 
							data-target="#notice_content_${article.notice_num}" >
								<th class="col-md-6">
									${article.notice_title}
									<c:if test="${article.isNew == 0}">
										<span class="badge">new</span>
									</c:if>
								</th>
								<th class="col-md-2 text-center">${article.notice_member}</th>
								<th class="col-md-4 text-center">${article.notice_date}</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			
				<c:forEach var="article" items="${articleList}">
				  <div class="modal fade" id="notice_content_${article.notice_num}" role="dialog">
				    <div class="modal-dialog modal-sm">
				      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal" onclick="location.reload()">&times;</button>
				          <h4 class="modal-title">${article.notice_title}
				          	<c:if test="${article.isNew == 0}">
								<span class="badge">new</span>
							</c:if>
				          </h4>
				        </div>
				        <div class="modal-body">
				          <p>${article.notice_content}</p> <br>
				          <p>작성일 : ${article.notice_date}</p>
				        </div>
				        <div class="modal-footer">
				          <button type="button" class="btn btn-primary btn-xs" data-dismiss="modal" onclick="location.reload()">Close</button>
				        </div>
				      </div>
				    </div>
				  </div>
				</c:forEach>
				
				
			</c:if>
			
		</div>
		
	</div>
	
</body>
</html>
