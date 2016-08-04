package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//로그인페이지로 넘어가기 위한페이지
public class LogIn implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		return"/view/logIn.jsp";
	}
}
