package clouddb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CloudDBBean {
	private static CloudDBBean instance = new CloudDBBean();

	// LogonDBBean m = LogonDBBean.getInstance();
	public static CloudDBBean getInstance() {
		return instance;
	}

	private CloudDBBean() {	}
	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public List<CloudDataBean> cloudList(int com_num, String folder)throws SQLException{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try{
			
			conn = getConnection();
			
			if(folder == ""){//메인일경우
			pstmt =conn.prepareStatement("select * from cloud where com_num = ? and folder is null order by file_path desc");
			pstmt.setInt(1, com_num);
			}else{//폴더 안에 들어올 경우
			pstmt = conn.prepareStatement("select * from cloud where com_num =? and folder = ? order by file_path desc");
			pstmt.setInt(1, com_num);
			pstmt.setString(2, folder);
			}
			rs = pstmt.executeQuery();
			
			if(!rs.next()){
				return Collections.emptyList();
			}
			List<CloudDataBean> cloudList = new ArrayList<CloudDataBean>();
			do{
				
				CloudDataBean cloud = makeCloudListResultSet(rs);
				cloudList.add(cloud);
			}while(rs.next());
			
			return cloudList;
			
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
	private CloudDataBean makeCloudListResultSet(ResultSet rs) throws SQLException{
		CloudDataBean cloud = new CloudDataBean();
		cloud.setFile_num(rs.getInt(1));
		cloud.setFile_path(rs.getString(3));
		cloud.setFile_name(rs.getString(2));
		cloud.setFile_uploader(rs.getString(4));
		cloud.setFile_size(rs.getInt(5));
		cloud.setFile_date(rs.getDate(6));
		cloud.setFolder(rs.getString(8));
		
		return cloud;
		
	}
public void cloudInsert(CloudDataBean cloudDB, String folder)throws SQLException{
		PreparedStatement pstmt = null;
		Connection conn = null;
		try{
	
			conn = getConnection();			
			pstmt =conn.prepareStatement("insert into cloud values(cloud_seq.nextval,?,?,?,?,sysdate,?,?)");
			pstmt.setString(1, cloudDB.getFile_name());
			pstmt.setString(2, cloudDB.getFile_path());
			pstmt.setString(3, cloudDB.getFile_uploader());
			pstmt.setString(4, String.valueOf(cloudDB.getFile_size()));
			pstmt.setInt(5, cloudDB.getCom_num());
			if(folder == null){
				pstmt.setString(6, "");
			}else{
				pstmt.setString(6, folder);
			}
			
			pstmt.executeUpdate();
			conn.commit();
			
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

public void createFolder(CloudDataBean cloudPro)throws SQLException{
	PreparedStatement pstmt = null;
	Connection conn = null;
	try{

		conn = getConnection();			
		pstmt =conn.prepareStatement("insert into cloud values(cloud_seq.nextval,?,'',?,0,sysdate,?,?)");
		//폴더첫번째로 만들기
		pstmt.setString(1, cloudPro.getFile_name());
		pstmt.setString(2,cloudPro.getFile_uploader());
		pstmt.setInt(3,cloudPro.getCom_num());
		pstmt.setString(4,cloudPro.getFolder());
		
		pstmt.executeUpdate();
		conn.commit();
		
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
