package chatting_Controll;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wsapp.Chat_Conversation_DBBean;
import wsapp.Chat_Conversation_DataBean;

public class Chat_Select_OneNone implements CommandAction_Chatting {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		String chat_num = (String)request.getParameter("chat_Num");
		String chat_mem_name = (String)request.getParameter("chat_mem_name");
		String chat_Member_Participation = (String)request.getParameter("chat_Member_Participation");
		String last_Chat_Date = (String)request.getParameter("last_Chat_Date");
		String last_Chat_Conversation = (String)request.getParameter("last_Chat_Conversation");
		String chat_partner=(String)request.getParameter("chat_partner");
		
		
		ArrayList<Chat_Conversation_DataBean> list  = new ArrayList<Chat_Conversation_DataBean>();
		List<ChatRoomDataBean> view_list= new ArrayList<ChatRoomDataBean>();
		
		
		Chatting_DBBean cdbb = Chatting_DBBean.getInstance();
		Chat_Conversation_DBBean ccdbb  = Chat_Conversation_DBBean.getInstance();
		
		list = ccdbb.view_Chat_Conversation(Integer.parseInt(chat_num));
		
		
		String check_Multi = new String(chat_Member_Participation);
		
		if(check_Multi.contains(",")){
			
		System.out.println("멀티 액션 실행");
			
		List checklist = new ArrayList<String>();
		checklist = ccdbb.select_False_Chat(Integer.parseInt(chat_num));
		
		StringTokenizer stokcheck = new StringTokenizer((String)checklist.get(1) , ",");
		
		int room_num = 1;
		int multi_check = 0;
		
		StringTokenizer another_stokcheck = new StringTokenizer(check_Multi, ",");
		
		while(another_stokcheck.hasMoreTokens()){
			another_stokcheck.nextToken();
			room_num++;
		}
		
		
		
		System.out.println("(String)checklist.get(1)::::::::::::"+(String)checklist.get(1));
		while(stokcheck.hasMoreTokens()){
			String temp = stokcheck.nextToken();
			System.out.println("temp::::::"+temp);
			if(temp.equals(String.valueOf(mem_num))){
				multi_check=1;
			}
			
		}
		stokcheck = new StringTokenizer((String)checklist.get(1) , ",");
		if(multi_check==0){
			
			ccdbb.check_MultiRead_Msg(Integer.parseInt(chat_num),mem_num);
			checklist = ccdbb.select_False_Chat(Integer.parseInt(chat_num));
			
			
			if(stokcheck.countTokens()>=room_num){
				ccdbb.Read_Msg(Integer.parseInt(chat_num));
			}
		}
		
		if(stokcheck.countTokens()>=room_num){
			ccdbb.Read_Msg(Integer.parseInt(chat_num));
		}

		System.out.println("방인원 체크 ::::"+room_num);
		
		System.out.println("읽은 사람 체크 ::::"+stokcheck.countTokens());
		}else{
		
		
		ccdbb.Read_Msg(Integer.parseInt(chat_num));
		
		}
		
		
		view_list=cdbb.view_My_chat(mem_num);
		
		System.out.println("chat_select_ononone class 입니다.");
		System.out.println("mem_num ::::"+mem_num);
		System.out.println("chat_num ::::"+chat_num);
		System.out.println("chat_mem_name ::::"+chat_mem_name);
		System.out.println("chat_Member_Participation ::::"+chat_Member_Participation);
		System.out.println("last_Chat_Date ::::"+last_Chat_Date);
		System.out.println("last_Chat_Conversation ::::"+last_Chat_Conversation);
		System.out.println("chat_partner ::::"+chat_partner);
		System.out.println("chat_select_ononone class 입니다.");
		
		
		
		
		
		
		request.getSession().setAttribute("current_chat_list", view_list);
		request.setAttribute("chat_Num", chat_num);
		request.setAttribute("chat_mem_name", chat_mem_name);
		request.setAttribute("chat_Member_Participation", chat_Member_Participation);
		request.setAttribute("chat_partner", chat_partner);
		
		
		
		request.setAttribute("before_chat_record", list);
		
		
		
		return "/Chatting/Chat_use.jsp";
	}

}
