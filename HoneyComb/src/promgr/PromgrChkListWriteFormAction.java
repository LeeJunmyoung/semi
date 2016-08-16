package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrChkListWriteFormAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String promgr_num = String.valueOf(request.getParameter("promgr_num"));

		request.setAttribute("promgr_num", promgr_num);

		return "/promgr/promgrChkListWriteForm.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
