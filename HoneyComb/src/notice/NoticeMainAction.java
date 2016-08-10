package notice;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeMainAction implements NoticeFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int rowSize = 5; // 한 페이지의 글 갯수
		int notice_count = 0; // 전체 글 갯수
		int com_num = (int) request.getSession().getAttribute("com_num"); // 회사 번호
		
		List articleList = null;
		NoticeDBBean dbPro = NoticeDBBean.getInstance(); // DB처리
		notice_count = dbPro.getArticleCount(com_num); // row 갯수 호출

		if (notice_count > 0) {

			// 현재 페이지에 해당하는 글 목록
			articleList = dbPro.getArticles(com_num, -1, rowSize);
			
		} else {
			articleList = Collections.EMPTY_LIST;
		}

		// 해당 view에서 사용할 속성
		request.setAttribute("notice_count", new Integer(notice_count));
		request.setAttribute("articleList", articleList);

		return "/notice/noticeMain.jsp";

	} // String requestPro end

} // class NoticeMainAction implements FormAction end
