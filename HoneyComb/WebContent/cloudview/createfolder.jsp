<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/HoneyComb/cloudview/cloudScript.js"  type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script>
 $(function(){
	if(	$('#foldercheck').val() != ""){
		alert("'"+'${param.name}'+"'"+"은 이미 있는 폴더입니다. 다른 폴더명을 입력해 주세요");
	}
})
</script>

<title>Insert title here</title>
</head>
<body onload="refresh()">
<form action="/HoneyComb/cloud/createFolder.cloud" method="post">
<input type="text" name="foldername">
<input type="hidden" value="${param.name}" id="foldercheck">
<input type="hidden" value="${param.folder}" name="folder">
<input type="submit" value="폴더 생성">
</form>
</body>
</html>