<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/HoneyComb/cloudview/cloudScript.js"  type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body onload="refresh()">
<form action="/HoneyComb/cloud/createFolder.cloud" method="post">
폴더:${param.folder}
<input type="text" name="foldername">
<input type="hidden" value="${param.folder}" name="folder">
<input type="submit" value="폴더 생성">
</form>
</body>
</html>