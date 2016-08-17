 <%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="/HoneyComb/cloudview/cloudScript.js"  type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	
$(document).bind("contextmenu", function(event) { 
    event.preventDefault();
    var data;
    var checkboxck = "input[name=itemBox]:checked";
    
     $('li').contextmenu(function(){
		/* alert("thisindex::"+$('li').index(this)); */
		/* $("li:eq("+index+")").find("input:checkbox[name=itemBox]").prop("checked",true);  */
		var index = $('li').index(this);
			  $("input:checkbox[name=itemBox]").prop("checked",false);  
			$(this).find("input:checkbox[name=itemBox]").prop("checked",true); 
			
    }); 
    
    if(!$("input[name=itemBox]:checked").length == 0){
    	var file_path = $(checkboxck).data('file_path');
    	if(file_path == ""){
    		$('#fileonly').css("display","hidden");
    	};
    	
	};   
    
	
    if($("div.cloud_menu")!= null){
    	$("div.cloud_menu").hide();
    };
	if($(checkboxck).data('file_path') ==""){
    $("<div class='cloud_menu'style='position: absolute; z-index:1000;'>"+
    "<a href="+"javascript:fileUploader('${param.folder}')"+"><p>업로드</p></a>"+
    "<a href = "+"javascript:createfolder('${param.folder}')"+"><p>폴더 만들기</p></a>"+
    "<a href ="+"javascript:deleteitem('${param.folder}')"+"><p>삭제</p> </a>"+
    "<p>공유</p>"+    
    +"</div>")
    .appendTo("div.cloudForm")
    .css({top: event.pageY + "px", left: event.pageX + "px"});
	}
    $("<div class='cloud_menu'style='position: absolute; z-index:1000;'>"+
	    "<a href="+"javascript:fileUploader('${param.folder}')"+"><p>업로드</p></a>"+
	    "<a href='javascript:download()' id='fileonly'><p >다운로드</p></a>"+
	    "<a href = "+"javascript:createfolder('${param.folder}')"+"><p>폴더 만들기</p></a>"+
	    "<a href ="+"javascript:deleteitem('${param.folder}')"+"><p>삭제</p> </a>"+
	    "<p>공유</p>"+    
	    +"</div>")
	    .appendTo("div.cloudForm")
	    .css({top: event.pageY + "px", left: event.pageX + "px"});
    
    
	
        
	
}).bind("click", function(event) {
    $("div.cloud_menu").hide(); 
});
	
	 $('#download').click(function(){
		alert("test");
		var itemBox = document.getElementsByName("itemBox");
		if($("input[name=itemBox]:checked").length == 0){
			alert("false");
			return false;
		}
		$("input[name=itemBox]:checked").each(function(){
			var file_name = $(this).data('file_name');
			var file_path = $(this).data('file_path');
			alert(file_name)
			var url="/HoneyComb/cloud/cloudDownItem.cloud?file_name="+file_name+"&file_path="+file_path;
			$(location).attr('href',url);
		});
	})
	//중복체크 제거
	$('li').change(function(){
		var index = $('li').index(this);
		  $("input:checkbox[name=itemBox]").prop("checked",false);  
		$(this).find("input:checkbox[name=itemBox]").prop("checked",true); 
	});
		 
	 

});
</script>
<title>Insert title here</title>
<style type="text/css">
div.file{
width=200px;
text-align: center;}

</style>
</head>
<body>

	<input type="button"name="upload" value="업로드" onclick="return fileUploader('${param.folder}')">
	<input type="button" name="download" value="다운로드" onclick="download()">
	<input type="button" name="searchbutton" value="삭제" onclick="deleteitem('${param.folder}')">
	<form name="searchform" action="">
		<input type="text" name="search">
		<input type="button" name="searchbutton" value="검색">
	</form>
	<div class="cloudForm">
	<ul>
		<c:forEach items="${cloudList}" var="cloudlist">
				<li style="display: inline;">
					<div style="width: 150px; display: inline-block;"id="test">
					<input type="checkbox" id="${cloudlist.file_num}" name="itemBox" data-file_name="${cloudlist.file_name}" data-file_path="${cloudlist.file_path}">
						<label for="${cloudlist.file_num}">
						<c:choose>	
						<c:when test="${fn:substring(cloudlist.file_path,fn:length(cloudlist.file_path)-1,fn:length(cloudlist.file_path))!=''}">

						
						<div class="file"><img src="../images/file.png" width="150px"></div>
						</c:when>
						<c:otherwise>
						<div style="width: 150px; display: inline-block;" ondblclick="movefolder('${param.folder}','${cloudlist.file_name}')">
						
						<div class="file"><img src="../images/folder.png" width="150px"></div>
						</c:otherwise>
						</c:choose>
						<div class="file">${cloudlist.file_name}</div>
						<div class="file">${cloudlist.file_uploader}</div>
							<!-- 파일사이즈 byte 로 포맷 -->
							<fmt:parseNumber value="${cloudlist.file_size/1024}" integerOnly="true" var="file_size"/>
						<div class="file">파일 크기:${file_size}byte</div>
		
						<div class="file">${cloudlist.file_date}</div>						
						
						</label>
					</div>
				</li>
				
		</c:forEach>
	</ul>
	</div>
</body>
</html>