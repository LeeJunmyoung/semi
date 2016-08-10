//file_path 를 session 으로 받아 rename
package cloudaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clouddb.CloudDBBean;

public class CloudRenameItem implements CommandActionCloud{
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		HttpSession session = request.getSession();
		CloudDBBean cloudDB = CloudDBBean.getInstance();
		
		//file_path 받아오는 기능
		String file_path = (String)session.getAttribute("file_path");
		//변수받아옴
		String itemName = (String)request.getParameter("itemName");
		System.out.println("받아옴:"+itemName);
		
		cloudDB.renameItem(file_path, itemName);
		session.removeAttribute("file_path");
		
		return null;
	}
}
