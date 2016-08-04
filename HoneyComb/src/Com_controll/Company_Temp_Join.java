package Com_controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Company_Temp_Join implements CommandAction{

// setting
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HoneyCombDBBean hcdbb = HoneyCombDBBean.getInstance();
		
		
		int com_num = Integer.parseInt(request.getParameter("com_num"));
		String com_name = request.getParameter("com_name");
		String com_dept_name = request.getParameter("com_dept_name");
		String com_pos_name = request.getParameter("com_pos_name");
		String email = (String) request.getSession().getAttribute("email");
		
		
		com_num = hcdbb.temp_Insert_company_to_person(com_num, com_name, com_dept_name, com_pos_name, email);
		request.getSession().setAttribute("com_num", com_num);
		System.out.println("com_num");
		
		return "/HoneyComb/coin/Com_check.coin";
	}

}
