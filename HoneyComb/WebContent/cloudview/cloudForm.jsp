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
			$('#img.file').css("border","1px solid silver")
			$(this).find('div#img.file').css("border","3px solid silver");
			
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
    +"</div>")
    .appendTo("body")
    .css({top: event.pageY + "px", left: event.pageX + "px"});
	}else{
    $("<div class='cloud_menu' style='position: absolute; z-index:1000;'>"+
	    "<a href="+"javascript:fileUploader('${param.folder}')"+"><p>업로드</p></a>"+
	    "<a href='javascript:download()' id='fileonly'><p >다운로드</p></a>"+
	    "<a href = "+"javascript:createfolder('${param.folder}')"+"><p>폴더 만들기</p></a>"+
	    "<a href ="+"javascript:deleteitem('${param.folder}')"+"><p>삭제</p> </a>"+
	    +"</div>")
	    .appendTo("body")
	    .css({top: event.pageY + "px", left: event.pageX + "px"});
};
	
    
	
        
	
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
		$('#img.file').css("border","1px solid silver")
		$(this).find('div#img.file').css("border","3px solid silver");
		
		
	});
	 
	 
	
});

</script>
<title>Insert title here</title>
<style type="text/css">
/* 상단 버튼 수정 */
.indexbutton{
position:static;
color:black;
width:70px;
height: 30px;
background-color: #F8F8F8 ;	
border: 1px solid silver;
margin: 5px 0px;
text-align: center;
}
.indexbutton:HOVER{
background-color: silver;
}
/* 상단 버튼 수정 끝 */

/* 폼 박스 수정 */
div.file{

text-align: center;
margin: auto;
}
div#item.item{
width: 170px;
display: inline-block;
padding: 10px;
}

div#img{
width: 150px;
height: 150px;
padding: 15px;
border: 1px solid silver;
margin: auto;

}
div.item img{
width: 75px;
margin-top: 25%;
}
/* 폼박스_체크박스 수정 */
input[type=checkbox]{
display: none;
}   
/* 우클릭박스 수정 */
div.cloud_menu{
background-color: white;
border: 2px solid #F8F8F8;
}
div.cloud_menu a{
text-decoration: none;
color: black;
}
div.cloud_menu p{
margin: 0px;
}
div.cloud_menu p:HOVER {
background-color: silver;
}
/* 우클릭 박스 수정끝 */

</style>
</head>
<body>
mem_num = ${mem_num}<br>	
<div class="indexbox">
	<input type="button"name="upload" value="업로드" onclick="return fileUploader('${param.folder}')" class="indexbutton">
	<input type="button" name="download" value="다운로드" onclick="download()"class="indexbutton">
	<input type="button" name="searchbutton" value="삭제" onclick="deleteitem('${param.folder}')" class="indexbutton">
</div>
	<form name="searchform" action="">
		<input type="text" name="search">
		<input type="button" name="searchbutton" value="검색">
	</form>
	<div class="cloudForm">
	<ul>
		<c:forEach items="${cloudList}" var="cloudlist">
		<div class="item" id="item">
				<li style="display: inline;">
					
					<input type="checkbox" id="${cloudlist.file_num}" name="itemBox" data-file_name="${cloudlist.file_name}" data-file_path="${cloudlist.file_path}" data-file_num="${cloudlist.file_num}">
						<label for="${cloudlist.file_num}">
						<c:choose>	
						<c:when test="${fn:substring(cloudlist.file_path,fn:length(cloudlist.file_path)-1,fn:length(cloudlist.file_path))!=''}">
						<%-- mem_num = ${cloudlist.mem_num} --%>
						<c:set var="fileName" value="${fn:split(cloudlist.file_name, '.')}" />
						<div class="file" id="img"><img src="../images/${fileName[fn:length(fileName)-1]}.png" onError="this.src='../images/file.png'"></div>
						</c:when>
						<c:otherwise>
						<div style="width: 150px; display: inline-block;" ondblclick="movefolder('${param.folder}','${cloudlist.file_name}')">
						
						<div class="file" id="img"><img src="../images/folder.png"></div>
						</c:otherwise>
						</c:choose>
						<div class="file">${cloudlist.file_name}</div>
						<div class="file">${cloudlist.file_uploader}</div>
							<!-- 파일사이즈 byte 로 포맷 -->
							<fmt:parseNumber value="${cloudlist.file_size/1024}" integerOnly="true" var="file_size"/>
						<div class="file">파일 크기:${file_size}byte</div>
		
						<div class="file">${cloudlist.file_date}</div>						
						
						</label>
					
				</li>
				</div>
		</c:forEach>
	</ul>
	</div>
</body>
</html>