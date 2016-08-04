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
		System.out.println("여기까지옴");
		
		String savefilepath = "D://cloud//";
		HttpSession session = request.getSession();
		//임시로 세션주기
		session.setAttribute("mem_num", "11");
		session.setAttribute("com_num", "44");
		session.setAttribute("name", "tester");
		//끝
		MultipartRequest mr = new MultipartRequest (request,savefilepath, 1024*1024*10,"utf-8", new DefaultFileRenamePolicy());
		// (요청객체, 파일이 쓰여질 경로, 파일의 최대크기, 인코딩방식, 파일명이 이미 있을 경우 '파일명+1')
		//파일경로 가져오기
		File file = mr.getFile("uploadFile");
		String filename = String.valueOf(file);
		//파일경로 가져오기끝
		//새로 바꿀 파일명 \3E(<)(날짜+회사번호+올린사람이름_파일명+난수1~9)
		CreateFilePath createfilePath =  CreateFilePath.getInstance();
		String oldPath = filename.replace("\\", "/");
		System.out.println(oldPath);
		cloudDB = tempInsert(cloudDB, request);
		cloudDB = createfilePath.FilePath(cloudDB, oldPath);
		System.out.println(cloudDB.getFile_path());
		//바꿀파일명끝
		//이미저장된 확장자 이외의 이름 가져오기
		String newfilename = cloudDB.getFile_path();
		int i = 0;
		i = filename.lastIndexOf(".");
		String realFileName = newfilename+filename.substring(i,filename.length());
		//이미저장된 확장자 이외의 이름 가져오기 끝
		//파일 이름 바꾸기
		File oldfile = new File(filename);
		File newfile = new File(savefilepath+realFileName);
		oldfile.renameTo(newfile);
		//파일이름바꾸기끝
		//파일경로 저장
		String file_path = String.valueOf(newfile);
		//파일경로저장끝
		//클라우드db에 저장
		//데이터 셋팅(com_num, name 은 tempInsert에서 지정, file_name 은 createFilePath.java에서 지정)
		cloudDB.setFile_size((int)newfile.length());
		cloudDB.setFile_path(file_path);
		//데이터 셋팅 끝
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
/*날짜(xxxxxx)com_num(xxxx), mem_num(xxxxxx), file번호(xxxxxx)
회사 부서 사원정보 시간(milli)*/