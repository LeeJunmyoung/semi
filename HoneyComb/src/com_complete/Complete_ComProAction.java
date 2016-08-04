package com_complete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Complete_ComProAction implements CommandAction {
	// 사업장 등록요청 승인 폼 CheckBox 작성 (임원 -> 관리자)

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String com_name = request.getParameter("com_name");
		System.out.println("com_name ::::: " + com_name);
		
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		// com_name의 모든 데이터를 저장 (return List)
		List comList = null; // DBBean에 저장된 데이터를 List에 저장
		comList = dbPro.com_permission(com_name);
		
		request.setAttribute("comList", comList);
/*		request.setAttribute("com_name", com_name);
		request.setAttribute("com_aff", com_aff);
		request.setAttribute("com_add", com_add);
		request.setAttribute("com_phone", com_phone);*/
		
		return "complete_comPro.jsp";
	}

}
