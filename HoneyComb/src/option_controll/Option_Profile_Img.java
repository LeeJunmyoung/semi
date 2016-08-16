package option_controll;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Option_Profile_Img implements Option_CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		if (request.getContentType() != null && request.getContentType().indexOf("multipart/form-data") > -1) {
			
			String savePath = request.getServletContext().getRealPath("images"); // 파일경로

			int sizeLimit = 1024 * 1024 * 15; // 파일크기
			MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
			String img_name = multi.getFilesystemName("profile_img");
			
			String FullPath = savePath + "\\" + img_name; // 전체 파일경로
			String path = "/HoneyComb/images/" + img_name; // db에 저장되는 경로
			
			int mem_num = (int)request.getSession().getAttribute("mem_num");
			
			OptionDBBean dbPro = OptionDBBean.getInstance();
			String profile_img = "";
			profile_img = dbPro.img_Register(mem_num, path);
			
			HttpSession session = request.getSession();
			session.setAttribute("profile_img", profile_img);
			
			return "/Option_user/option_mypage.jsp";
			
		}
		
		return "/Option_user/option_mypage.jsp";
	}

}
