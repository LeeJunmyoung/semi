package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrChkListAddProAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		ChkListDataBean article = new ChkListDataBean();
		article.setChklist_title_name(String.valueOf(request.getParameter("promgr_list_title")));
		article.setPromgr_num(Integer.parseInt(request.getParameter("promgr_num")));
		article.setCom_num((int) request.getSession().getAttribute("com_num"));

		PromgrDBBean dbPro = PromgrDBBean.getInstance();
		int promgr_insert_count = dbPro.addChkList(article);

		// 해당 view에서 사용할 속성
		request.setAttribute("promgr_insert_count", promgr_insert_count);

		return "/promgr/promgrPro.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
