package option_controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import option_controll.Option_CommandAction;

public class Option_check implements Option_CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int com_num = (int)request.getSession().getAttribute("com_num");
		System.out.println("Option_check com_num = "+com_num);
		OptionDBBean dbPro = OptionDBBean.getInstance();

		List memberlist = null;
		memberlist = dbPro.memberList(com_num);

		request.setAttribute("memberlist", memberlist);

		return "/Option_user/option_check.jsp";
	}
	
	}
