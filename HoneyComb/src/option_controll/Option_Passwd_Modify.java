package option_controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Option_Passwd_Modify implements Option_CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		String passwd = "";
		System.out.println("Option_Passwd_Modify mem_num ::: " + mem_num);
		
		OptionDBBean dbPro = OptionDBBean.getInstance();
		passwd = dbPro.pwCheck(mem_num);
		
		System.out.println("Option_Passwd_Modify passwd ::: " + passwd);
		
		request.setAttribute("passwd", passwd);
		
		return "/Option_user/modify_passwd_confirm.jsp";
	}
	
}
