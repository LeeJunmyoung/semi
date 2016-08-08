//폴더 만들어주는기능
package cloudaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clouddb.CloudDBBean;
import clouddb.CloudDataBean;;


public class CreateFolder implements CommandActionCloud{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		CloudDBBean cloud = CloudDBBean.getInstance();
		CloudDataBean cloudPro = new CloudDataBean();
		HttpSession session  =  request.getSession();
		request.setCharacterEncoding("utf-8");
		//임시설정
		session.setAttribute("com_num", "1");
		session.setAttribute("name", "tester");
		//임시설정 끝
		
		
		
		//현재 폴더 받아오기
		String folder = (String)request.getParameter("folder");
		//폴더명 받아오기
		String file_name = (String)request.getParameter("foldername");
		//com_num 받아오기
		int com_num = Integer.parseInt((String)session.getAttribute("com_num"));
		//파일 업로드 한사람 받아오기
		String file_uploader = (String)session.getAttribute("name");
		//cloudPro에 넣기
		System.out.println("폴더:"+folder);
		System.out.println("폴더명:"+file_name);
		System.out.println("컴넘:"+com_num);
		System.out.println("이름"+file_uploader);
		
		
		cloudPro.setFolder(folder);
		cloudPro.setFile_name(file_name);
		cloudPro.setCom_num(com_num);
		cloudPro.setFile_uploader(file_uploader);
		
		
		cloud.createFolder(cloudPro);
		return "/cloudview/createfolder.jsp";
	}

}
