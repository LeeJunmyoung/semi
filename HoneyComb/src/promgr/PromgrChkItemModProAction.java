package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jmx.snmp.Timestamp;

public class PromgrChkItemModProAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int item_num = Integer.parseInt(request.getParameter("item_num"));
		String item_name = String.valueOf(request.getParameter("promgr_list_item"));

		PromgrDBBean dbPro = PromgrDBBean.getInstance();
		int promgr_update_count = dbPro.modChkItem(item_num, item_name);

		// 해당 view에서 사용할 속성
		request.setAttribute("promgr_update_count", promgr_update_count);

		return "/promgr/promgrPro.jsp";

	} // String requestPro end

} // class PromgrChkListAddItemAction implements ProMgrFormAction end
