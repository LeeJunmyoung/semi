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
		System.out.println("?��기까�??��");
		
		String savefilepath = "D://cloud//";
		HttpSession session = request.getSession();
		//?��?���? ?��?��주기
		session.setAttribute("mem_num", "11");
		session.setAttribute("com_num", "44");
		session.setAttribute("name", "tester");
		//?��
		MultipartRequest mr = new MultipartRequest (request,savefilepath, 1024*1024*10,"utf-8", new DefaultFileRenamePolicy());
		// (?���?객체, ?��?��?�� ?��?���? 경로, ?��?��?�� 최�??���?, ?��코딩방식, ?��?��명이 ?���? ?��?�� 경우 '?��?���?+1')
		//?��?��경로 �??��?���?
		File file = mr.getFile("uploadFile");
		String filename = String.valueOf(file);
		//?��?��경로 �??��?��기끝
		//?���? 바�? ?��?���? \3E(<)(?���?+?��?��번호+?��린사?��?���?_?��?���?+?��?��1~9)
		CreateFilePath createfilePath =  CreateFilePath.getInstance();
		String oldPath = filename.replace("\\", "/");
		System.out.println(oldPath);
		cloudDB = tempInsert(cloudDB, request);
		cloudDB = createfilePath.FilePath(cloudDB, oldPath);
		System.out.println(cloudDB.getFile_path());
		//바�??��?��명끝
		//?��미�??��?�� ?��?��?�� ?��?��?�� ?���? �??��?���?
		String newfilename = cloudDB.getFile_path();
		int i = 0;
		i = filename.lastIndexOf(".");
		String realFileName = newfilename+filename.substring(i,filename.length());
		//?��미�??��?�� ?��?��?�� ?��?��?�� ?���? �??��?���? ?��
		//?��?�� ?���? 바꾸�?
		File oldfile = new File(filename);
		File newfile = new File(savefilepath+realFileName);
		oldfile.renameTo(newfile);
		//?��?��?��름바꾸기?��
		//?��?��경로 ???��
		String file_path = String.valueOf(newfile);
		//?��?��경로???��?��
		//?��?��?��?��db?�� ???��
		//?��?��?�� ?��?��(com_num, name ?? tempInsert?��?�� �??��, file_name ?? createFilePath.java?��?�� �??��)
		cloudDB.setFile_size((int)newfile.length());
		cloudDB.setFile_path(file_path);
		//?��?��?�� ?��?�� ?��
		//DB insert
		cloud.cloudInsert(cloudDB);
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
/*?���?(xxxxxx)com_num(xxxx), mem_num(xxxxxx), file번호(xxxxxx)
?��?�� �??�� ?��?��?���? ?���?(milli)*/