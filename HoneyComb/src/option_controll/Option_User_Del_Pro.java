package option_controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Option_User_Del_Pro implements Option_CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		
		OptionDBBean dbPro = OptionDBBean.getInstance();
		dbPro.user_Delete(mem_num);
		
		return "/Option_user/user_del_compl.jsp";
	}

}
