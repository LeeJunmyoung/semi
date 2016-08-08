<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/HoneyComb/cloudview/cloudScript.js"  type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body onload="refresh()">
<form action="/HoneyComb/cloud/fileUploader.cloud?folder=${param.folder}"  method="post" enctype="multipart/form-data">
	업로드 파일을 선택해주세요<br>
	<input type="file" name="uploadFile">
	<input type="submit" name="upload" value="업로드">
</form>
</body>
</html>