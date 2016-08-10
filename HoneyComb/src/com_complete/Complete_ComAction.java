package com_complete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Complete_ComAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();

		List comList = null;
		comList = dbPro.com_permissionList();

		request.setAttribute("comList", comList);

		return "/admin/complete/complete_com.jsp";
	}

}
