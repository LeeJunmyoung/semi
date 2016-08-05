package proMgr_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProMgrMainAction implements FormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		
		return "/proMgr/proMgrMain.jsp";
	}

} // class ProMgrMainAction implements FormAction end
