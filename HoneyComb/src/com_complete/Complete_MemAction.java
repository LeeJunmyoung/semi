package com_complete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bean.HoneyCombDBBean;

public class Complete_MemAction implements CommandAction {
	// 회사 등록요청 승인 폼 CheckBox 작성 (사원 -> 임원)

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String com_name = request.getParameter("com_name");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String com_dept_name = request.getParameter("com_dept_name");
		String com_pos_name = request.getParameter("com_pos_name");
		
		HoneyCombDBBean dbPro = HoneyCombDBBean.getInstance();
		// complete_mem테이블에 저장된 데이터를 가져오는 쿼리작성 (return List)
		List comList = null; // DBBean에 저장된 데이터를 List에 저장
		
		request.setAttribute("com_name", com_name);
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("com_dept_name", com_dept_name);
		request.setAttribute("com_pos_name", com_pos_name);
		/*request.setAttribute("comList", comList);*/ // List
		
		
		return "";
	}

}
