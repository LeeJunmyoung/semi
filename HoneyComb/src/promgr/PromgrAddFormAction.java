package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrAddFormAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		return "/promgr/promgrAddForm.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
