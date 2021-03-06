//파일경로를 session 으로 받아 삭제
package cloudaction;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clouddb.CloudDBBean;

public class CloudDeleteItem implements CommandActionCloud {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession();
		CloudDBBean cloudDB = CloudDBBean.getInstance();

		int promgr_num = 0;
		
		if( (String)request.getParameter("promgr_num") == null) {
			promgr_num = 0;
		} else {
			promgr_num = Integer.parseInt(String.valueOf(request.getParameter("promgr_num")));
		}
		
		System.out.println("promgr_num : " + promgr_num);

		// file_path 받아오는 기능

		String file_path = (String) session.getAttribute("file_path");

		String folder = request.getParameter("folder");
		// 세션에 없을 경우
		String returnp = "/cloudview/changeFilename.jsp?type=close";
		if (file_path == null) {
			file_path = request.getParameter("file_path");
			returnp = "/cloudview/cloudindex.jsp";
			// 폴더일경우
			if (file_path == null) {
				String file_name = request.getParameter("file_name");
				cloudDB.deleteItem(file_name, folder);
				return returnp;
			}
		}
		File f = new File(file_path);
		f.delete();

		int update_db = cloudDB.deleteItem(file_path, null);
		// DB에서 삭제

		// fiel_path 삭제
		session.removeAttribute("file_path");
		
		if (promgr_num > 0) {

			request.setAttribute("promgr_update_count", update_db);

			returnp = "/promgr/promgrPro.jsp";
			
		}
		
		return returnp;

	}

}
