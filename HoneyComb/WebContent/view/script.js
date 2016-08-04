function checkIt() {
	var test = myform.test.value;
	if (myform.email.value == "") {
		alert("E-mail을 입력하지 않았습니다.");
		document.myform.email.focus();
		return false;
	}

	if (myform.test.value == "") {

		alert("E-mail 확인 을 해주세요");
		return false;

	}

	if (myform.passwd.value == "") {

		alert("password를 입력하지 않았습니다.");
		document.myform.passwd.focus();
		return false;
	}

	if (myform.passwd.value != myform.checkpasswd.value) {

		alert("password를 동일하게 입력해야합니다.");
		document.myform.checkpasswd.focus();
		return false;
	}
	if (myform.name.value == "") {

		alert("이름을 입력하지 않았습니다.");
		document.myform.name.focus();
		return false;
	}
	if (myform.pnum1.value == "") {

		alert("전화번호를 입력하지 않았습니다.");
		document.myform.pnum1.focus();
		return false;
	}
	if (myform.pnum2.value == "") {

		alert("전화번호를 입력하지 않았습니다.")
		document.myform.pnum2.focus();
		return false;
	}
	if (myform.pnum3.value == "") {

		alert("전화번호를 입력하지 않았습니다.");
		document.myform.pnum3.focus();
		return false;
	}

};

function checkmail(myform) {
	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	if (myform.email.value == "") {
		alert("E-mail을 입력하지 않았습니다.");
		return;
	}
	if (!regExp.test(myform.email.value)) {
		alert("E-mail 형식이 아닙니다");
		document.myform.email.focus();
		return false;
	}

	url = "/HoneyComb/coin/MailCheck.coin?email=" + myform.email.value;

	open(url, "confirm", "toolbar=no, location=no,status=no,menubar=no,"
			+ "scrollbars=no,resizable=no,width=550, height=200");

};
function checkEmail() {
	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	if (myform.email.value == "") {
		alert("E-mail을 입력하지 않았습니다.");
		return false;
	}
	if (!regExp.test(myform.email.value)) {
		alert("E-mail 형식이 아닙니다");
		document.myform.email.focus();
		return false;
	}
	if(myform.passwd.value == ""){
		alert("비밀번호를 입력허세요");
		return false
	}
};


function frameclose() {
	window.close();
}
function recieveChildVAlue() {
	var value = "y"
	document.getElementById("mailtext").value = value;
}
function sendChildValue() {
	var name = "y";
	window.opener.recieveChildVAlue();
	window.close();

};

function tomain(){
	location="/HoneyComb/coin/LogOnCheck.coin"
}
function goback(){
	history.go(-1);
}