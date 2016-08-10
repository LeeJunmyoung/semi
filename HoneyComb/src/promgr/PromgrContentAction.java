package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrContentAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {


		return "/proMgr/proMgrContent.jsp";

	} // String requestPro end

} // class ProMgrContentAction implements ProMgrFormAction end
