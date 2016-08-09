package option_controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Accept_Member implements Option_CommandAction {

	@Override
	public String requestPro(HttpServletRequest arg0, HttpServletResponse arg1) throws Throwable {
		// TODO Auto-generated method stub
		
		
		
		
		return "/Option_user/accept_member.jsp";
	}

}
