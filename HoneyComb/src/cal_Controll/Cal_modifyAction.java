/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package cal_Controll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cal_Controll.CommandAction;

public class Cal_modifyAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		Cal_DataBean cdb = new Cal_DataBean();
		Cal_DBBean caldbb = Cal_DBBean.getInstance();
		String title = request.getParameter("title");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String contents = request.getParameter("contents");
		
		
		int number = Integer.parseInt(request.getParameter("cal_num"));
		cdb.setCal_subject(title);
		cdb.setCal_start(this.fomatToDate(startDate));
		cdb.setCal_end(this.fomatToDate(endDate));
		cdb.setCal_contents(contents);
		cdb.setCal_num(number);
		caldbb.modify(cdb);
		List totalCal = caldbb.viewCal(mem_num);
		if (totalCal != null) {
			request.getSession().setAttribute("total", totalCal);
			request.getSession().setAttribute("count", Integer.valueOf(totalCal.size()));
		}

		return "/Calendar/CloseFrame.jsp";
	}

	public Date fomatToDate(String time) {
		Date date = null;

		try {
			SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd");
			date = e.parse(time);
		} catch (ParseException arg3) {
			arg3.printStackTrace();
		}

		return date;
	}
}