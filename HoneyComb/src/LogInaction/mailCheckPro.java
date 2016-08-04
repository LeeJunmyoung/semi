package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mailCheckPro implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		mailSender message =  new mailSender();
		String email=request.getParameter("email");
		int numcheck = message.emailSender(email);
		request.setAttribute("numcheck", numcheck);
		return "/view/checkEmailPro.jsp";
	}

}
