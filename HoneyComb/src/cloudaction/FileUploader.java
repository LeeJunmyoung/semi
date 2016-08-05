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
			System.out.println("�뿬湲곌퉴吏��샂");
			
			String savefilepath = "E://cloud//";
			HttpSession session = request.getSession();
			//�엫�떆濡� �꽭�뀡二쇨린
			session.setAttribute("mem_num", "11");
			session.setAttribute("com_num", "44");
			session.setAttribute("name", "tester");
			//�걹
			MultipartRequest mr = new MultipartRequest (request,savefilepath, 1024*1024*100,"utf-8", new DefaultFileRenamePolicy());
			// (�슂泥�媛앹껜, �뙆�씪�씠 �벐�뿬吏� 寃쎈줈, �뙆�씪�쓽 理쒕��겕湲�, �씤肄붾뵫諛⑹떇, �뙆�씪紐낆씠 �씠誘� �엳�쓣 寃쎌슦 '�뙆�씪紐�+1')
			//�뙆�씪寃쎈줈 媛��졇�삤湲�
			File file = mr.getFile("uploadFile");
			String filename = String.valueOf(file);
			//�뙆�씪寃쎈줈 媛��졇�삤湲곕걹
			//�깉濡� 諛붽� �뙆�씪紐� \3E(<)(�궇吏�+�쉶�궗踰덊샇+�삱由곗궗�엺�씠由�_�뙆�씪紐�+�궃�닔1~9)
			CreateFilePath createfilePath =  CreateFilePath.getInstance();
			String oldPath = filename.replace("\\", "/");
			System.out.println(oldPath);
			cloudDB = tempInsert(cloudDB, request);
			cloudDB = createfilePath.FilePath(cloudDB, oldPath);
			System.out.println(cloudDB.getFile_path());
			//諛붽��뙆�씪紐낅걹
			//�씠誘몄��옣�맂 �솗�옣�옄 �씠�쇅�쓽 �씠由� 媛��졇�삤湲�
			String newfilename = cloudDB.getFile_path();
			int i = 0;
			i = filename.lastIndexOf(".");
			String realFileName = newfilename+filename.substring(i,filename.length());
			//�씠誘몄��옣�맂 �솗�옣�옄 �씠�쇅�쓽 �씠由� 媛��졇�삤湲� �걹
			//�뙆�씪 �씠由� 諛붽씀湲�
			File oldfile = new File(filename);
			File newfile = new File(savefilepath+realFileName);
			oldfile.renameTo(newfile);
			//�뙆�씪�씠由꾨컮袁멸린�걹
			//�뙆�씪寃쎈줈 ���옣
			String file_path = String.valueOf(newfile);
			//�뙆�씪寃쎈줈���옣�걹
			//�겢�씪�슦�뱶db�뿉 ���옣
			//�뜲�씠�꽣 �뀑�똿(com_num, name �� tempInsert�뿉�꽌 吏��젙, file_name �� createFilePath.java�뿉�꽌 吏��젙)
			cloudDB.setFile_size((int)newfile.length());
			cloudDB.setFile_path(file_path);
			//�뜲�씠�꽣 �뀑�똿 �걹
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
/*?占쏙옙占�?(xxxxxx)com_num(xxxx), mem_num(xxxxxx), file踰덊샇(xxxxxx)
?占쏙옙?占쏙옙 占�??占쏙옙 ?占쏙옙?占쏙옙?占쏙옙占�? ?占쏙옙占�?(milli)*/