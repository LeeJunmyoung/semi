package option_controll;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogInDB.LogOnDataBean;

public class Accept_Member implements Option_CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int com_num = (int)request.getSession().getAttribute("com_num");
		int mem_num = Integer.parseInt(request.getParameter("wait_mem_num"));
		int com_dept_num = Integer.parseInt(request.getParameter("wait_mem_dept_num"));
		int com_pos_num = Integer.parseInt(request.getParameter("wait_pos_num"));
		
		OptionDBBean odbb= OptionDBBean.getInstance();
		
		
		odbb.accept_member(com_num,mem_num,Math.abs(com_dept_num),Math.abs(com_pos_num));
		
		ArrayList list = new ArrayList<LogOnDataBean>();
		
		
		list =  odbb.view_temp_member(com_num);
		
		request.setAttribute("temp_member", list);
		
		
		return "/Option_user/accept_member.jsp";
	}

}
