package com_complete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Complete_MemAction implements CommandAction {
	// ȸ�� ��Ͽ�û ���� �� CheckBox �ۼ� (��� -> �ӿ�)

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String com_name = request.getParameter("com_name");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String com_dept_name = request.getParameter("com_dept_name");
		String com_pos_name = request.getParameter("com_pos_name");
		
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		// complete_mem���̺� ����� �����͸� �������� �����ۼ� (return List)
		List comList = null; // DBBean�� ����� �����͸� List�� ����
		
		request.setAttribute("com_name", com_name);
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("com_dept_name", com_dept_name);
		request.setAttribute("com_pos_name", com_pos_name);
		/*request.setAttribute("comList", comList);*/ // List
		
		
		return "";
	}

}
