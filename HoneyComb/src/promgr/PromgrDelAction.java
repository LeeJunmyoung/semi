package promgr;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class PromgrDelAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		String promgr_num = request.getParameter("promgr_num");
		int com_num = (int) request.getSession().getAttribute("com_num");

		PromgrDBBean dbPro = PromgrDBBean.getInstance();
		int promgr_update_count = dbPro.deletePromgr(promgr_num, com_num);

		// 해당 view에서 사용할 속성
		request.setAttribute("promgr_update_count", promgr_update_count);

		return "/promgr/promgrPro.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
