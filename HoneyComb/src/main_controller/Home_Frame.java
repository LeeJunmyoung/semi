package main_controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cal_Controll.Cal_DBBean;
import notice.NoticeDBBean;
import promgr.PromgrDBBean;

public class Home_Frame implements Layout_CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		
		
		
		
		int mem_num = (int) request.getSession().getAttribute("mem_num");
	
		int com_num =(int) request.getSession().getAttribute("com_num");

		int com_dept_num = (int) request.getSession().getAttribute("com_dept_num");

		int com_pos_num = (int) request.getSession().getAttribute("com_pos_num");
		
		String name = (String) request.getSession().getAttribute("name");	
		
		String email = (String) request.getSession().getAttribute("email");
		
		String phone_num = (String) request.getSession().getAttribute("phone_num");
		
		String com_name =  (String) request.getSession().getAttribute("com_name");

		String com_dept_name =  (String) request.getSession().getAttribute("com_dept_name");	
		
		String com_pos_name =  (String) request.getSession().getAttribute("com_pos_name");
	
		
		

		int rowSize = 5; // 한 페이지의 글 갯수
		int count = 0; // 전체 글 갯수

		List articleList = null;
		NoticeDBBean dbPro = NoticeDBBean.getInstance(); // DB처리
		int notice_count = dbPro.getArticleCount(com_num); // row 갯수 호출

		if (notice_count > 0) {

			// 현재 페이지에 해당하는 글 목록
			articleList = dbPro.getArticles(com_num, -1, rowSize);
			
		} else {
			articleList = Collections.EMPTY_LIST;
		}

		// 해당 view에서 사용할 속성
		request.getSession().setAttribute("notice_count", new Integer(notice_count));
		request.getSession().setAttribute("articleList", articleList);

		
		/*위에 공지사항 받는 부분 */
		
		Date date = new Date();
		int month = date.getMonth()+1;
		
		
		Cal_DBBean caldbb = Cal_DBBean.getInstance();
		List totalCal = null;
		totalCal = caldbb.viewCal(mem_num);
		if (totalCal != null) {
			request.getSession().setAttribute("total", totalCal);
			request.getSession().setAttribute("count", Integer.valueOf(totalCal.size()));
		}
		
		/*일정 받는 부분 */
		
		
		
		int pro_rowSize = 5; // 한 페이지의 글 갯수
		int promgr_count = 0; // 전체 글 갯수
		int pro_com_num = (int) request.getSession().getAttribute("com_num");
		int pro_mem_num = (int) request.getSession().getAttribute("mem_num");

		List pro_articleList = null;
		PromgrDBBean pro_dbPro = PromgrDBBean.getInstance(); // DB처리
		promgr_count =  pro_dbPro.getPromgrCount(com_num, mem_num); // row 갯수 호출

		if (promgr_count > 0) {

			// 현재 페이지에 해당하는 글 목록
			articleList =  pro_dbPro.getPromgrList(com_num, mem_num, -1, rowSize);

		} else {
			articleList = Collections.EMPTY_LIST;
		}

		// 해당 view에서 사용할 속성
		request.setAttribute("promgr_count", promgr_count);
		request.setAttribute(" pro_articleList",  pro_articleList);

		/* 프로젝트 매니저 받는 부분
		*/
		return "/page_layout/home.jsp";
	}

}
