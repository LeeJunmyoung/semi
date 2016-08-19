package com_complete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;


public class Complete_ComNoticeAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		request.setCharacterEncoding("UTF-8");
		String notice_admin_content = request.getParameter("notice_admin_content");
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		List noticeList = null;
		noticeList = dbPro.noticeComplete(notice_admin_content);
		
		request.setAttribute("noticeList", noticeList);
		
		return "/admin/complete/complete_comNotice_admin.jsp";
	}

}
