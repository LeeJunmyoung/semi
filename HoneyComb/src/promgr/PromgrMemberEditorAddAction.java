package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrMemberEditorAddAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		int promgr_num = Integer.parseInt(request.getParameter("promgr_num"));
		String[] add_mem_num = request.getParameterValues("mem_add");

		PromgrDBBean dbPro = PromgrDBBean.getInstance();
		int promgr_update_count = 0;

		if (add_mem_num != null) {
			promgr_update_count = dbPro.addMembers(promgr_num, add_mem_num);
		} else {

		}

		request.setAttribute("promgr_update_count", promgr_update_count);

		return "/promgr/promgrMemberEditorPro.jsp";

	} // String requestPro end

} // class PromgrMemberEditorAddAction implements ProMgrFormAction end
