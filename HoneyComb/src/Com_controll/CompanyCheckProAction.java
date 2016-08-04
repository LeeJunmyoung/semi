package Com_controll;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class CompanyCheckProAction implements CommandAction {
	// ȸ�� �˻� ��� (���)

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String com_name = request.getParameter("com_name");
		String com_add = request.getParameter("com_add");
		String com_phone = request.getParameter("com_phone");
		
		HoneyCombDBBean manager = HoneyCombDBBean.getInstance();
		Vector comList = manager.com_Search(com_name);
		int countList = comList.size();
		
		request.setAttribute("comList", comList); // �˻��� ȸ�� ����Ʈ
		request.setAttribute("totalList", countList); // ����
		request.setAttribute("com_name", com_name);
		
		
		return "companyCheck.jsp";
	}

}
