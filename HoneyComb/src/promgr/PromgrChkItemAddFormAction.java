package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrChkItemAddFormAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String promgr_num = String.valueOf(request.getParameter("promgr_num"));
		int title_num = Integer.parseInt(request.getParameter("chklist_title"));

		request.setAttribute("promgr_num", promgr_num);
		request.setAttribute("title_num", title_num);

		return "/promgr/promgrChkItemAddForm.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
