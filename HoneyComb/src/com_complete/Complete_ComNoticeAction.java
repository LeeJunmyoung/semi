package com_complete;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;
import notice.NoticeDataBean;

public class Complete_ComNoticeAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		NoticeDataBean article = new NoticeDataBean();
		article.setNotice_content(request.getParameter("notice_content"));
		article.setNotice_member((String) request.getSession().getAttribute("name"));
		article.setNotice_date(new Timestamp(System.currentTimeMillis()));
//		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		int noticeList_check = dbPro.noticeComplete(article);
		
		boolean onloadCheck = false;

		if (noticeList_check > 0) {
			onloadCheck = true; // reflash 여부 결정
		}

		request.setAttribute("noticeList_check", noticeList_check);
		request.setAttribute("notice_onloadCheck", onloadCheck);

		return "/HoneyComb/page_layout/main_body.jsp";
	}

}
