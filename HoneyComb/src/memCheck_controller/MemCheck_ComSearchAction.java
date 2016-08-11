package memCheck_controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memCheck_bean.MemCheckDBBean;

public class MemCheck_ComSearchAction implements CommandActionMemCheck {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String com_name = request.getParameter("com_name");
		
		MemCheckDBBean dbPro = MemCheckDBBean.getInstance();
		ArrayList comSearchList = new ArrayList<>();
		
		comSearchList = dbPro.comSearch(com_name);
		
		request.setAttribute("comSearchList", comSearchList);
		
		return "/admin/memCheck/memCheck_ComSearch.jsp";
	}

}
