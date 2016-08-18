package option_controll;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

public class Option_Profile_Img implements Option_CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		if (request.getContentType() != null && request.getContentType().indexOf("multipart/form-data") > -1) {

			/* String savePath = "C:\\user_profile_img\\"; // 파일경로 */
			
			String savePath = request.getServletContext().getRealPath("profile_img");
			// 파일이 저장되는 경로
			// C:\Users\박수정\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\HoneyComb\profile_img
			System.out.println("Option_Profile_Img savePath ::: " + savePath);
			
			int sizeLimit = 1024 * 1024 * 15; // 파일크기
			MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8");

			Date d = new Date();
			String img_add_date = String.valueOf(d.getTime()); // 파일명에 시간 추가
			System.out.println("Option_Profile_Img img_add_date :::" + img_add_date);

			String img_name = multi.getFilesystemName("profile_img");
			System.out.println("Option_Profile_Img img_name ::: " + img_name);

			String fullPath = savePath + img_add_date + img_name; // 전체 경로
			String path = "/HoneyComb/profile_img/" + img_name; // db에 저장되는 경로
			System.out.println("Option_Profile_Img path ::: " + path);
			/*String path = "";*/
			/*String path = "C://user_profile_img/" + img_add_date + img_name; // db에 저장되는 경로
*/
			int mem_num = (int) request.getSession().getAttribute("mem_num");

			OptionDBBean dbPro = OptionDBBean.getInstance();
			String profile_img = "";
			
			profile_img = dbPro.img_Register(mem_num, path);

			 HttpSession session = request.getSession();
			 
			 session.setAttribute("profile_img", profile_img);
			 System.out.println(profile_img);
			 
			return "/Option_user/option_mypage.jsp";
		}

		return "/Option_user/option_mypage.jsp";
	}
}
