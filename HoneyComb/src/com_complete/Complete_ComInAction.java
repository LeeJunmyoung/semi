package com_complete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Complete_ComInAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("InAction 실행1");
		int com_num = Integer.parseInt(request.getParameter("com_num"));
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		List comList = null;
		comList = dbPro.insertComplete(com_num);

		request.setAttribute("comList", comList);
		System.out.println("InAction 실행2");
		
		return "/admin/complete/complete_comIn.jsp";
		
	}

}
