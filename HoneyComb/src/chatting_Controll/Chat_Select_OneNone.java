package chatting_Controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Chat_Select_OneNone implements CommandAction_Chatting {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String chat_num = (String)request.getParameter("chat_Num");
		String chat_mem_name = (String)request.getParameter("chat_mem_name");
		String chat_Member_Participation = (String)request.getParameter("chat_Member_Participation");
		String last_Chat_Date = (String)request.getParameter("last_Chat_Date");
		String last_Chat_Conversation = (String)request.getParameter("last_Chat_Conversation");
		
		
		
		
		System.out.println("chat_Num:::"+chat_num);
		System.out.println("chat_mem_name:::"+chat_mem_name);
		System.out.println("chat_Member_Participation:::"+chat_Member_Participation);
		System.out.println("last_Chat_Date:::"+last_Chat_Date);
		System.out.println("last_Chat_Conversation:::"+last_Chat_Conversation);
		
		
		request.setAttribute("chat_Num", chat_num);
		request.setAttribute("chat_mem_name", chat_mem_name);
		request.setAttribute("chat_Member_Participation", chat_Member_Participation);
		
		
		
		
		
		return "/Chatting/Chat_Use_Form.jsp";
	}

}
