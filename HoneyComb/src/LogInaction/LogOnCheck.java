/*세션확인페이지*/
package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOnCheck implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// session값 받아옴
		HttpSession session = request.getSession();
		if (session == null) {
			
			return "/view/mainPage.jsp";

		} else {
			String mem_num = String.valueOf(session.getAttribute("mem_num"));

			if (mem_num.equals("null")) {
				
				// mem_num이 없으면 메인으로 이동
				session.invalidate();
				return "/view/mainPage.jsp";
			} else
				//세션이 있다면, comCheck으로 이동
				return "/view/comCheck.jsp";
		}

	}

}
