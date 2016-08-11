package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrMemberEditorProAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
//		boolean promgr_onloadCheck = false;
//
//		if (promgr_update_count > 0) {
//			promgr_onloadCheck = true; // reflash 여부 결정
//		}
//		
//		request.setAttribute("promgr_update_count", promgr_update_count);
//		request.setAttribute("promgr_onloadCheck", promgr_onloadCheck);
		
		return "/promgr/PromgrMemberEditorPro.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
