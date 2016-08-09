package LogInDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import LogInDB.LogOnDataBean;



public class LogOnDBBean {
	
	private static LogOnDBBean instance = new LogOnDBBean();

	// LogonDBBean m = LogonDBBean.getInstance();
	public static LogOnDBBean getInstance() {
		return instance;
	}

	private LogOnDBBean() {}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	//SigninPro.java
	public void insertMember(LogOnDataBean member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// DriverManager.getConnection(jdbc:apache:commons:dbcp:/pool);
			pstmt = conn.prepareStatement("insert into MEMBERS (mem_num, name, email, passwd, phone_num)values (logon_seq.nextval,?,?,?,?)");
			//�ʹ� insert��
			pstmt.setString(1,member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getPhone_num());
			
			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
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
	//LogInPro.java
	public Vector Checkmembers(String email, String passwd) throws Exception{
		//session �� ��ȯ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector member = new Vector();
		try{
			conn = getConnection();
			pstmt=conn.prepareStatement("select mem_num, com_num, com_dept_num, com_pos_num,name,phone_num,com_name,com_dept_name,com_pos_name from members where email=? and passwd=?");
			pstmt.setString(1, email);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
		
		if(rs.next()){
			
			
			member.addElement(rs.getInt(1));
			member.addElement(rs.getInt(2));
			member.addElement(rs.getInt(3));
			member.addElement(rs.getInt(4));
			member.addElement(rs.getString("name"));
	
			/*아래 추가됌*/
			member.addElement(rs.getInt("phone_num"));
			member.addElement(rs.getString("com_name"));
			member.addElement(rs.getString("com_dept_name"));
			member.addElement(rs.getString("com_pos_name"));
		}
		
				
		}catch (Exception ex) {
			ex.printStackTrace();
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
		return member;
		
	}
	//mailCheck.java
	public String Checkemail(String email) throws Exception{
		//session �� ��ȯ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String db = null;
		try{
			conn = getConnection();
			pstmt=conn.prepareStatement("select * from members where email=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()){
				db =  "n";
			}else{
				db =  "y";}			
					
		}catch (Exception ex) {
			ex.printStackTrace();
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
		return db;
		
	}
	//findEmailPro.java
	public String FindEmail(String name, String Phone_num) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String email = null;
		try{
			conn = getConnection();
			pstmt=conn.prepareStatement("select email from members where name=? and phone_num=?");
			pstmt.setString(1, name);
			pstmt.setString(2, Phone_num);
			rs = pstmt.executeQuery();
		
		if(rs.next()){
			email = rs.getString(1);
			return email;			
		}
					
		}catch (Exception ex) {
			ex.printStackTrace();
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
	//updatePasswd.java
	public void updatePasswd(String email, String newpasswd) throws Exception{
		//session �� ��ȯ
		Connection conn = null;
		PreparedStatement pstmt = null;	
		try{
			conn = getConnection();
			pstmt=conn.prepareStatement("update members set passwd=? where email=?");
			pstmt.setString(1, newpasswd);
			pstmt.setString(2, email);			
			int i = pstmt.executeUpdate();
	
		}catch (Exception ex) {
			ex.printStackTrace();
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
	
	
}
