package chatting_Controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import LogInDB.LogOnDataBean;

public class Chatting_DBBean {

	private static Chatting_DBBean instance = new Chatting_DBBean();
	
	public static  Chatting_DBBean getInstance(){
		return instance;
		
	}
	
	private Chatting_DBBean(){};
	

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public ArrayList view_Com_Member(int com_num){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LogOnDataBean ldb = new LogOnDataBean();
		ArrayList<LogOnDataBean> list = null;
		try {
			conn = getConnection();
			String sql ="select * from members where com_num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, com_num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				do{
				list = new ArrayList<>();
				ldb.setName(rs.getString("name"));
				ldb.setCom_dept_name(rs.getString("com_dept_name"));
				ldb.setCom_pos_name(rs.getString("com_pos_name"));
				
			
				list.add(ldb);
				}while(rs.next());
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
}
