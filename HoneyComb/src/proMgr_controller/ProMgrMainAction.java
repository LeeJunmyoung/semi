package proMgr_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProMgrMainAction implements ProMgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 수정이는 나빴다
		
		return "/proMgr/proMgrMain.jsp";
		
	} // String requestPro end

} // class ProMgrMainAction implements FormAction end
