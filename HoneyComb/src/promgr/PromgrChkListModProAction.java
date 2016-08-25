package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrChkListModProAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
		
		int list_num = Integer.parseInt(request.getParameter("list_num"));
		String list_name = String.valueOf(request.getParameter("promgr_list_title"));
		
		PromgrDBBean dbPro = PromgrDBBean.getInstance();
		int promgr_update_count = dbPro.modChkList(list_num, list_name);

		// 해당 view에서 사용할 속성
		request.setAttribute("promgr_update_count", promgr_update_count);

		return "/promgr/promgrPro.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
