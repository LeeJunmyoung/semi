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
    
	function noticeRowView(rowNum) { // 공지 정보 보기
		url = "/HoneyComb/notice/noticeContent.notice?num="+rowNum;
		window.open(
						url,
						"post",
						"toolbar=no ,width=550 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no"
					);
	}
	
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
<div width="400" height="150">
	<b>NOTICE <span class="badge">${notice_count}</span></b>

	<div align="right">
	  <input type="button" class="btn btn-primary btn-xs" value="더보기"
	  	onclick="location.href='/HoneyComb/notice/noticeMore.notice'">
	
		<input type="button" class="btn btn-primary btn-xs" value="공지작성"
			onclick="writeView()" >		
	</div>
	
	<c:if test="${notice_count == 0}">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>공지 글이 없습니다.</td>
				</tr>
			</tbody>
		</table>
	</c:if>

	<c:if test="${notice_count > 0}">
	
		<table class="table table-hover">
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${articleList}">
					<tr data-toggle="modal" 
					data-target="#notice_content_${article.notice_num}" >
						<th>
							${article.notice_title}
							<c:if test="${article.isNew == 0}">
								<img src="../images/hot.gif">
							</c:if>
						</th>
						<th>${article.notice_member}</th>
						<th>${article.notice_date}</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
		<c:forEach var="article" items="${articleList}">
		  <div class="modal fade" id="notice_content_${article.notice_num}" role="dialog">
		    <div class="modal-dialog modal-sm">
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">${article.notice_title} (${article.notice_date})</h4>
		        </div>
		        <div class="modal-body">
		          <p>${article.notice_content}</p>
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-primary btn-xs" data-dismiss="modal">Close</button>
		        </div>
		      </div>
		    </div>
		  </div>
		</c:forEach>
		
	</c:if>
</div>
</body>
</html>
