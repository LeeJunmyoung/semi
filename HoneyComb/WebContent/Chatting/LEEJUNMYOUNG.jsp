<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LEEJUNMYOUNG 계정입니다.</title>
<style type="text/css">
input#chat {
	width: 500px;
}

#console-container {
	width:500px;
}

#console {
	border: 1px solid #CCCCCC;
	border-right-color: #999999;
	border-bottom-color: #999999;
	height: 600px;
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
	left :400px;
	width: 150px;
	padding: 5px;
	background: #FAF4C0;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	text-align: center;
}
#console #name{
	margin: 10px;
	position: relative;
	padding: 5px;
	
}
#console #sys{
margin: 10px;
	position: relative;
	text-align:center;
	padding: 5px;
}



</style>
<script type="application/javascript">
	
			var chat_Num = '${chat_Num}';
			
	
			var chat_mem_name = '${chat_mem_name}';
			
			
			var chat_Member_Participation = '${chat_Member_Participation}';
			
			var mem_num = '${mem_num}'
		
			
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
	                Console.sys('Info: WebSocket connection opened.');
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
	            	Chat.connect('ws://localhost:8888/WebSocketEx/websocket/chat?mem_name='+mem_num+'&receiver='+chat_Member_Participation);
	            } else {
	                Chat.connect('wss://' + window.location.host + '/websocket/chat');
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
	            console.appendChild(name);
	            
	            
	            console.appendChild(p); // 전달된 메시지를 하단에 추가함
	            // 추가된 메시지가 25개를 초과하면 가장 먼저 추가된 메시지를 한개 삭제함
	            while (console.childNodes.length > 25) {
	                console.removeChild(console.firstChild);
	            }
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
	            while (console.childNodes.length > 25) {
	                console.removeChild(console.firstChild);
	            }
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
	            while (console.childNodes.length > 25) {
	                console.removeChild(console.firstChild);
	            }
	            // 스크롤을 최상단에 있도록 설정함
	            console.scrollTop = console.scrollHeight;
	        });
	        
	        
	
	        // 위에 정의된 함수(접속시도)를 호출함
	        Chat.initialize();


	    
</script>
</head>
<body>

	<div>
	
		<div id="console-container">
			<div id="console" />
		</div>
		
		<p>
			<input type="text" placeholder="type and press enter to chat"
				id="chat" />
		</p>
	</div>
	
	
</body>
</html>