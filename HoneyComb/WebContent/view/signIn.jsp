<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
<script src="/HoneyComb/view/script.js"  type="text/javascript" ></script>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<!-- /* 이메일인증후 확인 */ -->
<script>
$(function(){
	$('#mailcheck').blur(function(){
		var text = "y"
		if($('#mailtext').val()==text){
		$('#textProp').html("이메일 확인 완료!");
			
		}else{
			$('#textProp').html("이메일 확인 버튼을 눌러주세요");
		}
	});
});
/* 이메일인증후 확인  끝*/

/* 패스워드 일치확인  */
$(function(){
$('#passfunc').keyup(function(){
	if($('#passwd').val() == ""){
		$('#passwdcheck').html("");
		return
	}
	if($('#checkpasswd').val() == ""){
		$('#passwdcheck').html("비밀번호 확인을 해주세요");
		return
	}
	if($('#passwd').val() == $('#checkpasswd').val()){
    $('#passwdcheck').html("비밀번호가 일치합니다");
	
	}else{
		$('#passwdcheck').html("비밀번호가 일치하지않습니다");
	}
	
	});
});
/* 패스워드 일치 확인끝 */







function filter(){
	if($('#phone1').val().length==3){
	
		$('#phone2').focus();
	 
	
	return false;

	}
	if($('#phone2').val().length==4){
		
		$('#phone3').focus();
	 
	
	return false;

	}
}


function filter1(){
	if($('#phone2').val().length==4){
		
		$('#phone3').focus();
	 
	
	return false;

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
#signButton{
width:405;
}
#email{
position:relative;
left:42px;
width:250px;
height:35px;
text-align:center;
}
#mailcheck{
position:relative;
left:50px;
height:30px;
}
#passwd{
position:relative;
left:-3px;
width:250px;
height:35px;
text-align:center;
}
#checkpasswd{
position:relative;
left:-3px;
width:250px;
height:35px;
text-align:center;
}
#name{
position:relative;
left:-3px;
width:250px;
height:35px;
text-align:center;
}

#mailcheck{
position:relative;
top:-2;
width:85px;
height:36px;
}
#phone input{
text-align:center;
width:77px;
height:35px;
}
#signin{
width:250;
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
                <div class="row">
                  <div class="col-md-12 text-center">
                    <h1>HONEYCOMB</h1><p></p><p></p>
            <form name="myform" id="myform"OnSubmit="return checkIt()" action="/HoneyComb/coin/SignInpro.coin" method="post">
	<!-- 이메일 입력창 -->
	
    <input type="text" value="${email}" placeholder="email" name="email" id="email"/>
    <input type="button"  id="mailcheck" class=" btn btn-default" value="Email확인" OnClick="checkmail(this.form)">
    <p id="textProp"></p>
    <input type="hidden" id="mailtext" value="" name="test">
     	
    <!-- 비밀번호 입력창 -->
    <div id="passfunc">
   <input type="password" placeholder="passwd" name="passwd" id="passwd"/><br><br>
   <input type="password" placeholder="checkpasswd" name="checkpasswd" id="checkpasswd"><br>
    <p id="passwdcheck"/>
    </div>
    
   	
    	
    <!-- 전화번호 입력창 -->
    
    <input type="text" placeholder="name" name="name" id="name"/><br><br>
    <div id="phone">
    <input type="text" placeholder="phone1" name="pnum1" maxlength="3" id='phone1' onkeyup='{filter();return false}' onkeypress='javascript:if(event.keyCode==3){ filter(); return false;}' /> - 
       <input type="text" placeholder="phone2" name="pnum2" maxlength="4" id='phone2' onkeyup='{filter1();return false}' onkeypress='javascript:if(event.keyCode==4){ filter1(); return false;}' /> - 
       <input type="text" placeholder="phone3" name="pnum3" maxlength="4" id='phone3' />
    <br><br>
     <button type="submit" class="btn btn-default" name="signin" id="signin">회원가입</button>
</form>
                   </div>
            
                  </div>
                </div>
              </div>
            </div>
          </div>
</body>
</html>