<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<script>

	$(function() {
		$("dd:not(:first)").css("display", "none");
		$("dl dt").click(function() {
			if ($("+dd", this).css("display") == "none") {
				$(this).siblings("dd").slideUp("slow");
				$("+dd", this).slideDown("slow");
			}
		});
	});
	
</script>

<body>

	<div class="row">

		<div class="col-md-9">

			<b>NOTICE <span class="badge">${notice_count}</span></b>

		</div>

		<div class="col-md-1"></div>

		<div class="col-md-1">

			<input type="button" class="btn btn-primary btn-xs" value="뒤로가기"
				onclick="location.href='/HoneyComb/index.jsp'">

		</div>

	</div>

	<div class="row" style="margin-top: 7px;">
	
		<div class="col-md-1"></div>

		<div class="container col-md-10">

			<c:if test="${notice_count == 0}">
			
				<div class="row">
					<div class="col-md-12 text-center">공지사항이 없습니다.</div>
				</div>
				
			</c:if>

			<c:if test="${notice_count > 0}">

				<div class="row">
					<b class="col-md-6 text-center">제 목</b>
					<b class="col-md-2 text-center">작성자</b>
					<b class="col-md-4 text-center">작성일</b>
				</div>

				<dl class="list-group col-md-12">

					<c:forEach var="article" items="${articleList}">

						<dt class="list-group-item row" style="background-color: #e9ebee;">
							<span class="col-md-6">
								${article.notice_title}
								<c:if test="${article.isNew == 0}">
									<span class="badge">new</span>
								</c:if> 
							</span>
							<span class="col-md-2 text-center">${article.notice_member}</span>
							<span class="col-md-4 text-center">${article.notice_date}</span>
						</dt>

						<dd class="list-group-item row">${article.notice_content}</dd>

					</c:forEach>

				</dl>

			</c:if>

		</div>
		
		<div class="col-md-1"></div>

	</div>
	
	<div class="row">
		
		<div class="col-md-12 text-center">
		
			<c:if test="${notice_count > 0}">

				<c:set var="pageCount"
					value="${notice_count / pageSize + ( notice_count % pageSize == 0 ? 0 : 1)}" />
	
				<fmt:parseNumber var="result" value="${currentPage / pageSize}"
					integerOnly="true" />
	
				<c:set var="startPage" value="${result * pageSize + 1}" />
	
				<c:set var="endPage" value="${startPage + pageSize - 1}" />
	
				<c:if test="${endPage > pageCount}">
					<c:set var="endPage" value="${pageCount}" />
				</c:if>
	
				<ul class="pagination pagination-sm">
				
					<c:if test="${startPage > pageSize}">
						<li>
							<a href="/HoneyComb/notice/noticeMore.notice?pageNum=${startPage - pageSize}">이전</a>
						</li>
					</c:if>
				
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<li>
							<a href="/HoneyComb/notice/noticeMore.notice?pageNum=${i}">${i}</a>
						</li>
					</c:forEach>
					
					<c:if test="${endPage < pageCount}">
						<li>
							<a href="/HoneyComb/notice/noticeMore.notice?pageNum=${startPage + pageSize}">다음</a>
						</li>
					</c:if>
				
				</ul>
	
			</c:if>
		
		</div>
		
	</div>

</body>
</html>