package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogInDB.LogOnDBBean;

public class findPasswdPro implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		LogOnDBBean members = LogOnDBBean.getInstance();
		mailSender sender = new mailSender();
		String email = request.getParameter("email");
		
		String db = members.Checkemail(email);
		
		if(db.equals("n")){
			int key =  sender.emailSender(email);
			request.setAttribute("email", email);
			request.setAttribute("key", key);
			return "/view/findPasswdPro_y.jsp";
		}
		
		return "/view/findPasswdPro_n.jsp";
	}

}
