package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LogInDB.LogOnDBBean;

public class mailCheck implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		LogOnDBBean members =  LogOnDBBean.getInstance();
		String email=request.getParameter("email");

		String db = members.Checkemail(email);
		//y 이면 된거고 n 이면 안된거임
		return "/view/checkEmail_"+db+".jsp";
	}
	

}
