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
		System.out.println("?—¬ê¸°ê¹Œì§??˜´");
		
		String savefilepath = "D://cloud//";
		HttpSession session = request.getSession();
		//?„?‹œë¡? ?„¸?…˜ì£¼ê¸°
		session.setAttribute("mem_num", "11");
		session.setAttribute("com_num", "44");
		session.setAttribute("name", "tester");
		//?
		MultipartRequest mr = new MultipartRequest (request,savefilepath, 1024*1024*10,"utf-8", new DefaultFileRenamePolicy());
		// (?š”ì²?ê°ì²´, ?ŒŒ?¼?´ ?“°?—¬ì§? ê²½ë¡œ, ?ŒŒ?¼?˜ ìµœë??¬ê¸?, ?¸ì½”ë”©ë°©ì‹, ?ŒŒ?¼ëª…ì´ ?´ë¯? ?ˆ?„ ê²½ìš° '?ŒŒ?¼ëª?+1')
		//?ŒŒ?¼ê²½ë¡œ ê°?? ¸?˜¤ê¸?
		File file = mr.getFile("uploadFile");
		String filename = String.valueOf(file);
		//?ŒŒ?¼ê²½ë¡œ ê°?? ¸?˜¤ê¸°ë
		//?ƒˆë¡? ë°”ê? ?ŒŒ?¼ëª? \3E(<)(?‚ ì§?+?šŒ?‚¬ë²ˆí˜¸+?˜¬ë¦°ì‚¬?Œ?´ë¦?_?ŒŒ?¼ëª?+?‚œ?ˆ˜1~9)
		CreateFilePath createfilePath =  CreateFilePath.getInstance();
		String oldPath = filename.replace("\\", "/");
		System.out.println(oldPath);
		cloudDB = tempInsert(cloudDB, request);
		cloudDB = createfilePath.FilePath(cloudDB, oldPath);
		System.out.println(cloudDB.getFile_path());
		//ë°”ê??ŒŒ?¼ëª…ë
		//?´ë¯¸ì??¥?œ ?™•?¥? ?´?™¸?˜ ?´ë¦? ê°?? ¸?˜¤ê¸?
		String newfilename = cloudDB.getFile_path();
		int i = 0;
		i = filename.lastIndexOf(".");
		String realFileName = newfilename+filename.substring(i,filename.length());
		//?´ë¯¸ì??¥?œ ?™•?¥? ?´?™¸?˜ ?´ë¦? ê°?? ¸?˜¤ê¸? ?
		//?ŒŒ?¼ ?´ë¦? ë°”ê¾¸ê¸?
		File oldfile = new File(filename);
		File newfile = new File(savefilepath+realFileName);
		oldfile.renameTo(newfile);
		//?ŒŒ?¼?´ë¦„ë°”ê¾¸ê¸°?
		//?ŒŒ?¼ê²½ë¡œ ???¥
		String file_path = String.valueOf(newfile);
		//?ŒŒ?¼ê²½ë¡œ???¥?
		//?´?¼?š°?“œdb?— ???¥
		//?°?´?„° ?…‹?Œ…(com_num, name ?? tempInsert?—?„œ ì§?? •, file_name ?? createFilePath.java?—?„œ ì§?? •)
		cloudDB.setFile_size((int)newfile.length());
		cloudDB.setFile_path(file_path);
		//?°?´?„° ?…‹?Œ… ?
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
/*?‚ ì§?(xxxxxx)com_num(xxxx), mem_num(xxxxxx), fileë²ˆí˜¸(xxxxxx)
?šŒ?‚¬ ë¶??„œ ?‚¬?›? •ë³? ?‹œê°?(milli)*/