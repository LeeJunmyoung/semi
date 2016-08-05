function fileUploader(){
	url="/HoneyComb/cloud/fileUploader.cloud?upload=true";
	open(url, "confirm", "toolbar=no, location=no,status=no,menubar=no,"
			+ "scrollbars=no,resizable=no,width=550, height=200");
}

function createfolder(){
	url="/HoneyComb/cloudview/createfolder.jsp";
	open(url, "confirm", "toolbar=no, location=no,status=no,menubar=no,"
			+ "scrollbars=no,resizable=no,width=550, height=200");
	
}