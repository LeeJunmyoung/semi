package cloudaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clouddb.CloudDBBean;
import clouddb.CloudDataBean;

public class CloudForm implements CommandActionCloud{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		CloudDBBean cloud = CloudDBBean.getInstance();
		CloudDataBean list = new CloudDataBean();
		List cloudList = new ArrayList();
		
		HttpSession session = request.getSession();
		
		/*임시설정 com_num, folder*/
		session.setAttribute("com_num", "1");
		/*임시설정 끝*/
		
		
		
		int com_num = Integer.parseInt((String)session.getAttribute("com_num"));
		String folder = (String)request.getParameter("folder");
		if (folder ==null){
			folder = "";
		}
		
		cloudList = cloud.cloudList(com_num, folder);
		request.setAttribute("cloudList", cloudList);
				
		
		return "/cloudview/cloudForm.jsp?folder="+folder;
	}

}
