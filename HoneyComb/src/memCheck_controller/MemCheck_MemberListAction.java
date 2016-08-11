package memCheck_controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memCheck_bean.MemCheckDBBean;

public class MemCheck_MemberListAction implements CommandActionMemCheck {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int com_num = Integer.parseInt(request.getParameter("com_num"));

		MemCheckDBBean dbPro = MemCheckDBBean.getInstance();
		ArrayList comMemberList = new ArrayList<>();

		comMemberList = dbPro.comMemberList(com_num);

		request.setAttribute("com_num", com_num);
		request.setAttribute("comMemberList", comMemberList);

		return "/admin/memCheck/memCheck_MemberList.jsp";
	}

}
