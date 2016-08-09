package option_controll;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogInDB.LogOnDataBean;

public class Option_View_Temp_Member implements Option_CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int com_num = (int)request.getSession().getAttribute("com_num");
		OptionDBBean odb = OptionDBBean.getInstance();
		ArrayList list = new ArrayList<LogOnDataBean>();
		
		
		list =  odb.view_temp_member(com_num);
		
		request.setAttribute("temp_member", list);
		
		return "/Option_user/company_accept_member.jsp";
	}

}
