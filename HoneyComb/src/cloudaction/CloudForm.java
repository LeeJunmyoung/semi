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
		int com_num = Integer.parseInt(String.valueOf(request.getSession().getAttribute("com_num")));/*
		int com_num = (int)request.getSession().getAttribute("com_num");*/
		String folder = (String)request.getParameter("folder");
		if (folder ==null){
			folder = "";
		}
		
		cloudList = cloud.cloudList(com_num, folder);
		request.setAttribute("cloudList", cloudList);
			System.out.println("com_num"+com_num);
		
		return "/page_layout/Cloud/Cloud_home.jsp?folder="+folder;
	}

}
