package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrChkItemAddFormAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String promgr_num = String.valueOf(request.getParameter("promgr_num"));
		int list_num = Integer.parseInt(request.getParameter("list_num"));

		request.setAttribute("promgr_num", promgr_num);
		request.setAttribute("list_num", list_num);

		return "/promgr/promgrChkItemAddForm.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
