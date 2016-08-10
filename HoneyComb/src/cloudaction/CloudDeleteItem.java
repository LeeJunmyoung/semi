//파일경로를 session 으로 받아 삭제
package cloudaction;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clouddb.CloudDBBean;

public class CloudDeleteItem implements CommandActionCloud{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		HttpSession session = request.getSession();
		CloudDBBean cloudDB = CloudDBBean.getInstance();
		
		//file_path 받아오는 기능
		String file_path = (String)session.getAttribute("file_path");
		File f = new File(file_path);
		f.delete();
		
		cloudDB.deleteItem(file_path);
		//DB에서 삭제
		
		
		//fiel_path 삭제
		session.removeAttribute("file_path");
		
		
		return "/cloudview/changeFilename.jsp";
	}

}
