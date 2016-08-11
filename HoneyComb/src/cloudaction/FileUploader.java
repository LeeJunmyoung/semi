package cloudaction;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import clouddb.CloudDBBean;
import clouddb.CloudDataBean;

public class FileUploader implements CommandActionCloud{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		
		
		if (request.getParameter("upload")==null){
			CloudDataBean cloudDB = new CloudDataBean();
			CloudDBBean cloud = CloudDBBean.getInstance();
			
			String savefilepath = "D://cloud//";
			HttpSession session = request.getSession();
						
			//세션입시설정
			session.setAttribute("mem_num", "11");
			session.setAttribute("com_num", "1");
			session.setAttribute("name", "tester");
			//파일먼저 업로드
			MultipartRequest mr = new MultipartRequest (request,savefilepath, 1024*1024*100,"utf-8");
			
			
			File file = mr.getFile("uploadFile");
			String filename = String.valueOf(file);
			
			CreateFilePath createfilePath =  CreateFilePath.getInstance();
			String oldPath = filename.replace("\\", "/");
			cloudDB = tempInsert(cloudDB, request);
			
			
			
			cloudDB = createfilePath.FilePath(cloudDB, oldPath);
			
			String newfilename = cloudDB.getFile_path();
			int i = 0;
			i = filename.lastIndexOf(".");
			String realFileName = newfilename;
			if(i != -1){
			realFileName = newfilename+filename.substring(i,filename.length());}
			
			File oldfile = new File(filename);
			File newfile = new File(savefilepath+realFileName);
			oldfile.renameTo(newfile);
			
			String file_path = String.valueOf(newfile);
			
			
			cloudDB.setFile_size((int)newfile.length());
			cloudDB.setFile_path(file_path);
		
			//DB insert
			String folder = request.getParameter("folder");

			int filecheck = cloud.cloudInsert(cloudDB, folder);
			//이름바꿔줄 file_num session으로 저장
			session.setAttribute("file_path", cloudDB.getFile_path());
			
			if(filecheck == 0){
				return "/cloudview/uploadForm.jsp?filecheck="+cloudDB.getFile_name();
			}else{
				return "/cloudview/changeFilename.jsp";
			}
		
			}
		return "/cloudview/uploadForm.jsp";
	}
	private CloudDataBean tempInsert(CloudDataBean cloudDB, HttpServletRequest request){
		HttpSession session = request.getSession();
		int com_num = Integer.parseInt((String)session.getAttribute("com_num"));
		String name = (String)session.getAttribute("name");
		cloudDB.setCom_num(com_num);
		cloudDB.setFile_uploader(name);
		return cloudDB;
	}
}

/*?占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�?(xxxxxx)com_num(xxxx), mem_num(xxxxxx), file�뵓怨뺣쐡占쎄퉰(xxxxxx)
?占쎈쐻占쎈짗占쎌굲?占쎈쐻占쎈짗占쎌굲 占쎈쐻�뜝占�??占쎈쐻占쎈짗占쎌굲 ?占쎈쐻占쎈짗占쎌굲?占쎈쐻占쎈짗占쎌굲?占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�? ?占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�?(milli)*/