package com_complete;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;
import com_bean.Notice_adminDataBean;


public class Complete_ComNoticeAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		request.setCharacterEncoding("UTF-8");
		Notice_adminDataBean NoticeDB = new Notice_adminDataBean();
		NoticeDB.setNotice_admin_title(request.getParameter("notice_admin_title"));
		NoticeDB.setNotice_admin_content(request.getParameter("notice_admin_content"));
		NoticeDB.setNotice_admin_date(new Timestamp(System.currentTimeMillis()));
		
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		List noticeList = null;
		noticeList = dbPro.noticeComplete(NoticeDB);
		
		request.setAttribute("noticeList", noticeList);
		
		return "/admin/complete/complete_comNotice_admin.jsp";
	}

}
