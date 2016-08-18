package option_controll;

import java.net.*;
import javax.mail.*;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Option_User_Del_Form implements Option_CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		
		OptionDBBean dbPro = OptionDBBean.getInstance();
		String passwd = "";
		passwd = dbPro.passwd_Get(mem_num);
		
		request.setAttribute("passwd", passwd);
		
		return "/Option_user/user_delete.jsp";
	}

}
