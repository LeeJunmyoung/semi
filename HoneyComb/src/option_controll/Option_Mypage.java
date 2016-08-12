package option_controll;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogInDB.LogOnDataBean;

public class Option_Mypage implements Option_CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		OptionDBBean odbb = OptionDBBean.getInstance();
		List list = new ArrayList<LogOnDataBean>();
		
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		
		list = odbb.memberList(mem_num);
		
		request.setAttribute("my_list", list);
		
		
		return "/Option_user/option_mypage.jsp";
	}

}
