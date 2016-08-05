package notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeContentAction implements FormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int num = Integer.parseInt(request.getParameter("num")); // 해당 글 번호

		NoticeDBBean dbPro = NoticeDBBean.getInstance(); // DB처리
		NoticeDataBean article = dbPro.getArticle(num); // 해당 글 번호에 대한 레코드

		// 해당 view에서 사용할 속성
		request.setAttribute("num", new Integer(num));
		request.setAttribute("article", article);

		return "/notice/noticeContent.jsp";

	} // String requestPro end

} // class NoticeContentAction implements FormAction end
