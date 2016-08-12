function fileUploader(folder){
	url="/HoneyComb/cloud/fileUploader.cloud?upload=true&folder="+folder;
	open(url, "confirm", "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=550, height=200");
}

function createfolder(folder){
	folder = encodeURIComponent(folder);
	url="/HoneyComb/cloudview/createfolder.jsp?folder="+folder;
	open(url, "confirm", "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=550, height=200");
	
}
function movefolder(folder, name){
	if(folder == null){
		window.location="/HoneyComb/cloud/cloudForm.cloud?folder="+name+"|";
	}else{
	window.location="/HoneyComb/cloud/cloudForm.cloud?folder="+folder+name+"|";
	}
}

function refresh(){
window.opener.location.reload();
}

function test(){
	alert(file_name.val())
	
}
function emptyck(value){
	var item = document.getElementById(value).value;
	
	if(item  == null||item == ""){
		alert("빈 공간을 업로드할 수 없습니다.");
		return false;
	}
	
}

