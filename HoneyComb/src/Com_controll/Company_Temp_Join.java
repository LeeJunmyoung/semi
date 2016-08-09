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
		int com_dept_num =  Integer.parseInt(request.getParameter("com_dept_num"));
		String com_pos_name = request.getParameter("com_pos_name");
		String email = (String) request.getSession().getAttribute("email");
		/*String email = "ss@ss.com";*/
		
		
		com_num = hcdbb.temp_Insert_company_to_person(com_num, com_name, com_dept_num, com_pos_name, email);
		
		com_num = (0-com_num);
		request.getSession().setAttribute("com_num", com_num);
		
		return "/view/comCheck.jsp";
	}

}
