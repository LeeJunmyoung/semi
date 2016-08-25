<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="/HoneyComb/view/script.js"></script> 
  <script>
$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var userInputId = getCookie("userInputId");
    $("input[name='email']").val(userInputId); 
     
    if($("input[name='email']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            var userInputId = $("input[name='email']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("userInputId");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("input[name='email']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("input[name='email']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
function confirmSave(checkbox){
	var isRemeber
	//로그인정보 저장한다고 선택할 경우
	if(checkbox.checked){
		isRemember = confirm("이 PC에 로그인 정보를 저장하시겠습니까? \n\nPC방등의 공공장소에서는 개인정보가 유출될 수 있으니 주의해주십시오.");
		
		if(!isRemember)
			checkbox.checked = false;
	
	}
}
</script>
<style type="text/css">
a:link {text-decoration: none; color: #333333;}
a:visited {text-decoration: none; color: #333333;}
a:active {text-decoration: none; color: #333333;}
a:hover {text-decoration: underline; color: red;}


#home_banner{
width: 100%;
height: 11%;
background: #344d91;
margin: 0;
padding: 0;
}
#logo_wrapper{
position: absolute;
left: 250px;
z-index: 3;
}

#logo_banner{
display: inline;
margin : auto;
width: 100px;
height: 100px;
}
#Honey_comB{
display: inline;

font-size: 38pt;
color:#fff;
vertical-align: middle;
}
#logo_a{
text-decoration: none;
}

.container{
position: absolute;
left: 250px;
padding:0;
}
#col-md-12{
padding:0;
}

</style>

  </head>
  <body>
  <div id = "home_banner">
  <div id = "logo_wrapper">
       <img id="logo_banner" src="/HoneyComb/page_layout/page_image/logo.png" width="100" height="100"onclick="location.href='/HoneyComb/index.jsp'">
 <a id="logo_a" href="/HoneyComb/index.jsp"><p id="Honey_comB" >HONEYCOMB</p></a>
  </div>
  </div>
      <div class="container" style="height:89%; width:80%;">
            <div class="cover">
              <div class="navbar navbar-default" >
              </div>
              <div class="cover-image" style="background-image : url('/HoneyComb/view/img/background.png')" ></div>
             <div class="container" style="width:70%;">
                
                  <div class="col-md-12 text-center" id="col-md-12">
                    <h1>HONEYCOMB</h1>
            <p>로그인페이지</p>
            <form class="form-horizontal text-center" action="/HoneyComb/coin/LogInPro.coin" method="post" onsubmit="return checkEmail()" name="myform">
            
                 <input type="email"  name="email" id="email" placeholder="Email">
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="password" name="passwd" id="passwd" placeholder="Password">
                  <p></p> <p></p>  
                  <div class="checkbox">
                    <label>
                      <input type="checkbox" id="idSaveCheck" onClick="confirmSave(this)">이메일 저장</label>
                      <p></p> <p></p>  
            </div>
              <div id="buttoncheck">
                
                  <button type="submit" class="btn btn-default">Sign in</button><p></p> <p></p>   
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                   <a href="/HoneyComb/view/signIn.jsp">회원가입</a>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/HoneyComb/view/findEmail.jsp">Email</a>&nbsp;/&nbsp; 
                 <a href="/HoneyComb/view/findPasswd.jsp">Passwd 찾기</a>          
              </div>
            </form>
                  
                  </div>
                </div>
              </div>
            </div>
          </div>
</body>
</html>