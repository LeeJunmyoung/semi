package promgr;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class PromgrCommentAddProAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		CommentDataBean article = new CommentDataBean();

		article.setComment_content(String.valueOf(request.getParameter("promgr_comment")));
		article.setMem_num((int) request.getSession().getAttribute("mem_num"));
		article.setPromgr_num(Integer.parseInt(request.getParameter("promgr_num")));
		article.setCom_num((int) request.getSession().getAttribute("com_num"));

		PromgrDBBean dbPro = PromgrDBBean.getInstance();
		int promgr_insert_count = dbPro.addComment(article);

		// 해당 view에서 사용할 속성
		request.setAttribute("promgr_insert_count", promgr_insert_count);

		return "/promgr/promgrPro.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
