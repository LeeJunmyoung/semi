package chatting_Controll;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Chat_Main implements CommandAction_Chatting{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		List<ChatRoomDataBean> view_list= new ArrayList<ChatRoomDataBean>();
		Chatting_DBBean cdbb = Chatting_DBBean.getInstance();
		
		view_list=cdbb.view_My_chat(mem_num);
		
		
		
		
		request.getSession().setAttribute("current_chat_list", view_list);
		
		
		
		
		return "/Chatting/Chat_main.jsp";
	}

}
