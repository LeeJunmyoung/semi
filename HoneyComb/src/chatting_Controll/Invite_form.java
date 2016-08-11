package chatting_Controll;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogInDB.LogOnDataBean;

public class Invite_form implements CommandAction_Chatting{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int com_num = (int)request.getSession().getAttribute("com_num");
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		ArrayList<LogOnDataBean> list = new ArrayList<>();
		
		Chatting_DBBean chatdb = Chatting_DBBean.getInstance();
		list = chatdb.view_Com_Member(mem_num,com_num);
		
		request.setAttribute("chat_members", list);
		
		return "/Chatting/Invite_form.jsp";
	}

}
