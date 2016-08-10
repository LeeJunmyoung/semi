package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrMainAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		return "/promgr/promgrMain.jsp";
		
	} // String requestPro end

} // class ProMgrMainAction implements ProMgrFormAction end
