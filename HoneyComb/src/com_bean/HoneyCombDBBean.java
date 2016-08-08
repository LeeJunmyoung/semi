package com_bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class HoneyCombDBBean {

	private static HoneyCombDBBean instance = new HoneyCombDBBean();

	public static HoneyCombDBBean getInstance() {
		return instance;
	}

	private HoneyCombDBBean() {

	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public List insert_temp_Company(String com_name, String com_add, String com_phone, String com_aff) throws Exception {
		// companyForm���� ��Ͻ� ���� (����� ���) �ӽ����̺�� �ٲ����
		HoneyCombDataBean com = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List comList = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"insert into temp_com(com_num, com_name, com_add, com_phone, com_aff) values(temp_com_num.NEXTVAL, ?, ?, ?, ?)");
			pstmt.setString(1, com_name);
			pstmt.setString(2, com_add);
			pstmt.setString(3, com_phone);
			pstmt.setString(4, com_aff);
			pstmt.executeUpdate();
			// ����� ��Ͻ�û ������ complete_com�� insert

			pstmt = conn.prepareStatement("select com_name, com_add, com_phone, com_aff from temp_com where com_name = ?");
			pstmt.setString(1, com_name);
			rs = pstmt.executeQuery();
			// ��û ����Ʈ��� �ۼ�

			if (rs.next()) {
				comList = new ArrayList();
				com = new HoneyCombDataBean();
				com.setCom_name(rs.getString("com_name"));
				com.setCom_add(rs.getString("com_add"));
				com.setCom_phone(rs.getString("com_phone"));
				com.setCom_aff(rs.getString("com_aff"));

				comList.add(com);

			}

		} catch (SQLException ex) {
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

		return comList;

	}

	public Vector<HoneyCombDataBean> com_Search(String com_name) throws Exception {
		// �������� �˻��ϰ� ����Ʈ�� ������
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<HoneyCombDataBean> resultList = new Vector<HoneyCombDataBean>();
		
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from complete_com where com_name like ?");
			pstmt.setString(1,"%"+com_name+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HoneyCombDataBean searchCom = new HoneyCombDataBean();
				searchCom.setCom_name(rs.getString("com_name"));
				searchCom.setCom_add(rs.getString("com_add"));
				searchCom.setCom_phone(rs.getString("com_phone"));
				searchCom.setCom_num(rs.getInt("com_num"));
				resultList.addElement(searchCom);

			}

		} catch (SQLException ex) {
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

		return resultList;

	}
	
	public void com_select_person(String com_name, String com_dept_name, String com_pos_name) throws Exception {
		// ������, �μ�, ���� ��Ͻ�û (���)
		//===================================================
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HoneyCombDataBean com = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("insert into complete_com(comp_mem_num, com_name, com_dept_name, com_pos_name, name, email) values(comp_mem_num.NEXTVAL, ?, ?, ?, )");
			
		} catch (SQLException ex) {
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
	}
	
	public List com_permissionList() throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List complAllList = null;
		String com_name = "";
		int com_num = 0;
		Temp_Company_table tct = null;
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from temp_com");
			rs = pstmt.executeQuery();
			complAllList = new ArrayList();
			if (rs.next()) {
				do{
					tct = new Temp_Company_table();
					com_name= rs.getString("com_name");
					com_num = rs.getInt("com_num");
					tct.setCom_name(com_name);
					tct.setCom_num(com_num);
					complAllList.add(tct);
					
				}while(rs.next());
			}
			
		} catch (SQLException ex) {
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
		
		return complAllList;
	}

	public List com_permission(int com_num) throws Exception {
		// 사업장 신청목록 사업장 이름을 선택시 실행
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HoneyCombDataBean comp = new HoneyCombDataBean();
		List completeList = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select com_name, com_add, com_phone, com_aff from temp_com where com_num = ?");
			pstmt.setInt(1, com_num);
			rs = pstmt.executeQuery();
			
			completeList = new ArrayList();
			
			if (rs.next()) {
		
				
				
				comp.setCom_name(rs.getString("com_name"));
				comp.setCom_add(rs.getString("com_add"));
				comp.setCom_phone(rs.getString("com_phone"));
				comp.setCom_aff(rs.getString("com_aff"));				
				completeList.add(comp);
				

			}
			
		} catch (SQLException ex) {
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
		
		return completeList;
	}
	
	public int insertComplete(String com_name) throws Exception {
		// complete_com.jsp���� ��� ��û��
		// complete���̺� delete company���̺� insert
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("insert into company select com_num, com_name, com_aff, com_add, com_phone from complete_com where = ?");
			// com_name�� ��� �����͸� company�� ����
			pstmt.setString(1, com_name);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from complete_com where com_name = ?");
			// com_name���� �˻��� �����͸� complete_com delete
			pstmt.setString(1, com_name);
			pstmt.executeUpdate();
			
			x = 1; // ����
			
		} catch (SQLException ex) {
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
		
		 return x;
	}
	
	public List deleteComplete(int com_num) throws Exception {
		// complete_com.jsp���� ���� ��û��
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HoneyCombDataBean comp = new HoneyCombDataBean();
		List complAllList = null;
		String com_name = "";
		Temp_Company_table tct = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("delete from temp_com where com_num = ?");
			pstmt.setInt(1, com_num);
			pstmt.executeUpdate();
			complAllList = new ArrayList();
			System.out.println("delete 실행");
			
			pstmt = conn.prepareStatement("select * from temp_com");
			rs = pstmt.executeQuery();
			complAllList = new ArrayList();
			
		} catch (SQLException ex) {
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
			if (rs != null){
				try{
					rs.close();
				}catch (SQLException ex) {
				}
			}	
		}
		return complAllList;

	}
	
	public void mem_Permission(String com_name, String com_dept_name, String com_pos_name) throws Exception {
		// ȸ�� ��Ͻ�ûList �� (���)
		//===================================================
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HoneyCombDataBean com = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("insert into complete_com(comp_mem_num, com_name, com_dept_name, com_pos_name, name, email) values(comp_mem_num.NEXTVAL, ?, ?, ?, )");
			
		} catch (SQLException ex) {
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
	}
	
	
	public int temp_Insert_company_to_person(int com_num,String com_name,String com_dept_name,String com_pos_name,String email) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HoneyCombDataBean com = null;
		int num = 0-com_num;
		String name = com_name;
		String dept = com_dept_name;
		String pos = com_pos_name;
		String id = email;
		String sql= "";
		
		
		
		try {
			conn = getConnection();
			sql = "update members set com_name = ?, com_dept_name = ? , com_pos_name = ? , com_num = ? where email = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, dept);
			pstmt.setString(3, pos);
			pstmt.setInt(4, num);
			pstmt.setString(5, id);
			
			pstmt.executeUpdate();
		} catch (SQLException ex) {
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
		return num;
		
		
	}

}
