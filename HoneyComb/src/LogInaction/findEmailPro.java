package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogInDB.LogOnDBBean;

public class findEmailPro implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		LogOnDBBean  members = LogOnDBBean.getInstance();
		String email = null;
		
		String name = request.getParameter("name");
		String pnum1 = request.getParameter("phone1");
		String pnum2 = request.getParameter("phone2");
		String pnum3 = request.getParameter("phone3");
		String Phone_num  = pnum1+pnum2+pnum3;
		
		email = members.FindEmail(name, Phone_num);
		
		if(email == null){
			return"/view/findEmailPro_n.jsp";
		}
		request.setAttribute("email", email);
		return "/view/findEmailPro_y.jsp";
	}

}
