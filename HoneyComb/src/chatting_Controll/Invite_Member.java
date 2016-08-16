package chatting_Controll;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogInDB.LogOnDataBean;

public class Invite_Member implements CommandAction_Chatting {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String[] invite_mem_num = null;
		Chatting_DBBean cdbb = null;
		String chat_mem_num = null; // 채팅방에 들어가 잇는 인원 표시
		List<ChatRoomDataBean> view_list = new ArrayList<ChatRoomDataBean>();
		int my_mem_num = (int) request.getSession().getAttribute("mem_num");

		if (request.getParameterValues("check") != null) {
			invite_mem_num = request.getParameterValues("check");

		}

		if (invite_mem_num == null) {
			// 수정이 필요하지만 귀찮아서 하지 않겟습니다.

			int com_num = (int) request.getSession().getAttribute("com_num");
			int mem_num = (int) request.getSession().getAttribute("mem_num");
			ArrayList<LogOnDataBean> list = new ArrayList<>();

			Chatting_DBBean chatdb = Chatting_DBBean.getInstance();
			list = chatdb.view_Com_Member(mem_num, com_num);

			request.setAttribute("chat_members", list);

			return "/Chatting/Invite_form.jsp";
		} // 체크값이없을때 걍 돌아가기

		if (invite_mem_num.length == 1) {
			cdbb = Chatting_DBBean.getInstance();
			if (Integer.parseInt(invite_mem_num[0]) > my_mem_num) {// 초대 인원이
																	// memnum 이
																	// 자신보다 크면
																	// 그대로 저장

				chat_mem_num = "" + String.valueOf(my_mem_num) + "n" + invite_mem_num[0];

			} else {// 나보다 작다면 스왑 후 저장

				chat_mem_num = "" + invite_mem_num[0] + "n" + String.valueOf(my_mem_num);

			} // 초대인원 숫자크기에 의한 정렬

			if (cdbb.check_OneNOne_Chat(chat_mem_num)) {

				cdbb.create_OneNOne_Chat(chat_mem_num);

			} else {
				view_list = cdbb.view_My_chat(my_mem_num);
				request.getSession().setAttribute("current_chat_list", view_list);
				
				
				int chat_num = 0;
				String chat_mem_name = "";
				String chat_Member_Participation = "";
				String last_Chat_Date = "";
				String last_Chat_Conversation = "";
				
				
				for (ChatRoomDataBean chat : view_list) {

					if (chat.getChat_Member_Participation().equals(invite_mem_num[0])) {
						chat_num = chat.getChat_Num();
						chat_mem_name = chat.getChat_mem_name();
						chat_Member_Participation = chat.getChat_Member_Participation();
						last_Chat_Date = chat.getLast_Chat_Date();
						last_Chat_Conversation = chat.getLast_Chat_Conversation();
					}
					
					
					
					
					System.out.println("chat_num:::" + chat_num);
					System.out.println("chat_mem_name:::" + chat_mem_name);
					System.out.println("chat_Member_Participation:::" + chat_Member_Participation);
					System.out.println("last_Chat_Date:::" + last_Chat_Date);
					System.out.println("last_Chat_Conversation:::" + last_Chat_Conversation);
					System.out.println("invite_mem_num[0] ::::" +invite_mem_num[0]);
				}
				
				
				request.setAttribute("chat_Num", chat_num);
				request.setAttribute("chat_mem_name", chat_mem_name);
				request.setAttribute("chat_Member_Participation", chat_Member_Participation);

			

				return "/Chatting/Existed_Chat.jsp";

			}

			view_list = cdbb.view_My_chat(my_mem_num);

			request.getSession().setAttribute("current_chat_list", view_list);

			return "/Chatting/Invite_pro.jsp";
		} 
		
		
		
		
		// 1명 선택시

		/*
		 * 다중채팅 일경우 chat_mem_num = ""+String.valueOf(my_mem_num)+","; for (int i
		 * = 0; i < invite_mem_num.length; i++) {
		 * 
		 * chat_mem_num = chat_mem_num + invite_mem_num[i]; if (i <
		 * invite_mem_num.length - 1) { chat_mem_num = chat_mem_num + ","; } }
		 * 
		 * cdbb.create_OneNOne_Chat(chat_mem_num);
		 * 
		 * 
		 * System.out.println("chat_mem_num : "+chat_mem_num);
		 * 
		 */

		return "/Chatting/Chat_main.jsp";
	}

}
