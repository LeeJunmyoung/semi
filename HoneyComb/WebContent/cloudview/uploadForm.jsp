<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/HoneyComb/cloudview/cloudScript.js"  type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
 $(function(){
	if(	$('#filecheck').val() != ""){
		alert("'"+'${param.filecheck}'+"'"+"은 이미 있는 파일입니다. 다른 파일명을 입력해 주세요");
	}
})
</script>
<title>Insert title here</title>
</head>
<body onload="refresh()">
<form  action="/HoneyComb/cloud/fileUploader.cloud?folder=${param.folder}"  method="post" enctype="multipart/form-data" id="myform" onsubmit="check()">
	업로드 파일을 선택해주세요<br>
	<input type="hidden" value="${param.filecheck}" id="filecheck">
	<input type="file" name="uploadFile"><br>
	파일이름:
	<input type="text" name="file_name" id="test"><br>
	
	<input type="submit" name="upload" value="업로드">
</form>
</body>
</html>