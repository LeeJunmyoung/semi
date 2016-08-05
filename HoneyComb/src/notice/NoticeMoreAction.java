package notice;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeMoreAction implements FormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNum = request.getParameter("pageNum"); // 해당 페이지 번호

		if (pageNum == null) {
			pageNum = "1";
		}

		int pageSize = 5; // 한 페이지의 글 개수
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1; // 한 페이지의 시작 글 번호
		int endRow = 0;
		endRow = currentPage * pageSize; // 한 페이지의 마지막 글 번호

		int count = 0; // row 갯수
		int number = 0;

		List articleList = null;
		NoticeDBBean dbPro = NoticeDBBean.getInstance(); // DB처리
		count = dbPro.getArticleCount(); // row 갯수 호출

		if (count > 0) {
			// 현재 페이지에 해당하는 글 목록
			articleList = dbPro.getArticles(startRow, endRow);
		} else {
			articleList = Collections.EMPTY_LIST;
		}

		number = count - (currentPage - 1) * pageSize; // 글 목록에 표시할 글 번호

		// 해당 view에서 사용할 속성
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);

		return "/notice/noticeMore.jsp";

	} // String requestPro end

} // class NoticeMoreAction implements FormAction end
