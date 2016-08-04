//이메일과 입력된 비밀번호로 비밀번호 update
package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogInDB.LogOnDBBean;

public class updatePasswd implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		String email = request.getParameter("email");
		String newpasswd = request.getParameter("newpasswd");
		LogOnDBBean members  =  LogOnDBBean.getInstance();
		members.updatePasswd(email, newpasswd);
		return "/view/updatePasswd.jsp";
	}

}
