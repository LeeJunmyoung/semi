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
		
		/*�ӽü��� com_num, folder*/
		session.setAttribute("com_num", 1);
		session.setAttribute("mem_num", 1);
		session.setAttribute("name", "test");
		
		/*�ӽü��� ��*/
		
		
		
		int com_num = (int)session.getAttribute("com_num");
		String folder = (String)request.getParameter("folder");
		if (folder ==null){
			folder = "";
		}
		
		cloudList = cloud.cloudList(com_num, folder);
		request.setAttribute("cloudList", cloudList);
				
		
		return "/page_layout/Cloud/Cloud_home.jsp?folder="+folder;
	}

}
