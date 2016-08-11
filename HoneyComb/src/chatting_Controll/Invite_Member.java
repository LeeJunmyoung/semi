package chatting_Controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Invite_Member implements CommandAction_Chatting {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		String[] invite_mem_num = request.getParameterValues("check");
		int my_mem_num = (int)request.getSession().getAttribute("mem_num");
		
		
		if (invite_mem_num.length == 0) {
			return "/HoneyComb/Chatting/Invite_form.jsp";
		}
		String chat_mem_num = "";

		for (int i = 0; i < invite_mem_num.length; i++) {
			chat_mem_num = chat_mem_num + invite_mem_num[i];
			if (i < invite_mem_num.length - 1) {
				chat_mem_num = chat_mem_num + ",";
			}
		}
		
		
		
		
		
		return null;
	}

}
