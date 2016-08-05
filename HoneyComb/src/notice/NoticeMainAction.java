package notice;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeMainAction implements NoticeFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int rowSize = 5; // 한 페이지의 글 갯수
		int count = 0; // 전체 글 갯수

		List articleList = null;
		NoticeDBBean dbPro = NoticeDBBean.getInstance(); // DB처리
		count = dbPro.getArticleCount(); // row 갯수 호출

		if (count > 0) {

			// 현재 페이지에 해당하는 글 목록
			articleList = dbPro.getArticles(-1, rowSize);
			
		} else {
			articleList = Collections.EMPTY_LIST;
		}

		// 해당 view에서 사용할 속성
		request.setAttribute("count", new Integer(count));
		request.setAttribute("articleList", articleList);

		return "/notice/noticeMain.jsp";

	} // String requestPro end

} // class NoticeMainAction implements FormAction end
