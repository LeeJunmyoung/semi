/*����Ȯ��������*/
package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOnCheck implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// session�� �޾ƿ�
		HttpSession session = request.getSession();
		if (session == null) {
			
			return "/view/mainPage.jsp";

		} else {
			String mem_num = String.valueOf(session.getAttribute("mem_num"));

			if (mem_num.equals("null")) {
				
				// mem_num�� ������ �������� �̵�
				session.invalidate();
				return "/view/mainPage.jsp";
			} else
				//������ �ִٸ�, comCheck���� �̵�
				return "/view/comCheck.jsp";
		}

	}

}
