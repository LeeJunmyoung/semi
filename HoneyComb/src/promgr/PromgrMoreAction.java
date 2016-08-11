package promgr;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;

public class PromgrMoreAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String pageNum = request.getParameter("pageNum"); // 해당 페이지 번호
		int com_num = (int) request.getSession().getAttribute("com_num"); // 회사 번호
		String mem_num = String.valueOf(request.getSession().getAttribute("mem_num")); // 회원 번호

		if (pageNum == null) {
			pageNum = "1";
		}

		int pageSize = 3; // 한 페이지의 프로젝트 개수
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1; // 한 페이지의 시작 프로젝트 번호
		int endRow = 0;
		endRow = currentPage * pageSize; // 한 페이지의 마지막 프로젝트 번호

		int promgr_count = 0; // row 갯수
		int number = 0;

		List articleList = null;
		PromgrDBBean dbPro = PromgrDBBean.getInstance(); // DB처리
		promgr_count = dbPro.getArticleCount(com_num, mem_num); // row 갯수 호출

		if (promgr_count > 0) {
			// 현재 페이지에 해당하는 프로젝트 목록
			articleList = dbPro.getArticles(com_num, mem_num, startRow, endRow);
		} else {
			articleList = Collections.EMPTY_LIST;
		}

		number = promgr_count - (currentPage - 1) * pageSize; // 프로젝트 목록에 표시할 프로젝트 번호

		// 해당 view에서 사용할 속성
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("promgr_count", new Integer(promgr_count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
		
		return "/promgr/promgrMore.jsp";
		
	} // String requestPro end
	
} // class ProMgrMoreAction implements ProMgrFormAction end
