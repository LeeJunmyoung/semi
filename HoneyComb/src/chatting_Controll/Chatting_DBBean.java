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
			String sql = "insert into chat(chat_num,chat_member_participation,chat_mem_name,last_chat_member,last_chat_read) values ( OneNOneChat.nextval , ? ,'0',',','t')";
			
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
	
	public List view_My_chat(int mem_num){//내가 햇던 채팅들 보여줌
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2  = null; //새로 만든거 2016-08-18
		List list = null;
		ChatRoomDataBean crdb = null;
		
		try {
			conn = getConnection();
			String sql = "select * from chat where chat_member_participation like ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+mem_num+"%");
			rs = pstmt.executeQuery();
			String chat_source="";
			String Chat_partner="";
			
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
					}else{
						stok.nextToken();
					}
					
					if(!stok.hasMoreTokens() ){
					
						pstmt= conn.prepareStatement(" select profile_img from members where mem_num = ? ");
						pstmt.setInt(1, Integer.parseInt(temp));
						rs2 = pstmt.executeQuery();
						if(rs2.next()){
							crdb.setProfile_IMG(rs2.getString(1));
						}
						crdb.setChat_Member_Participation(temp);
						crdb.setLast_Chat_Date(rs.getString(3));
						crdb.setLast_Chat_Conversation(rs.getString(4));	
						chat_source = view_Chat_Info(Integer.parseInt(temp));
						crdb.setChat_mem_name(chat_source);
						stok = new StringTokenizer(chat_source, " ",false);
						Chat_partner = stok.nextToken();
						crdb.setChat_partner(Chat_partner);
						//20168월 17일 추가분  읽엇는지 않읽엇는지 확인
						crdb.setLast_Chat_Member(rs.getString("Last_Chat_Member"));
						crdb.setLast_Chat_Read(rs.getString("Last_Chat_Read"));
						list.add(crdb);
						
						

					/*	System.out.println("chat_Num :::" + crdb.getChat_Num());
						//채털방
						System.out.println("chat_mem_name :::" + crdb.getChat_mem_name());
						//대화할사람 이름
						System.out.println("chat_Member_Participation :::" + crdb.getChat_Member_Participation());
						//반대편 number
						System.out.println("last_Chat_Date :::" + crdb.getLast_Chat_Date());
						// 미구현
						System.out.println("last_Chat_Conversation :::" + crdb.getLast_Chat_Conversation());
						//미구현
						System.out.println("chat_partner :::" + crdb.getChat_partner());
						// 반대편 사람 이름
						System.out.println("last_Chat_Member :::" + crdb.getLast_Chat_Member());
						// 마지막 글 
						System.out.println("last_Chat_Read :::" + crdb.getLast_Chat_Read());
						// 읽었는지 않 읽었는지
						System.out.println("profile_IMG :::" + crdb.getProfile_IMG());
						//프로필 이미지
*/						
						
					}else{
						StringTokenizer multi_Stok = new StringTokenizer(rs.getString(2), "n", false);
						StringTokenizer korea_Name = null;
						String multi_Names = "";
						String temp_Names="";
						Chat_partner="";
						
						while(multi_Stok.hasMoreTokens()){
							temp_Names = multi_Stok.nextToken();
							
							if(temp_Names.equals(String.valueOf(mem_num))){
								
							}else{
								multi_Names = multi_Names +temp_Names +","; //멤버 숫자정보 
								chat_source= view_Chat_Info(Integer.parseInt(temp_Names)); //
								korea_Name = new StringTokenizer(chat_source, " ");
								Chat_partner = Chat_partner+korea_Name.nextToken()+",";  // 한글이름 추출
							}
						}
						
						
						
						
						
						
						
						crdb.setChat_mem_name(Chat_partner);// 대화할 시람 한글 이름
						crdb.setChat_Member_Participation(multi_Names);
						crdb.setChat_partner(Chat_partner);
						
						
						
						
						
						
						
						crdb.setLast_Chat_Member(rs.getString("Last_Chat_Member"));
						crdb.setLast_Chat_Read(rs.getString("Last_Chat_Read"));
						
						
						list.add(crdb);
						
						/*System.out.println("chat_Num :::" + crdb.getChat_Num());
						//채털방
						System.out.println("chat_mem_name :::" + crdb.getChat_mem_name());
						//대화할사람 이름
						System.out.println("chat_Member_Participation :::" + crdb.getChat_Member_Participation());
						//반대편 number
						System.out.println("last_Chat_Date :::" + crdb.getLast_Chat_Date());
						// 미구현
						System.out.println("last_Chat_Conversation :::" + crdb.getLast_Chat_Conversation());
						//미구현
						System.out.println("chat_partner :::" + crdb.getChat_partner());
						// 반대편 사람 이름
						System.out.println("last_Chat_Member :::" + crdb.getLast_Chat_Member());
						// 마지막 글 
						System.out.println("last_Chat_Read :::" + crdb.getLast_Chat_Read());
						// 읽었는지 않 읽었는지
						System.out.println("profile_IMG :::" + crdb.getProfile_IMG());
						//프로필 이미지
*/						
						
						
					}
					
					
					
					
					
					
					
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
			if(rs2 != null)
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
