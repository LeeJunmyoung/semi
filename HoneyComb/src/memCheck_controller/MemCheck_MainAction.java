package memCheck_controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memCheck_bean.MemCheckDBBean;

public class MemCheck_MainAction implements CommandActionMemCheck {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		MemCheckDBBean dbPro = MemCheckDBBean.getInstance();
		ArrayList memList = new ArrayList<>();
		memList = dbPro.memList();
		
		request.setAttribute("companyList", memList);
		
		return "/admin/memCheck/memCheck_Main.jsp";
	}

}
