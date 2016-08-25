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

import org.apache.catalina.connector.Request;

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
			
			if(folder == ""){//�����ϰ��
			pstmt =conn.prepareStatement("select * from cloud where com_num = ? and folder is null order by file_path desc");
			pstmt.setInt(1, com_num);
			}else{//���� �ȿ� ���� ���
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
		cloud.setPromgr_num(rs.getInt(9));
		cloud.setMem_num(rs.getInt(10));
		
		
		return cloud;
		
	}
public int cloudInsert(CloudDataBean cloudDB, int promgr_num)throws SQLException{
		PreparedStatement pstmt = null;
		Connection conn = null;
		try{
			String progr_name = null;//
			String sql = null;
			int file = checkFolder(cloudDB);
			
			
			conn = getConnection();
			System.out.println("프로젝트 넘:"+promgr_num);
			//프로젝트에서 업로드 했을 때
			if(promgr_num != 0){
				System.out.println("프로젝트에서 실행됨");
				//프로젝트 명 가지고 오기
				progr_name = getProgrName(promgr_num);
				createFolder(cloudDB, progr_name, promgr_num);
				sql = "insert into cloud values(cloud_seq.nextval,?,?,?,?,sysdate,?,?,?,?)";//마지막에 들어갈 promgr_num
				String progrfolder = "*"+progr_name+"|";//프로젝트명의 가상파일 생성
				cloudDB.setFolder(progrfolder);
				file = checkFolder(cloudDB);
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(7, promgr_num);
				//프로젝트 DB 에 파일이름 업데이트
				updatePromgr(cloudDB, promgr_num);
				pstmt.setInt(8, cloudDB.getMem_num());
				
			}else{
				sql = "insert into cloud values(cloud_seq.nextval,?,?,?,?,sysdate,?,?,null,?)";//promgr_num이  없기 때문에 null
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(7, cloudDB.getMem_num());
			}
			
			
			pstmt.setString(1, cloudDB.getFile_name());
			pstmt.setString(2, cloudDB.getFile_path());
			pstmt.setString(3, cloudDB.getFile_uploader());
			pstmt.setString(4, String.valueOf(cloudDB.getFile_size()));
			pstmt.setInt(5, cloudDB.getCom_num());
			pstmt.setString(6, cloudDB.getFolder());
			pstmt.executeUpdate();
			conn.commit();
			if(promgr_num != 0){//프로젝트명 업데이트
				updatePromgr(cloudDB, promgr_num);
			}
			if (file == 0 ){
				return 0;//중복이면 0을 리턴
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
		
		return 1;
	}

public void createFolder(CloudDataBean cloudPro, String progr_name, int progr_num)throws SQLException{
	PreparedStatement pstmt = null;
	Connection conn = null;
	try{
		String file_path = null;//저장할 파일경로
		String file_name = null;//파일명
		conn = getConnection();			
		pstmt =conn.prepareStatement("insert into cloud values(cloud_seq.nextval,?,'',?,0,sysdate,?,?,'',?)");
		if(progr_name!=null){
			progr_name = "*"+progr_name;
			file_name = cloudPro.getFile_name();
			cloudPro.setFile_name(progr_name);
			file_path = cloudPro.getFile_path();//파일패스 임시 저장
			cloudPro.setFile_path(null);//폴더이기때문에 file_path 초기화
			
			
			int i = checkFolder(cloudPro);//그 폴더가 중복되었을 경우
			
			if (i != 0){//그 폴더가 중복이 아닐경우
				pstmt =conn.prepareStatement("insert into cloud values(cloud_seq.nextval,?,'',?,0,sysdate,?,'',?,?)");
				pstmt.setString(1, cloudPro.getFile_name());
				pstmt.setString(2,cloudPro.getFile_uploader());
				pstmt.setInt(3,cloudPro.getCom_num());
				pstmt.setInt(4, progr_num);
				pstmt.setInt(5, cloudPro.getMem_num());
				pstmt.executeUpdate();
				conn.commit();
			}
			
		}else{//프로젝트 아닐경우
			pstmt =conn.prepareStatement("insert into cloud values(cloud_seq.nextval,?,'',?,0,sysdate,?,?,'',?)");
			pstmt.setString(1, cloudPro.getFile_name());
			pstmt.setString(2,cloudPro.getFile_uploader());
			pstmt.setInt(3,cloudPro.getCom_num());
			pstmt.setString(4,cloudPro.getFolder());
			pstmt.setInt(5, cloudPro.getMem_num());
			pstmt.executeUpdate();
			conn.commit();
		}
		//����ù��°�� �����
		
		
		cloudPro.setFile_name(file_name);//파일명 다시 넣
		cloudPro.setFile_path(file_path);//폴더 저장 끝났으면 다시 실행
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

public int checkFolder(CloudDataBean cloudPro)throws SQLException{
	PreparedStatement pstmt = null;
	Connection conn = null;
	try{

		conn = getConnection();		
		ResultSet rs = null;
		
		String folder = cloudPro.getFolder();
		String file_name = cloudPro.getFile_name();
		String file_path = cloudPro.getFile_path();
		if(file_path == null){//폴더이면
		if (folder == ""){
			
			pstmt =conn.prepareStatement("select * from cloud where file_name = ? and folder is null and file_path is null");
			pstmt.setString(1, file_name);
		}else{
			
		pstmt =conn.prepareStatement("select * from cloud where file_name = ? and folder = ? and file_path is null");
		pstmt.setString(1, file_name);
		pstmt.setString(2, folder);
		}
		} else{//폴더가 아니면
			if (folder == ""){//메인일때
				
				pstmt =conn.prepareStatement("select * from cloud where file_name = ? and folder is null and file_path is not null");
				pstmt.setString(1, file_name);
				
			}else{
				
			pstmt =conn.prepareStatement("select * from cloud where file_name = ? and folder = ? and file_path is not null");
			pstmt.setString(1, file_name);
			pstmt.setString(2, folder);
			}
		}
		
		rs = pstmt.executeQuery();
		if(rs.next()){
			return 0;//중복이면 0을 리턴
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
	return 1;//중복이 아니면 1을 리턴
}

public int renameItem(CloudDataBean cloudData, String itemName)throws SQLException{
	PreparedStatement pstmt = null;
	Connection conn = null;
	try{
		cloudData.setFile_name(itemName);
		conn = getConnection();
		int i = checkFolder(cloudData);
		
		if (i ==0){
			return 0;
		}
		//파일 경로일경우
		String file_path = cloudData.getFile_path();
		pstmt =conn.prepareStatement("update cloud set file_name = ? where file_path=?");
		pstmt.setString(1, itemName);
		pstmt.setString(2, file_path);
		
		
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
	return 1;
}

public int deleteItem(String iteminfo, String folder)throws SQLException{
	PreparedStatement pstmt = null;
	Connection conn = null;
	int x = 0;
	try{

		conn = getConnection();
		
		if(folder ==null){//파일 삭제
		//파일 경로일경우
		String file_path = iteminfo;
		pstmt =conn.prepareStatement("delete from cloud where file_path = ?");
		pstmt.setString(1, file_path);
		}else{//폴더삭제
			String file_name = iteminfo;
			if(folder == ""){//메인페이지 삭제
				pstmt = conn.prepareStatement("delete from cloud where file_name = ? and folder is null");
				pstmt.setString(1, file_name);
				x = pstmt.executeUpdate();
				pstmt = conn.prepareStatement("delete from cloud where folder like ?");
				String folderdel = file_name+"|%";
				pstmt.setString(1, folderdel);
			}else{
			pstmt = conn.prepareStatement("delete from cloud where file_name = ? and folder = ?");
			pstmt.setString(1, file_name);
			pstmt.setString(2, folder);
			x = pstmt.executeUpdate();
			pstmt = conn.prepareStatement("delete from cloud where folder like ?");
			String folderdel = folder+file_name+"|%";
			pstmt.setString(1, folderdel);
			}
			
		}
		
		x = pstmt.executeUpdate();
		
		System.out.println("x : " + x);
		
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
	
	return x;
	
}
private String getProgrName(int promgr_num)throws SQLException{
	// promgr_num으로 프로젝트명 찾기
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;
	String promgr_name = null;
	try{
		conn = getConnection();
		pstmt = conn.prepareStatement("select PROMGR_NAME from promgr where promgr_num = ?");
		pstmt.setInt(1, promgr_num);
		rs = pstmt.executeQuery();
		rs.next();
		promgr_name = rs.getString(1);
		return promgr_name;
		
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
	
	}return promgr_name;
}

private void updatePromgr(CloudDataBean cloudDB, int promgr_num)throws SQLException{
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;
	try{
		conn = getConnection();
		String file_Path = cloudDB.getFile_path();
		int file_num = 0;
		//파일넘부터 받아오기
		String sql = "select file_num from cloud where file_path = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, file_Path);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			file_num = rs.getInt("file_num");
			System.out.println("파일넘 받아올 수 있는지 없는지 보자"+file_num);
		}
		
		//promgr에 업데이트
		int com_num = cloudDB.getCom_num();
		
		sql = "select * from promgr where promgr_num=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, promgr_num);
		rs = pstmt.executeQuery();

		String file_num_str = "";
		
		if (rs.next()) {

			String old_file_num = rs.getString("file_num");

			if (old_file_num == null) {
				file_num_str = String.valueOf(file_num);
			} else {
				file_num_str = old_file_num + "/" + file_num;
			}

			sql = "update promgr set file_num=? where promgr_num=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, file_num_str);
			pstmt.setInt(2, promgr_num);

			pstmt.executeUpdate();

		} // promgr chklist_title_num
		
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

public CloudDataBean renameCheck(String file_path)throws SQLException{
	CloudDataBean cloudData = new CloudDataBean();
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	try{
	
		conn = getConnection();
		String sql = "select * from cloud where file_path=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, file_path);
		
		rs = pstmt.executeQuery();
		rs.next();
		cloudData =  makeCloudListResultSet(rs);
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
	return cloudData;
}
}
