package wsapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Chat_Conversation_DBBean {
	private static Chat_Conversation_DBBean instance = new Chat_Conversation_DBBean();
	
	private Connection getConnetcion() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public static Chat_Conversation_DBBean getInstance(){
		return instance;
	}
	
	public void insert_Chat_Conversation(int chat_Num,String chat_User,String chat_Conversation,String chat_Date){
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = getConnetcion();
			pstmt = conn.prepareStatement("insert into chat_conversation(chat_num,chat_user,chat_conversation,chat_date,chat_sequence) values (?,?,?,?,chat_seq.nextval)");
			pstmt.setInt(1, chat_Num);
			pstmt.setString(2, chat_User);
			pstmt.setString(3, chat_Conversation);
		    pstmt.setString(4, chat_Date);
			
			
			pstmt.executeUpdate();
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {


			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}

		}
		
	
		
		
	}
	
	public ArrayList view_Chat_Conversation(int chat_Num){
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Chat_Conversation_DataBean> list = null;
		Chat_Conversation_DataBean chat_data = null;
		try {
			conn = getConnetcion();
			pstmt = conn.prepareStatement("select * from CHAT_CONVERSATION where chat_num = ? order by chat_sequence ASC ");
			pstmt.setInt(1, chat_Num);
		
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				list  =new ArrayList<Chat_Conversation_DataBean>();
				do{
					chat_data = new Chat_Conversation_DataBean();
					
					
					chat_data.setChat_Conversation(rs.getString("chat_conversation"));
					chat_data.setChat_Date(rs.getString("chat_date"));
					chat_data.setChat_User(rs.getString("chat_user"));
					
					list.add(chat_data);
					
					
					
				}while(rs.next());
				
		
				
				
			}
			
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {


			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}

		} if(rs !=null){
			try{
				rs.close();
			}catch(SQLException ex){
				
			}
			
		}
		
	
		return list;
		
	}
	
	
}

