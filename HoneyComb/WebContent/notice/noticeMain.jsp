<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
<title>notice</title>
<script>
    
	function noticeRowView(rowNum) { // 공지 정보 보기
		url = "/HoneyComb/notice/noticeContent.notice?num="+rowNum;
		window.open(
						url,
						"post",
						"toolbar=no ,width=550 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no"
					);
	}
	
</script>
</head>
<body >
<div width="400" height="150">
	<b>글목록(전체 글:${notice_count})</b>

	<div align="right">
		<a href="/HoneyComb/notice/noticeMore.notice">더보기</a>
	</div>

	<c:if test="${notice_count == 0}">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">공지 글이 없습니다.</td>
			</tr>
		</table>
	</c:if>

	<c:if test="${notice_count > 0}">
		<table border="1"  cellpadding="0" cellspacing="0" id="notice_table">
			<tr >
				<td align="center" >제 목</td>
				<td align="center" >작성자</td>
				<td align="center" >작성일</td>
			</tr>

			<c:forEach var="article" items="${articleList}">
				<tr  onclick="noticeRowView(${article.notice_num})">
					<td>
					<%-- new 표시 setting --%>
						<c:if test="${article.isNew == 0}">
							<img src="../images/hot.gif">
						</c:if>
						<div align="right">${article.notice_title}</div></td>
					<td align="center" >${article.notice_member}</td>
					<td align="center" >${article.notice_date}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>
</body>
</html>
