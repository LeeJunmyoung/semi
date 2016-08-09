<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>proMgr more</title>
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

		<b>프로젝트 목록(전체 프로젝트:${count})</b>

		<c:if test="${count == 0}">
			<div align="center">프로젝트가 없습니다.</div>
		</c:if>

		<c:if test="${count > 0}">

			<div>
				<span width="250">프로젝트 명 : </span> <span width="100">(프로젝트 명)</span>
			</div>

			<div id="container">

				<dl>

					<!-- 프로젝트 전체 리스트 -->
					<c:forEach var="article" items="${articleList}">

						<dt>
							<div>
								<span>(프로젝트 명)</span>
							</div>
						</dt>

						<dd>
							<div>참여자 : (참여자 명단)</div>
							<div>시작일 : (프로젝트 생성 일)</div>
							<div>내용 : (프로젝트 내용)</div>
							<div>진행 상황 항목 : (checklist 기능)</div>
							<div>comment : (댓글 달기 기능)</div>
						</dd>

					</c:forEach>

				</dl>

				<div id="editor">
					<input type="button" value="member" /> <input type="button"
						value="checklist" /> <input type="button" value="file" />
				</div>

				<div id="commentFrom">(comment 기능)</div>

			</div>

		</c:if>

		<c:if test="${count > 0}">

			<c:set var="pageCount"
				value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />

			<fmt:parseNumber var="result" value="${currentPage / pageSize}"
				integerOnly="true" />

			<c:set var="startPage" value="${result * pageSize + 1}" />

			<c:set var="endPage" value="${startPage + pageSize - 1}" />

			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>

			<c:if test="${startPage > pageSize}">
				<a
					href="/HoneyComb/proMgr/proMgrMore.pro?pageNum=${startPage - pageSize}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/HoneyComb/proMgr/proMgrMore.pro?pageNum=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount}">
				<a
					href="/HoneyComb/proMgr/proMgrMore.pro?pageNum=${startPage + pageSize}">[다음]</a>
			</c:if>

		</c:if>

	</div>

</body>
</html>