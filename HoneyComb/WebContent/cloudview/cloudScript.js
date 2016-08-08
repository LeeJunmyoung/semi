function fileUploader(folder){
	var folder = folder;
	url="/HoneyComb/cloud/fileUploader.cloud?upload=true&folder="+folder;
	open(url, "confirm", "toolbar=no, location=no,status=no,menubar=no,"
			+ "scrollbars=no,resizable=no,width=550, height=200");
}

function createfolder(folder){
	url="/HoneyComb/cloudview/createfolder.jsp?folder="+folder;
	open(url, "confirm", "toolbar=no, location=no,status=no,menubar=no,"
			+ "scrollbars=no,resizable=no,width=550, height=200");
	
}
function refresh(){
window.opener.location.reload();
}