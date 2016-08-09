package option_controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import LogInDB.LogOnDataBean;

public class OptionDBBean {

	private static OptionDBBean instance = new OptionDBBean();

	public static OptionDBBean getInstance() {
		return instance;
	}

	private OptionDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public ArrayList view_temp_member(int com_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList list = null;
		LogOnDataBean ldb = null;
		int num=0;
		num = num-com_num;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from members where com_num < 0 and com_num = ? ");
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();
			if(rs.next()){
				list = new ArrayList<LogOnDataBean>();
				
				do{
					ldb = new LogOnDataBean();
					ldb.setCom_dept_name(rs.getString("com_dept_name"));
					ldb.setCom_pos_name(rs.getString("com_pos_name"));
					ldb.setName(rs.getString("name"));
					System.out.println("com_dept_name: "+rs.getString("com_dept_name"));
					System.out.println("com_pos_name: "+rs.getString("com_pos_name"));
					System.out.println("name: "+rs.getString("name"));
					list.add(ldb);
				}while(rs.next());
				
				
			}
			
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
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

		return list;
	}
	
	
	
	
	public void accept_member(int com_num) {
		//멤버 승인시 작동 할거 작성 !!
	}
	
	
	
	
}
