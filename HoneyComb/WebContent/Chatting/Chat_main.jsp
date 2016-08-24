<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<head>
<title>Insert title here</title>
<style type="text/css">
.total_box {
	
	position:relative;
	top:50px;

	width: 90%;
	margin: auto;
	height: 800px;
	border-collapse: collapse;
}

.box1_select_chat {
	float: left;
	width: 300px;
	height: 800px;
	border: 1px solid #CCCCCC;
}

.box2_execute_chat {
	display: inline-block;
	width: 62.5%;
	height: 800px;
	border: 1px solid #CCCCCC;
	padding: 0px;
	margin: 0px;
}

#form1 {
	display: inline;
	width: 300px;
	height: 58px;
}

#form1 div {
	width: 300px;
	height: 58px;
}
</style>
<style type="text/css">
input#chat {
position:relative;
	width: 500px;
	top:20px;
}

#console-container {
	width: 500px;
	margin: auto;
}

#console {
position:relative;
top:20px;
	border: 1px solid #CCCCCC;
	border-right-color: #999999;
	border-bottom-color: #999999;
	height: 700px;
	overflow-y: scroll;
	padding: 5px;
	width: 100%;
}

#console #receive {
	margin: 10px;
	position: relative;
	width: 150px;
	padding: 5px;
	background: #C7FFFF;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
}

#console #me {
	margin: 20px;
	position: relative;
	left: 200px;
	width: 150px;
	padding: 5px;
	background: #FAF4C0;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	text-align: center;
}

#console #name {
	margin: 10px;
	position: relative;
	padding: 5px;
}

#console #sys {
	margin: 10px;
	position: relative;
	text-align: center;
	padding: 5px;
}

#chat_mem_div{
width: 298px;
height: 58px;
}


.memmem {
	border-color: #fff;
	background-color: #fff;
	width:298px;
	height: 58px;
	border: 0;
	border-top: 1px solid #efefef;
	border-bottom: 1px solid #efefef;
	position: relative;
}

.memname_chat {
	position: relative;
	left: 80px;
	top: -53px;
	z-index: 1;
	font-size: 15px;
	width: 230px;
	height: 20px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: clip;
}

.sendCheckImg {
	width: 50px;
	height: 50px;
	position: relative;
	top: -97px;
	z-index: -3;
}


.visibleImg{
width: 50px;
height:50px;
position:relative;
top:-87px;
z-index: 3;
}

.myProfilePicture{
width: 50px;
height: 50px;
position: relative;
z-index: 2;
top:-83px;
left: 3px;
margin: 0px;
}

img:nth-of-type(2) {

left:-53px;

}

#search_div{
position: relative;
top:20px;
left:20px;
}

#add_member{
border: 0px;
background: #344d91;
color:#fff;
}



</style>


<script src='/HoneyComb/Calendar/fullcalendar/lib/jquery.min.js'></script>

<script type="text/javascript">
	function invite_Member() {
		var url = "/HoneyComb/Chatting/Invite_form.chat";
		open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"
				+ "scrollbars=no,resizable=no,width=550,height=400");

	}

	$(document).ready(function() {
		$("p").click(function() {
			var c = 'form' + $(this).attr("id");

			$('form.' + c).submit();
		});

		$("p").mouseenter(function() {
			var c = "submit" + $(this).attr("id");
			$('#' + c).css('border', '1px solid');

			$('#' + c).css('border-color', '#344d91');

		});
		$("p").mouseleave(function() {
			var c = "submit" + $(this).attr("id");
			$('#' + c).css('border', '0');
			$('#' + c).css('border-color', '#fff');
			$('#' + c).css('border-top', '1px solid #efefef');
			$('#' + c).css('border-bottom', '1px solid #efefef');
		});

		$(".memmem").mouseenter(function() {

			$(this).css('border', '1px solid');
			$(this).css('border-color', '#344d91');

		});
		$(".memmem").mouseleave(function() {

			$(this).css('border', '0');
			$(this).css('border-color', '#fff');
			$(this).css('border-top', '1px solid #efefef');
			$(this).css('border-bottom', '1px solid #efefef');
		});
		
		
		
	});
</script>


<script type="application/javascript">
	
function new_msg(num){
	
	
	$('#img_new'+num).css('z-index','3');
	
	
}

			
	
			var chat_Num = '${chat_Num}';
			var chat_mem_name = '${chat_mem_name}';
			var chat_Member_Participation = '${chat_Member_Participation}';
			var chat_partner = '${chat_partner}';
		 	var my_Name = '${name}'
		//	 alert("chat_Num :::::: "+chat_Num+"   chat_mem_name:::::: "+chat_mem_name+" chat_Member_Participation :::::: "+chat_Member_Participation+" chat_partner :::::: "+chat_partner)

			
			var mem_num = '${mem_num}';
				
			
	        var Chat = {};
	
	        Chat.socket = null;
	
	        // connect() 함수 정의
	        Chat.connect = (function(host) {
	            // 서버에 접속시도
	            if ('WebSocket' in window) {
	                Chat.socket = new WebSocket(host);
	            } else if ('MozWebSocket' in window) {
	                Chat.socket = new MozWebSocket(host);
	            } else {
	                Console.sys('Error: WebSocket is not supported by this browser.');
	                return;
	            }
	
	             // 서버에 접속이 되면 호출되는 콜백함수
	            Chat.socket.onopen = function () {
	           //     Console.sys("알림 : " +chat_partner +" 님과 연결되었습니다. ");
	                // 채팅입력창에 메시지를 입력하기 위해 키를 누르면 호출되는 콜백함수
	                document.getElementById('chat').onkeydown = function(event) {
	                    // 엔터키가 눌린 경우, 서버로 메시지를 전송함
	                    if (event.keyCode == 13) {
	                    	 var message = document.getElementById('chat').value.replace(/^\s+|\s+$/g,"");
	                    
		                        if(message != ''){
		                        Console.me(message);
		                        }
	                        Chat.sendMessage();
	                        
	                       
	                    }
	                };
	            };
				
	            // 연결이 끊어진 경우에 호출되는 콜백함수
	            Chat.socket.onclose = function () {
	            	// 채팅 입력창 이벤트를 제거함
	                document.getElementById('chat').onkeydown = null;
	                 Console.sys('Info: WebSocket closed.');
	            };
				
	            // 서버로부터 메시지를 받은 경우에 호출되는 콜백함수
	            Chat.socket.onmessage = function (message) {
	            	// 수신된 메시지를 화면에 출력함
	                Console.log(message.data); 
	            };
	        });
	     	// connect() 함수 정의 끝
	     	
	     	// 위에서 정의한 connect() 함수를 호출하여 접속을 시도함
	        Chat.initialize = function() {
	            if (window.location.protocol == 'http:') {
	                //Chat.connect('ws://' + window.location.host + '/websocket/chat');
	            	Chat.connect('ws://192.168.123.105:8888/HoneyComb/websocket/Chatting?mem_name='+mem_num+'&receiver=99999&chat_Num=99999&my_name=defult');
	            } else {
	                Chat.connect('wss://' + window.location.host + '/websocket/Chatting?mem_name='+mem_num+'&receiver=99999&chat_Num=99999&my_name=defult');
	            }
	        };
	
	        // 서버로 메시지를 전송하고 입력창에서 메시지를 제거함
	        Chat.sendMessage = (function() {
	            var message = document.getElementById('chat').value;
	            if (message != '') {
	                Chat.socket.send(message);
	                document.getElementById('chat').value = '';
	            }
	        });
	
	        var Console = {}; // 화면에 메시지를 출력하기 위한 객체 생성
	
	        // log() 함수 정의
	        Console.log = (function(message) {
	            var console = document.getElementById('console');
	            
	            var p = document.createElement('p');
	            p.id = 'receive';
	            p.style.wordWrap = 'break-word';
	            p.innerHTML = message;
	            
	            
	            var name = document.createElement('p');
	            var receiveName = chat_mem_name;
	            
	            name.id='name';
	            name.innerHTML = receiveName;
	
	            
	            var strArray = message.split('::');
	            
	            
	            var sysmsg='its message is deffrent user message';
	            var multimsg ='its message is multiMsg';
	            if(strArray[0] == sysmsg){
	            
	            	var num= strArray[1];
	            	new_msg(num);
	            }else if(strArray[0] == multimsg){
	            	name.innerHTML = strArray[1];
	            	p.innerHTML =strArray[2];
	            	console.appendChild(name);
	            	console.appendChild(p);
	            	
	            }else{
	            
	            	
	            	
	                console.appendChild(name);
	            	console.appendChild(p);
	            }
	            // 전달된 메시지를 하단에 추가함
	            // 추가된 메시지가 25개를 초과하면 가장 먼저 추가된 메시지를 한개 삭제함
	          /*   while (console.childNodes.length > 25) {
	                console.removeChild(console.firstChild);
	            } */
	            // 스크롤을 최상단에 있도록 설정함
	            console.scrollTop = console.scrollHeight;
	        });
	        
	        
	        Console.me = (function(message) {
	            var console = document.getElementById('console');
	           
	            var p = document.createElement('p');
	            
	           
	            p.id = 'me';
	            p.style.wordWrap = 'break-word';
	           
	            p.innerHTML = message;
	           
	            console.appendChild(p); // 전달된 메시지를 하단에 추가함
	            // 추가된 메시지가 25개를 초과하면 가장 먼저 추가된 메시지를 한개 삭제함
	           /*  while (console.childNodes.length > 25) {
	                console.removeChild(console.firstChild);
	            } */
	            // 스크롤을 최상단에 있도록 설정함
	            console.scrollTop = console.scrollHeight;
	        });
	        Console.sys = (function(message) {
	            var console = document.getElementById('console');
	           
	            var sys = document.createElement('p');
	            
	           
	            sys.id = 'sys';
	            sys.style.wordWrap = 'break-word';
	           
	            sys.innerHTML = message;
	           
	            console.appendChild(sys); // 전달된 메시지를 하단에 추가함
	            // 추가된 메시지가 25개를 초과하면 가장 먼저 추가된 메시지를 한개 삭제함
	            /* while (console.childNodes.length > 25) {
	                console.removeChild(console.firstChild);
	            } */
	            // 스크롤을 최상단에 있도록 설정함
	            console.scrollTop = console.scrollHeight;
	        });
	        
	        
	
	        // 위에 정의된 함수(접속시도)를 호출함
	        Chat.initialize();


	    


</script>




<script type="text/javascript">
	function filter() {
		if ($('#search_name').val() == "") {
			$("#form1 div").css('display', '');

		} else {
			/* 		$("#form1 input").css('display','none');
			 $(".memname_chat").hide(); */
			$('#form1 div').css('display', 'none');
			$("#form1 div[class*='" + $('#search_name').val() + "']").css(
					'display', '');
		}
		return false;
	}
</script>

</head>
<body>

	<div class='total_box'>
		<div class='box1_select_chat'>
		<div id = "search_div">
			<input type="button" value="+" onclick="invite_Member()" id="add_member"> <input
				type="text" placeholder="name" id='search_name'
				onkeyup='{filter();return false}'
				onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}'>
		</div>		
				
			<br> <br>

			<c:forEach var="chat_list" items="${current_chat_list}">
				<form method="post"
					action="/HoneyComb/Chatting/Chat_Select_OneNone.chat"
					class='form${chat_list.chat_Num }' id='form1'>
					<input type="hidden" name="chat_Num" id="chat_Num"
						value="${chat_list.chat_Num}"> <input type="hidden"
						name="chat_mem_name" id="chat_mem_name"
						value="${chat_list.chat_mem_name}"> <input type="hidden"
						name="chat_Member_Participation" id="chat_Member_Participation"
						value="${chat_list.chat_Member_Participation }"> <input
						type="hidden" name="last_Chat_Date" id="last_Chat_Date"
						value="${chat_list.last_Chat_Date }"> <input type="hidden"
						name="last_Chat_Conversation" id="last_Chat_Conversation"
						value="${chat_list.last_Chat_Conversation}"> <input
						type="hidden" name="chat_partner" id="chat_partner"
						value="${chat_list.chat_partner } ">
						<input type="hidden" name="chat_partner" id="chat_partner"
						value="${chat_list.chat_partner}"> 



					<div class='${chat_list.chat_partner }' id = "chat_mem_div"> 
						<input type="submit" value=" " id="submit${chat_list.chat_Num}"
							class='memmem'>
						<p class='memname_chat' id='${chat_list.chat_Num}'>${chat_list.chat_partner }
						</p>
						
						
						
						
						<c:set var="temp_check"  value="0"/>
						<c:forTokens items="${chat_list.last_Chat_Member }" delims="," var="last_Chat_Member">
							<c:if test="${chat_list.last_Chat_Read == 'f' }">
								<c:if test="${ mem_num == last_Chat_Member }">
								<c:set var="temp_check"  value="1"/>
								</c:if>
							</c:if>
						</c:forTokens>
						<c:if test="${chat_list.last_Chat_Read == 'f' }">
						<c:if test="${temp_check != 1 }">
						<img src="/HoneyComb/Chatting/chat_image/new.gif" class = 'visibleImg' />
						</c:if>
						</c:if>
							<img src="${ chat_list.profile_IMG }"  onerror="this.src='/HoneyComb/images/user.png'" title="내 프로필 사진" class = 'myProfilePicture'>
				
			
							
						<img src="/HoneyComb/Chatting/chat_image/new.gif"
							id='img_new${chat_list.chat_Num }' class='sendCheckImg'  />
					</div>
				</form>

			</c:forEach>


		</div>

		<div class='box2_execute_chat'>


			<div>

				<div id="console-container">




					<div id="console">
					
					
						<c:forEach items='${before_chat_record}' var="before_chat">

							<c:if test="${before_chat.chat_User eq mem_num}">
								<p id="me">${before_chat.chat_Conversation }</p>
							</c:if>

							<c:if
								test="${before_chat.chat_User eq chat_Member_Participation }">
								<p id="receive">${before_chat.chat_Conversation }</p>
							</c:if>
							<c:forTokens var="token" items="${chat_Member_Participation}" delims=",">
							
							<c:if
								test="${before_chat.chat_User eq token }">
								
								<p>${before_chat.chat_User_Name}</p>
								
								<p id="receive">${before_chat.chat_Conversation }</p>
							</c:if>
							
							</c:forTokens>

						</c:forEach>






					</div>
					<input type="text" placeholder="type and press enter to chat"
						id="chat"  readonly="readonly" disabled="disabled"/>
				</div>

				<p></p>
			</div>

		</div>


	</div>


</body>
</html>