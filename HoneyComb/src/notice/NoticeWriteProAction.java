package notice;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeWriteProAction implements FormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		NoticeDataBean article = new NoticeDataBean();
		article.setNotice_title(request.getParameter("notice_title"));
		article.setNotice_content(request.getParameter("notice_content"));
		article.setNotice_member("suna"); // 사용자 정보(이름) 속성 값
		article.setNotice_date(new Timestamp(System.currentTimeMillis()));
 
		NoticeDBBean dbPro = NoticeDBBean.getInstance();
		int count = dbPro.insertArticle(article); // 삽입된 row 갯수 호출
		
		boolean onloadCheck = false;
		
		if(count > 0) {
			onloadCheck = true; // reflash 여부 결정
		}

		// 해당 view에서 사용할 속성
		request.setAttribute("count", count);
		request.setAttribute("onloadCheck", onloadCheck);

		return "/notice/noticeWritePro.jsp";

	} // String requestPro end

} // class NoticeMainAction implements FormAction end
