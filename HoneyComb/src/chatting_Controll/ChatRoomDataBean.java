package chatting_Controll;

public class ChatRoomDataBean {
	private int chat_Num;
	private String chat_mem_name;
	private String chat_Member_Participation;
	private String last_Chat_Date;
	private String last_Chat_Conversation;
	private String chat_partner;
	
	public String getChat_partner() {
		return chat_partner;
	}
	public void setChat_partner(String chat_partner) {
		this.chat_partner = chat_partner;
	}
	public int getChat_Num() {
		return chat_Num;
	}
	public void setChat_Num(int chat_Num) {
		this.chat_Num = chat_Num;
	}
	public String getChat_mem_name() {
		return chat_mem_name;
	}
	public void setChat_mem_name(String chat_mem_name) {
		this.chat_mem_name = chat_mem_name;
	}
	public String getChat_Member_Participation() {
		return chat_Member_Participation;
	}
	public void setChat_Member_Participation(String chat_Member_Participation) {
		this.chat_Member_Participation = chat_Member_Participation;
	}
	public String getLast_Chat_Date() {
		return last_Chat_Date;
	}
	public void setLast_Chat_Date(String last_Chat_Date) {
		this.last_Chat_Date = last_Chat_Date;
	}
	public String getLast_Chat_Conversation() {
		return last_Chat_Conversation;
	}
	public void setLast_Chat_Conversation(String last_Chat_Conversation) {
		this.last_Chat_Conversation = last_Chat_Conversation;
	}
}
