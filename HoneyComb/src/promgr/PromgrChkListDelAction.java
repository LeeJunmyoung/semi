package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrChkListDelAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int promgr_num = Integer.parseInt(request.getParameter("promgr_num"));
		int title_num = Integer.parseInt(request.getParameter("chklist_title"));
		
		PromgrDBBean dbPro = PromgrDBBean.getInstance();
		int promgr_insert_count = dbPro.delchkTitle(promgr_num, title_num);

		// 해당 view에서 사용할 속성
		request.setAttribute("promgr_insert_count", promgr_insert_count);

		return "/promgr/promgrPro.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
