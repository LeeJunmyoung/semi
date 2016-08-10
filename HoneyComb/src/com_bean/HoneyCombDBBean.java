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

	public List insert_temp_Company(int mem_num,String com_name, String com_add, String com_phone, String com_aff) throws Exception {
		// companyForm
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
			//complete_com�� insert

			pstmt = conn.prepareStatement("select com_num,com_name, com_add, com_phone, com_aff from temp_com where com_name = ?");
			pstmt.setString(1, com_name);
			rs = pstmt.executeQuery();
			com = new HoneyCombDataBean();
			if (rs.next()) {
				comList = new ArrayList();
				com.setCom_num(rs.getInt("com_num"));
				com.setCom_name(rs.getString("com_name"));
				com.setCom_add(rs.getString("com_add"));
				com.setCom_phone(rs.getString("com_phone"));
				com.setCom_aff(rs.getString("com_aff"));
				comList.add(com);

			}
			
			pstmt = conn.prepareStatement("update members set com_num = ? where mem_num = ? ");
			pstmt.setInt(1, (0-com.getCom_num()));
			pstmt.setInt(2, mem_num);
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

		return comList;

	}

	public Vector<HoneyCombDataBean> com_Search(String com_name) throws Exception {
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
	
	public List insertComplete(int com_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// test
		HoneyCombDataBean comp = new HoneyCombDataBean();
		List complAllList = null;
		Temp_Company_table tct = null;
		
		try {
			conn = getConnection();
			System.out.println("com_num : " + com_num);
			pstmt = conn.prepareStatement("insert into complete_com select * from temp_com where com_num = ?");
			pstmt.setInt(1, com_num);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from temp_com where com_num = ?");
			pstmt.setInt(1, com_num);
			pstmt.executeUpdate();
			
			int temp_com_num = 0;
			
			temp_com_num = (temp_com_num-com_num);
			
			pstmt = conn.prepareStatement("update members set com_pos_num = 1 ,com_pos_name = '사장' , com_num = ? where com_num = ?");
			pstmt.setInt(1, com_num);
			pstmt.setInt(2, temp_com_num);
		
			pstmt.executeUpdate();
			System.out.println("submit중 update실행");
			
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
	
	public List deleteComplete(int com_num) throws Exception {
		// complete_com.jsp
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
	
	
	   public int temp_Insert_company_to_person(int com_num, String com_name, int com_dept_num, String com_pos_name,
		         String email) throws Exception {

		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      HoneyCombDataBean com = null;
		      String sql = "";
		      int com_pos_num = -1;
		      String[] com_dept_name = { "총무", "경리(회계)", "경영", "인사", "재경", "고객만족", "구매", "관리", "기술지원", "기획", "비서", "생산", "etc" };
		      
		      switch (com_pos_name) { // 사원급 : 3 , 임원급 : 2 , 대표 : 1 , 관리자 : 0
		      case "사원":
		      case "대리":
		         com_pos_num = 3;
		         break;
		      case "팀장":
		      case "부장":
		      case "과장":
		         com_pos_num = 2;
		         break;
		      }

		      System.out.println("temp_Insert_company_to_person com_pos_num:::" + com_pos_num);

		      try {
		         conn = getConnection();
		         sql = "update members set com_name = ?, com_dept_name = ?, com_dept_num = ?, com_pos_name = ?, com_pos_num = ?, com_num = ? where email = ? ";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, com_name);
		         pstmt.setString(2, com_dept_name[com_dept_num]);
		         pstmt.setInt(3, 0 - com_dept_num);
		         pstmt.setString(4, com_pos_name);
		         pstmt.setInt(5, 0 - com_pos_num);
		         pstmt.setInt(6, 0 - com_num);
		         pstmt.setString(7, email);
		         System.out.println("temp_Insert_company_to_person");

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
		      return com_num;

		   }
	}