//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙獵짹占쏙옙
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
		//占쌈시쇽옙占쏙옙
		session.setAttribute("com_num", "1");
		session.setAttribute("name", "tester");
		//占쌈시쇽옙占쏙옙 占쏙옙
		
		
		
		//占쏙옙占쏙옙 占쏙옙占쏙옙 占쌨아울옙占쏙옙
		String folder = (String)request.getParameter("folder");
		//占쏙옙占쏙옙占쏙옙 占쌨아울옙占쏙옙
		String file_name = (String)request.getParameter("foldername");
		//com_num 占쌨아울옙占쏙옙
		int com_num = Integer.parseInt((String)session.getAttribute("com_num"));
		//占쏙옙占쏙옙 占쏙옙占싸듸옙 占싼삼옙占� 占쌨아울옙占쏙옙
		String file_uploader = (String)session.getAttribute("name");
		//cloudPro占쏙옙 占쌍깍옙

		
		
		cloudPro.setFolder(folder);
		cloudPro.setFile_name(file_name);
		cloudPro.setCom_num(com_num);
		cloudPro.setFile_uploader(file_uploader);
		//占쌩븝옙占쏙옙占� 확占쏙옙
		int folder_check = cloud.checkFolder(cloudPro);
		if(folder_check == 0){
			return"/cloudview/createfolder.jsp?name="+file_name;
		}
		//占쌩븝옙占쏙옙占� 확占쏙옙 占쏙옙
	
		cloud.createFolder(cloudPro);
		return "/cloudview/createfolder.jsp";
	}

}
