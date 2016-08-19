//file_path 를 session 으로 받아 rename
package cloudaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clouddb.CloudDBBean;
import clouddb.CloudDataBean;

public class CloudRenameItem implements CommandActionCloud{
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		HttpSession session = request.getSession();
		CloudDBBean cloudDB = CloudDBBean.getInstance();
		CloudDataBean clouddata = new CloudDataBean();
		
		//file_path 받아오는 기능
		String file_path = (String)session.getAttribute("file_path");
		//바꿔줄 이름
		String itemName = (String)request.getParameter("itemName");
		System.out.println("file_path ="+file_path);
		clouddata = cloudDB.renameCheck(file_path);
		
		int i = cloudDB.renameItem(clouddata, itemName);
		System.out.println(i);
		
		String promgr_num = (String)request.getAttribute("promgr_num");
		request.setAttribute("promgr_num", promgr_num);
		if (i == 0){
			
			return "/cloudview/uploadForm.jsp?filecheck="+itemName;
		}
		session.removeAttribute("file_path");
		return "/cloudview/uploadForm.jsp?upload=done";
	}
}
