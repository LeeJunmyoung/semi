package Com_controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class CompanyFindProAction implements CommandAction {
	// ȸ�� ���ο�û (���)

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String com_name = request.getParameter("com_name");
		String com_dept_name = request.getParameter("com_dept_name");
		String com_pos_name = request.getParameter("com_pos_name");
		
		System.out.println("com_name::::::::::" + com_name);
		System.out.println("com_dept_name::::::::::" + com_dept_name);
		System.out.println("com_pos_name::::::::::" + com_pos_name);
		
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		dbPro.com_select_person(com_name, com_dept_name, com_pos_name);
		
		request.setAttribute("com_name", com_name);
		request.setAttribute("com_dept_name", com_dept_name);
		request.setAttribute("com_pos_name", com_pos_name);
		
		
		return "companyFindPro.jsp";
	}

}
