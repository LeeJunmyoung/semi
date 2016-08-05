package com_complete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Complete_ComDelAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int com_num = Integer.parseInt(request.getParameter("com_num"));
			HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
			int check = 0;
			check = dbPro.deleteComplete(com_num);
			request.setAttribute("check", Integer.parseInt("check"));
		
		return "/admin/complete/completedelPro_com.jsp";
	}

}
