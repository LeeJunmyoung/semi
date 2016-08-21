package promgr;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;

public class PromgrMainAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int rowSize = 5; // 한 페이지의 글 갯수
		int promgr_count = 0; // 전체 글 갯수
		int com_num = (int) request.getSession().getAttribute("com_num");
		int mem_num = (int) request.getSession().getAttribute("mem_num");

		List articleList = null;
		PromgrDBBean dbPro = PromgrDBBean.getInstance(); // DB처리
		promgr_count = dbPro.getPromgrCount(com_num, mem_num); // row 갯수 호출

		if (promgr_count > 0) {

			// 현재 페이지에 해당하는 글 목록
			articleList = dbPro.getPromgrList(com_num, mem_num, -1, rowSize);

		} else {
			articleList = Collections.EMPTY_LIST;
		}

		// 해당 view에서 사용할 속성
		request.setAttribute("promgr_count", promgr_count);
		request.setAttribute("articleList", articleList);

		return "/promgr/promgrMain.jsp";

	} // String requestPro end

} // class ProMgrMainAction implements ProMgrFormAction end
