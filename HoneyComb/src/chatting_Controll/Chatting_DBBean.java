package chatting_Controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import LogInDB.LogOnDBBean;
import LogInDB.LogOnDataBean;

public class Chatting_DBBean {

	private static Chatting_DBBean instance = new Chatting_DBBean();

	public static Chatting_DBBean getInstance() {
		return instance;

	}

	private Chatting_DBBean() {
	};

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	// 회사 멤버 초대하기 위한 메서드
	public ArrayList view_Com_Member(int mem_num, int com_num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LogOnDataBean ldb = null;
		ArrayList<LogOnDataBean> list = null;
		try {
			conn = getConnection();
			String sql = "select * from members where not mem_num = ? and com_num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			pstmt.setInt(2, com_num);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			if (rs.next()) {

				do {
					ldb = new LogOnDataBean();
					ldb.setMem_num(rs.getInt("mem_num"));
					ldb.setName(rs.getString("name"));
					ldb.setCom_dept_name(rs.getString("com_dept_name"));
					ldb.setCom_pos_name(rs.getString("com_pos_name"));

					list.add(ldb);
				} while (rs.next());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public void create_OneNOne_Chat(String chat_mem_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		
		try {
			conn = getConnection();
			String sql = "insert into chat(chat_num,chat_member_participation) values ( OneNOneChat.nextval , ? )";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chat_mem_num);
			
			
			pstmt.executeUpdate();
		
		

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public boolean check_OneNOne_Chat(String chat_mem_num){

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	
		try {
			conn = getConnection();
			String sql = "select * from chat where chat_member_participation like ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chat_mem_num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return false;
				} 
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return true;
	}
	
	public List view_My_chat(int mem_num){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = null;
		ChatRoomDataBean crdb = null;
		String chat_source="";
		String Chat_partner="";
		try {
			conn = getConnection();
			String sql = "select * from chat where chat_member_participation like ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+mem_num+"%");
			rs = pstmt.executeQuery();
			
			
			//채팅 하는 사람 정보 검색 쿼리
			

			
			
			if (rs.next()) {
				
				list = new ArrayList<>();
				
				do{
					crdb = new ChatRoomDataBean();
					crdb.setChat_Num(rs.getInt(1));
					
					
					StringTokenizer stok = new StringTokenizer(rs.getString(2), "n", false);
					String temp = stok.nextToken();
					
					if(temp.equals(String.valueOf(mem_num))){
						temp=stok.nextToken();
					}// 나를 제외한  채팅 구성원 보기 
					
					
					crdb.setChat_Member_Participation(temp);
					crdb.setLast_Chat_Date(rs.getString(3));
					crdb.setLast_Chat_Conversation(rs.getString(4));
					
					
					
					
					chat_source = view_Chat_Info(Integer.parseInt(temp));
					crdb.setChat_mem_name(chat_source);
					
					
					stok = new StringTokenizer(chat_source, " ",false);
					
					Chat_partner = stok.nextToken();
					
					crdb.setChat_partner(Chat_partner);
					
					
					
					list.add(crdb);
					
					
				}while(rs.next());
				} 
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
	public String view_Chat_Info(int mem_num){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String chat_source ="";

		
		
		
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("select name,com_dept_name,com_pos_name from members where mem_num= ? ");
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				chat_source = rs.getString(1)+" ";
				if(rs.getString(2)!=null){
				chat_source = chat_source + rs.getString(2)+" ";
				}
				if(rs.getString(3)!=null){
				chat_source = chat_source + rs.getString(3);
				}
			}
			
			//채팅 하는 사람 정보 검색 쿼리
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return chat_source;
		//채팅방 대국측 정보 가져오기
		/*
		}*/
		
	}
	

}
