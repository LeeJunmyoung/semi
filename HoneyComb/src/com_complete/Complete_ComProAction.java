package com_complete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Complete_ComProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		int com_num = Integer.parseInt(request.getParameter("com_num"));
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		List comList = null;
		comList = dbPro.com_permission(com_num);

		request.setAttribute("comList", comList);

		return "/admin/complete/complete_comPro.jsp";
	}

}
