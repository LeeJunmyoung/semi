/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package cal_Controll;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cal_Controll.CommandAction;

public class Cal_delAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		Cal_DBBean caldbb = Cal_DBBean.getInstance();
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		int num = Integer.parseInt(request.getParameter("number"));
		System.out.println(num);
		caldbb.delete(num);
		
		List totalCal = new ArrayList<>();
				
				
		totalCal = caldbb.viewCal(mem_num);
				
		if (totalCal != null) {
			
			request.getSession().setAttribute("total", totalCal);
			request.getSession().setAttribute("count", Integer.valueOf(totalCal.size()));
			
		}
        
		return "CloseFrame.jsp";
	}
}