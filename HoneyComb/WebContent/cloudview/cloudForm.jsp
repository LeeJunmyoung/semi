<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/HoneyComb/cloudview/cloudScript.js"  type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<input type="button"name="upload" value="업로드" onclick='return fileUploader()'>
	<input type="button" name="download" value="다운로드">
	<form name="searchform" action="">
		<input type="text" name="search">
		<input type="button" name="searchbutton" value="검색">
	</form>
	<ul>
		<c:forEach items="${cloudList}" var="cloudlist">
				<li style="display: inline;">
					<div style="width: 150px; display: inline-block;">
						<input type="checkbox" value="${cloudlist.file_num}">
						<div>이곳은 파일그림입니다</div>
						
						<div>올린사람:${cloudlist.file_name}</div>
							<!-- 파일사이즈 byte 로 포맷 -->
							<fmt:parseNumber value="${cloudlist.file_size/1024}" integerOnly="true" var="file_size"/>
						<div>파일 크기:${file_size}byte</div>
						
						<div>올린날짜: ${cloudlist.file_date}</div>
					</div>
				</li>
		</c:forEach>
	</ul>
	
</body>
</html>