package promgr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrMemberEditorFormAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int promgr_num = Integer.parseInt(request.getParameter("promgr_num"));
		
		List memberList = null;
		PromgrDBBean dbPro = PromgrDBBean.getInstance(); // DB처리
		
		memberList = dbPro.getDataList(promgr_num, "mem_num");
		
		// 해당 view에서 사용할 속성
		request.setAttribute("memberList", memberList);

		return "/promgr/PromgrMemberEditorForm.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
