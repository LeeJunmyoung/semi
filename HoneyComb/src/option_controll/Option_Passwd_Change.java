package option_controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Option_Passwd_Change implements Option_CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		String newpw = request.getParameter("newpw1");
		
		OptionDBBean dbPro = OptionDBBean.getInstance();
		dbPro.pwChange(mem_num, newpw);
		
		return "/Option_user/close_option.jsp";
	}

}
