<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>notice more</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>

	$(function() { // list event
		$("dd:not(:first)").css("display", "none");
		$("dl dt").click(function() {
			if ($("+dd", this).css("display") == "none") {
				$(this).siblings("dd").slideUp("slow");
				$("+dd", this).slideDown("slow");
			}
		});
	});
	
</script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

dl {
	width: 400px;
	margin: 50px auto;
}

dl dt {
	background: #7CADB6;
	border-bottom: 1px solid #FFFFFF;
	cursor: pointer;
}

dl dd {
	border: 1px solid #7CADB6;
	border-top: none;
	height: 300px;
}
</style>

</head>
<body>

	<div align="center">

		<b>글목록(전체 글:${notice_count})</b>

		<c:if test="${notice_count == 0}">
			<table width="700" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">공지 글이 없습니다.</td>
				</tr>
			</table>
		</c:if>

		<c:if test="${notice_count > 0}">

			<div>
				<span width="250">제 목</span>
				<span width="100">작성자</span>
				<span width="150">작성일</span>
			</div>

			<div id="container">

				<dl>

					<c:forEach var="article" items="${articleList}">

						<dt>
							<div>
								<span>
									<c:if test="${article.isNew == 0}">
									<%-- new 표시 setting --%>
										<img src="../images/hot.gif">
									</c:if>
									${article.notice_title}
								</span>
								<span>${article.notice_member}</span>
								<span>${article.notice_date}</span>
							</div>
						</dt>

						<dd>
							<div>
								<span>작성자</span>
								<span>${article.notice_member}</span>
								<span>작성일</span>
								<span>${article.notice_date}</span>
							</div>
							<div>
								<span>글제목</span>
								<span>${article.notice_title}</span>
							</div>
							<div>
								<span>글내용</span>
								<span>${article.notice_content}</span>
							</div>
						</dd>

					</c:forEach>

				</dl>

			</div>

		</c:if>

		<c:if test="${notice_count > 0}">

			<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />

			<fmt:parseNumber var="result" value="${currentPage / pageSize}" integerOnly="true" />

			<c:set var="startPage" value="${result * pageSize + 1}" />

			<c:set var="endPage" value="${startPage + pageSize - 1}" />

			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>

			<c:if test="${startPage > pageSize}">
				<a
					href="/HoneyComb/notice/noticeMore.notice?pageNum=${startPage - pageSize}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/HoneyComb/notice/noticeMore.notice?pageNum=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount}">
				<a href="/HoneyComb/notice/noticeMore.notice?pageNum=${startPage + pageSize}">[다음]</a>
			</c:if>

		</c:if>

	</div>

</body>
</html>