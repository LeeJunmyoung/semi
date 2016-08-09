package proMgr_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProMgrMoreAction implements ProMgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/proMgr/proMgrMore.jsp";
		
	} // String requestPro end
	
	

} // class NoticeMoreAction implements FormAction end
