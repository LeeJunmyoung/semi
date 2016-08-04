package Com_controll;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class CompanyCheckProAction implements CommandAction {
	// 회사 검색 결과 (사원)

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String com_name = request.getParameter("com_name");
		String com_add = request.getParameter("com_add");
		String com_phone = request.getParameter("com_phone");
		
		HoneyCombDBBean manager = HoneyCombDBBean.getInstance();
		Vector comList = manager.com_Search(com_name);
		int countList = comList.size();
		
		request.setAttribute("comList", comList); // 검색된 회사 리스트
		request.setAttribute("totalList", countList); // 갯수
		request.setAttribute("com_name", com_name);
		
		
		return "companyCheck.jsp";
	}

}
