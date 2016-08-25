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
		var url = '/HoneyComb/cloudview/changeFilename.jsp?dupli=y&promgr_num= ${param.promgr_num}';
		$(location).attr('href',url);
	}
	 if($('#uploadcheck').val() == 'done'){
		window.close();
	
	}  
 	 var fileTarget = $('.file_upload .upload_hidden');

 	  fileTarget.on('change', function(){  // 값이 변경되면
 	    if(window.FileReader){  // modern browser
 	      var filename = $(this)[0].files[0].name;
 	    }
 	    
 	    // 추출한 파일명 삽입
 	    $(this).siblings('.upload_name').val(filename);
 	  });
	
})
</script>
<style type="text/css">
body{
text-align:  center;
background-color: #E9EBEE;
}
/* 기본버튼설정 */
.indexbutton{
position:static;
color:black;
width:70px;
height: 30px;
background-color: #F8F8F8 ;	
border: 1px solid silver;
margin: 5px 0px;
text-align: center;
cursor: pointer;
}
.indexbutton:HOVER{
background-color: silver;
}
/* 기본버튼설정 끝 */
/* 업로드폼 설정 */
.upload_hidden{
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip:rect(0,0,0,0);
  border: 0;
}
.choosefile{
display: inline-block;
color:black;
width:70px;
height: 25px;
background-color: #F8F8F8 ;	
border: 1px solid silver;
cursor:pointer;
margin: -6px;
}
.choosefile:HOVER {
background-color: silver;
}
.upload_name{
height: 21px;
display: inline-block;
}
/* 업로드폼 설정 끝 */
}
</style>
<title>Insert title here</title>
</head>
<body onload="refresh()">
<form  action="/HoneyComb/cloud/fileUploader.cloud?folder=${param.folder}"  name="uploadform" enctype="multipart/form-data" method="post" onsubmit="return emptyck('uploadfile')">
	<div class="text">
	<h3>업로드 파일을 선택해주세요</h3>
	</div>
	
	<input type="hidden" value="${param.filecheck}" id="filecheck">
	<input type="hidden" value="${param.upload}" id="uploadcheck">
	<input type="hidden" value="${param.promgr_num}" name="promgr_num">
	
	<div class="file_upload">
	<input disabled="disabled" class="upload_name">
		
		<label for="uploadfile">
		<div class="choosefile" >파일선택</div>
		</label>
		
	<input type="file" name="uploadFile" name="uploadfile" id="uploadfile" class="upload_hidden">
	</div>
	
	<div>
	<p>변경할 파일 이름을 입력해 주세요</p>
	<input type="text" name="filename">
	</div>
	<input type="submit" name="upload" value="업로드" id="button" class="indexbutton">

</form>
</body>
</html>