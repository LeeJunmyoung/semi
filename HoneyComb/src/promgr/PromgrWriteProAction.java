package promgr;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class PromgrWriteProAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		PromgrDataBean article = new PromgrDataBean();
		article.setPromgr_name(request.getParameter("promgr_title"));
		article.setPromgr_content(request.getParameter("promgr_content"));
		article.setPromgr_date(new Timestamp(System.currentTimeMillis()));
		article.setMem_num(String.valueOf(request.getSession().getAttribute("mem_num")));
		article.setCom_num((int) request.getSession().getAttribute("com_num"));

		PromgrDBBean dbPro = PromgrDBBean.getInstance();
		int promgr_insert_count = dbPro.insertPromgr(article); // 삽입된 row 갯수 호출

		// 해당 view에서 사용할 속성
		request.setAttribute("promgr_insert_count", promgr_insert_count);

		return "/promgr/promgrWritePro.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
