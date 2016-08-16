package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrChkListAddItemFormAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String promgr_num = String.valueOf(request.getParameter("promgr_num"));
		String title = String.valueOf(request.getParameter("chklist_title"));

		request.setAttribute("promgr_num", promgr_num);
		request.setAttribute("title", title);

		return "/promgr/promgrChkListAddItemForm.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
