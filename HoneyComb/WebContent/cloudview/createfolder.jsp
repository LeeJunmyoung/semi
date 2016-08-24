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
<style type="text/css">
body{
text-align:  center;
background-color: #E9EBEE;
}
/* 기본버튼설정 */
.indexbutton{


color:black;
width:70px;
height: 30px;
background-color: #F8F8F8 ;	
border: 1px solid silver;
text-align: center;
cursor: pointer;
margin-left: -6px;
}
.indexbutton:HOVER{
background-color: silver;
border: 1px solid silver;
}
/* 기본버튼설정 끝 */
/* 텍스트 기본설정 */
.foldertext{
height: 23px;
padding-top: 3px;
}
/* 텍스트 기본설정 끝 */
</style>

<title>Insert title here</title>
</head>
<body onload="refresh()">
<form action="/HoneyComb/cloud/createFolder.cloud" method="post" onsubmit="return emptyck('foldername')" class="foldertext">
<h3>
생성할 폴더 이름을 입력해 주세요
</h3>
<div>
	<input type="text" name="foldername" class="foldertext">
	<input type="submit" value="폴더 생성" class="indexbutton">
	<input type="hidden" value="${param.uploadcheck}" id="uploadcheck">
	<input type="hidden" value="${param.name}" id="foldercheck">
	<input type="hidden" value="${param.folder}" name="folder">
	com_Num:${com_num}
	
</div>
</form>
</body>
</html>