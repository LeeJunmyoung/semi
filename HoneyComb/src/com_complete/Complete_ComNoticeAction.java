package com_complete;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class Complete_ComNoticeAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		System.out.println("Complete_ComNoticeAction 실행중");

		NoticeDataBean article = new NoticeDataBean();article.setNotice_title(request.getParameter("notice_title"));
		article.setNotice_content(request.getParameter("notice_content"));
		article.setNotice_member((String) request.getSession().getAttribute("name"));
		article.setCom_num((int) request.getSession().getAttribute("com_num"));
		article.setNotice_date(new Timestamp(System.currentTimeMillis()));

		NoticeDBBean dbPro = NoticeDBBean.getInstance();
		int notice_insert_count = dbPro.insertArticle(article); // 삽입된 row 갯수 호출

		boolean onloadCheck = false;

		if (notice_insert_count > 0) {
			onloadCheck = true; // reflash 여부 결정
		}
		
		System.out.println("오심");
		
		// 해당 view에서 사용할 속성
		request.setAttribute("notice_insert_count", notice_insert_count);
		request.setAttribute("notice_onloadCheck", onloadCheck);

		return "/page_layout/home.jsp";
	}

}
