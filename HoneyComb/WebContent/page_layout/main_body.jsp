<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href="/HoneyComb/page_layout/home.css" rel="stylesheet" type="text/css" />
<body>

<div id = "main_notice">
 <jsp:include page="/notice/noticeMain.jsp"></jsp:include>
</div>
<div id = "main_project_manage">

</div>
<div id = "main_cal">
<jsp:include page="/Calendar/cal_user_main.jsp"></jsp:include>
</div>
<!-- POPUP --> 
<div id="divpop" style="position:absolute;left:395px;top:190px;z-index:200;visibility:hidden;"> 
<table width=300 height=400 cellpadding=2 cellspacing=0> 
<tr> 
    <td style="border:1px #666666 solid" height=360 align=center bgcolor=white> 
    공지사하아아아아아아아아아아아앙!
    </td> 
</tr> 
<tr> 
        <form name="notice_form"> 
    <td align=right bgcolor=white> 
        <input type="checkbox" name="chkbox" value="checkbox">오늘 하루 이 창을 열지 않음 
        <a href="javascript:closeWin();"><B>[닫기]</B></a> 
    </td> 
</tr> 
        </form> 
</table> 
</div> 
<script language="Javascript"> 
cookiedata = document.cookie;    
if ( cookiedata.indexOf("maindiv=done") < 0 ){      
    document.all['divpop'].style.visibility = "visible"; 
    } 
    else { 
        document.all['divpop'].style.visibility = "hidden"; 
} 
</script>
</html>


