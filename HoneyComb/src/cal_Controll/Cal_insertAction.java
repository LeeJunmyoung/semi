/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package cal_Controll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cal_Controll.CommandAction;

public class Cal_insertAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		int com_num =(int) request.getSession().getAttribute("com_num");
		int com_dept_num = (int) request.getSession().getAttribute("com_dept_num");
		
		
		Cal_DataBean cdb = new Cal_DataBean();
		Cal_DBBean caldbb = Cal_DBBean.getInstance();
		List totalCal = null;
		String startDate = "";
		String endDate = "";
		String contents = "";
		
		totalCal = new ArrayList<>();
		
			startDate = request.getParameter("startDate");
			endDate = request.getParameter("endDate");
			contents = request.getParameter("contents");
			cdb.setCal_subject(request.getParameter("title"));
			cdb.setCal_start(this.fomatToDate(startDate));
			cdb.setCal_end(this.fomatToDate(endDate));
			cdb.setCal_contents(contents);
			caldbb.insertCal(cdb,mem_num,com_num,com_dept_num);
			
	

	
		totalCal = caldbb.viewCal(mem_num);
		if (totalCal != null) {
			request.getSession().setAttribute("total", totalCal);
			request.getSession().setAttribute("count", Integer.valueOf(totalCal.size()));
		}

		return "/page_layout/Calendar/Calendar_home.jsp";
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