<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="/HoneyComb/cloudview/cloudScript.js"  type="text/javascript"></script>
<script>
$(document).bind("contextmenu", function(event) { 
    event.preventDefault();
    if($("div.cloud_menu")!= null){
    	$("div.cloud_menu").hide();
    };
    
    $("<div class='cloud_menu'style='position: absolute; z-index:1000;'>"+
    "<a href='javascript:fileUploader()'<p>업로드</p></a>"+
    "<p>다운로드</p>"+
    "<p>공유</p>"+    
    +"</div>")
        .appendTo("body")
        .css({top: event.pageY + "px", left: event.pageX + "px"});
}).bind("click", function(event) {
    $("div.cloud_menu").hide();
});

</script>
<title>Insert title here</title>
</head>
<body>
	<input type="button"name="upload" value="업로드" onclick='return fileUploader()'>
	<input type="button" name="download" value="다운로드">
	<form name="searchform" action="">
		<input type="text" name="search">
		<input type="button" name="searchbutton" value="검색">
	</form>
	<div id="cloudForm">
	<ul>
		<c:forEach items="${cloudList}" var="cloudlist">
				<li style="display: inline;">
					<div style="width: 150px; display: inline-block;">
						<input type="checkbox" value="${cloudlist.file_num}">
						<div>이곳은 파일그림입니다</div>
						
						<div>파일명:${cloudlist.file_name}</div>
						<div>올린사람:${cloudlist.file_uploader}</div>
							<!-- 파일사이즈 byte 로 포맷 -->
							<fmt:parseNumber value="${cloudlist.file_size/1024}" integerOnly="true" var="file_size"/>
						<div>파일 크기:${file_size}byte</div>
						
						<div>올린날짜: ${cloudlist.file_date}</div>
					</div>
				</li>
		</c:forEach>
	</ul>
	</div>
</body>
</html>