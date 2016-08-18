package com_complete;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;
import com_bean.Notice_adminDataBean;


public class Complete_ComNoticeAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Notice_adminDataBean article = new Notice_adminDataBean();
		article.setNotice_admin_num(Integer.parseInt(request.getParameter("notice_admin_num")));
		article.setNotice_admin_content(request.getParameter("notice_admin_content"));
		article.setNotice_admin_member(request.getParameter("notice_admin_member"));
		article.setNotice_admin_date(new Timestamp(System.currentTimeMillis()));
		
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		int noticeList_check = dbPro.noticeComplete(article);
		
		boolean onloadCheck = false;

		if (noticeList_check > 0) {
			onloadCheck = true; // reflash 여부 결정
		}

		request.setAttribute("noticeList_check", noticeList_check);
		request.setAttribute("notice_onloadCheck", onloadCheck);

		return "/HoneyComb/admin/complete/complete_comNotice_admin.jsp";
	}

}
