package com_complete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Complete_ComInAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String com_name = request.getParameter("com_name");
		
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		int x = dbPro.insertComplete(com_name);
		
		if (x == 1) {
			return "complete_comIn.jsp";
		}
		
		return "complete_com.jsp";
		
	}

}
