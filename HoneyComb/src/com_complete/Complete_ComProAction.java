package com_complete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Complete_ComProAction implements CommandAction {
	// ����� ��Ͽ�û ���� �� CheckBox �ۼ� (�ӿ� -> ������)

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String com_name = request.getParameter("com_name");
		System.out.println("com_name ::::: " + com_name);
		
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		// com_name�� ��� �����͸� ���� (return List)
		List comList = null; // DBBean�� ����� �����͸� List�� ����
		comList = dbPro.com_permission(com_name);
		
		request.setAttribute("comList", comList);
/*		request.setAttribute("com_name", com_name);
		request.setAttribute("com_aff", com_aff);
		request.setAttribute("com_add", com_add);
		request.setAttribute("com_phone", com_phone);*/
		
		return "complete_comPro.jsp";
	}

}
