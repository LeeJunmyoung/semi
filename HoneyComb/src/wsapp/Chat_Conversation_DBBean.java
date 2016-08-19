package wsapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chatting_Controll.ChatRoomDataBean;

public class Chat_Conversation_DBBean {
	private static Chat_Conversation_DBBean instance = new Chat_Conversation_DBBean();
	
	private Connection getConnetcion() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public static Chat_Conversation_DBBean getInstance(){
		return instance;
	}
	
	public void insert_Chat_Conversation(int chat_Num,String chat_User,String chat_Conversation,String chat_Date,String chat_User_Name){
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = getConnetcion();
			pstmt = conn.prepareStatement("insert into chat_conversation(chat_num,chat_user,chat_conversation,chat_date,chat_sequence,chat_user_name) values (?,?,?,?,chat_seq.nextval,?)");
			pstmt.setInt(1, chat_Num);
			pstmt.setString(2, chat_User);
			pstmt.setString(3, chat_Conversation);
		    pstmt.setString(4, chat_Date);
		    pstmt.setString(5, chat_User_Name);
			
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
					chat_data.setChat_User_Name(rs.getString("chat_user_name"));
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
	
	public void check_Read_Msg(int chat_num,int mem_num){
		Connection conn = null;
		PreparedStatement pstmt = null;

	
		try {
			conn = getConnetcion();
			pstmt = conn.prepareStatement("update CHAT set last_chat_read = ? ,last_chat_member = ?  where chat_num = ?  ");
			pstmt.setString(1, "f");
			
			pstmt.setInt(2, mem_num);
			pstmt.setInt(3, chat_num);
			
			
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
	public void check_Read_Msg(int chat_num,String mem_num){
		Connection conn = null;
		PreparedStatement pstmt = null;

	
		try {
			conn = getConnetcion();
			pstmt = conn.prepareStatement("update CHAT set last_chat_read = ? ,last_chat_member = ?  where chat_num = ?  ");
			pstmt.setString(1, "f");
			
			pstmt.setString(2, mem_num);
			pstmt.setInt(3, chat_num);
			
			
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
	
	public void check_MultiRead_Msg(int chat_num,int mem_num){
		Connection conn = null;
		PreparedStatement pstmt = null;

	
		try {
			conn = getConnetcion();
			pstmt = conn.prepareStatement("update CHAT set last_chat_read = ? ,last_chat_member = concat((select last_chat_member from chat where chat_num = ?), ? )  where chat_num = ?  ");
			pstmt.setString(1, "f");
			pstmt.setInt(2, chat_num);
			
			pstmt.setString(3,String.valueOf(mem_num)+"," );
			pstmt.setInt(4, chat_num);
			
			
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
	
	
	
	
	
	public void Read_Msg(int chat_num){
		Connection conn = null;
		PreparedStatement pstmt = null;

	
		try {
			conn = getConnetcion();
			pstmt = conn.prepareStatement("update CHAT set last_chat_member = ',' ,last_chat_read = ?  where chat_num = ?  ");
			pstmt.setString(1, "t");
			
		
			pstmt.setInt(2, chat_num);
			
			
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
	
	
	
	public List view_Not_Read_Msg(int mem_num){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String memNum="";
		String query="";
		try {
			conn = getConnetcion();
			memNum=String.valueOf(mem_num);
			pstmt = conn.prepareStatement("select chat_num where chat_member_participation like ? ");
			pstmt.setString(1, "%"+memNum+"%");
			
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				do{
					
					
					
					
					
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

		} 
		
		
		
		return null;
	}
	
	public List select_False_Chat(int chat_num){
		

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List list = new ArrayList<String>();
		try {
			
			
			conn = getConnetcion();
			pstmt = conn.prepareStatement("select last_chat_read,last_chat_member from chat where chat_num = ?  ");
			pstmt.setInt(1, chat_num);
			
			
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				list.add(rs.getString(1));
				list.add(rs.getString(2));
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
			
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}

		} 
		
		
		return list;
		
		
		
		
	}
	
	
	
	
}

