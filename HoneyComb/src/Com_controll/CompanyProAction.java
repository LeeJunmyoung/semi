package Com_controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class CompanyProAction implements CommandAction {
	// ����� ��� ��û(ȸ��)

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("실행함여");
		List comList = null;
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		request.setCharacterEncoding("UTF-8");
		
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		String com_name = request.getParameter("com_name");
		String com_add = request.getParameter("com_add");
		String com_phone = request.getParameter("com_phone1");
			   com_phone = com_phone + request.getParameter("com_phone2");
			   com_phone = com_phone + request.getParameter("com_phone3");
		String com_aff = request.getParameter("com_aff");
	
		
		comList = dbPro.insert_temp_Company(mem_num,com_name, com_add, com_phone, com_aff);

		
		
		request.setAttribute("comList", comList);
		request.setAttribute("com_name", com_name);
		request.setAttribute("com_add", com_add);
		request.setAttribute("com_phone", com_phone);
		request.setAttribute("com_aff", com_aff);
	
		return "/company/companyPro.jsp";
	}
	
}
