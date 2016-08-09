/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package cal_Controll;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cal_Controll.CommandAction;

public class Cal_viewMainAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		Cal_DBBean caldbb = Cal_DBBean.getInstance();
		List totalCal = null;
		totalCal = caldbb.viewCal(mem_num);
		if (totalCal != null) {
			request.getSession().setAttribute("total", totalCal);
			request.getSession().setAttribute("count", Integer.valueOf(totalCal.size()));
		}

		return "cal_main.jsp";
	}
}