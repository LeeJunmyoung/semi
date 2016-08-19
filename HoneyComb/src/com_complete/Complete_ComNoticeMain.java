package com_complete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Complete_ComNoticeMain implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		request.setCharacterEncoding("UTF-8");
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		
		String popup = "";
		popup = dbPro.popList();
		
		request.setAttribute("popup", popup);
		
		return "/admin/complete/popup_main.jsp";
	}

}
