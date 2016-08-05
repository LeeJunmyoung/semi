<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<c:if test="${onloadCheck}"> 
<%-- reflash 설정 --%>
	<script>
		window.location.reload(true);
	</script>
</c:if>

<html>
<head>
<title>notice</title>
<script>
    
	function noticeRowView(rowNum) { // 공지 정보 보기
		url = "/semi/notice/noticeContent.notice?num="+rowNum;
		window.open(
						url,
						"post",
						"toolbar=no ,width=550 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no"
					);
	}
	
	function writeView() { // 공지 작성
		url = "/semi/notice/noticeWriteForm.notice";
		window.open(
						url,
						"post",
						"toolbar=no ,width=550 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no"
					);
	}
	
</script>
</head>
<body>

	<b>글목록(전체 글:${count})</b>

	<div align="center">
		<a href="/semi/notice/noticeMore.notice">더보기</a>
		<a onclick="writeView()">공지작성</a>
	</div>

	<c:if test="${count == 0}">
		<table width="700" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">공지 글이 없습니다.</td>
			</tr>
		</table>
	</c:if>

	<c:if test="${count > 0}">
		<table border="1" width="700" cellpadding="0" cellspacing="0">
			<tr height="30">
				<td align="center" width="250">제 목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
			</tr>

			<c:forEach var="article" items="${articleList}">
				<tr height="30" onclick="noticeRowView(${article.notice_num})">
					<td width="250">
					<%-- new 표시 setting --%>
						<c:if test="${article.isNew == 0}">
							<img src="../images/hot.gif">
						</c:if>
						<div align="right">${article.notice_title}</div></td>
					<td align="center" width="100">${article.notice_member}</td>
					<td align="center" width="150">${article.notice_date}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>
