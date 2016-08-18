package option_controll;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import LogInDB.LogOnDataBean;
import oracle.jdbc.proxy.annotation.Pre;

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
		int num = 0;
		num = num - com_num;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from members where com_num < 0 and com_num = ? ");
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<LogOnDataBean>();

				do {
					ldb = new LogOnDataBean();
					ldb.setMem_num(rs.getInt("mem_num"));
					ldb.setName(rs.getString("name"));
					ldb.setEmail(rs.getString("email"));
					ldb.setPhone_num(String.valueOf(rs.getInt("phone_num")));
					ldb.setCom_dept_name(rs.getString("com_dept_name"));
					ldb.setCom_dept_num(rs.getInt("com_dept_num"));
					ldb.setCom_pos_name(rs.getString("com_pos_name"));
					ldb.setCom_pos_num(rs.getInt("com_pos_num"));

					list.add(ldb);
				} while (rs.next());

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

	public void accept_member(int com_num, int mem_num, int com_dept_num, int com_pos_num) {
		// 멤버 승인시 작동 할거 작성 !!
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"update members set com_num = ? , com_dept_num = ? , com_pos_num = ?  where mem_num = ?");
			pstmt.setInt(1, com_num);
			pstmt.setInt(2, com_dept_num);
			pstmt.setInt(3, com_pos_num);
			pstmt.setInt(4, mem_num);
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

	public List memberList(int com_num) {
		// 해당 회사의 구성원리스트
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List memlist = null;
		LogOnDataBean ldb = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select name,email,phone_num,com_dept_name,com_pos_name from members where com_num = ? order by com_pos_num");
			// com_pos_num을 기준으로 정렬 수정
			pstmt.setInt(1, com_num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				memlist = new ArrayList<LogOnDataBean>();

				do {
					ldb = new LogOnDataBean();
					ldb.setName(rs.getString("name"));
					ldb.setEmail(rs.getString("email"));
					ldb.setPhone_num(String.valueOf(rs.getInt("phone_num")));
					ldb.setCom_dept_name(rs.getString("com_dept_name"));
					ldb.setCom_pos_name(rs.getString("com_pos_name"));

					memlist.add(ldb);
				} while (rs.next());

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

		return memlist;
	}

	public String pwCheck(int mem_num) throws Exception {
		// 기존 비밀번호를 리턴 (비밀번호 확인)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String passwd = "";

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select passwd from members where mem_num = ?");
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				passwd = rs.getString(1);
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
		System.out.println("pwCheck passwd ::: " + passwd);

		return passwd;
	}

	public void pwChange(int mem_num, String newpw) throws Exception {
		// 비밀번호 변경
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update members set passwd = ? where mem_num = ?");
			pstmt.setString(1, newpw);
			pstmt.setInt(2, mem_num);

			x = pstmt.executeUpdate();
			System.out.println("x :::" + x);

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

	public String img_Register(int mem_num, String img_path) throws Exception {
		// 프로필 사진 등록
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String profile_img = "";

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update members set profile_img = ? where mem_num = ?");
			pstmt.setString(1, img_path);
			pstmt.setInt(2, mem_num);

			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select profile_img from members where mem_num = ?");
			pstmt.setInt(1, mem_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				profile_img = rs.getString(1);
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

		return profile_img;

	}

	public String passwd_Get(int mem_num) throws Exception {
		// 게정 삭제를 위한 비밀번호
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String passwd = "";
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select passwd from members where mem_num = ?");
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			
			rs.next();
			passwd = rs.getString(1);
			
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
		
		return passwd;
	}
	
	public void user_Delete(int mem_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("delete from members where mem_num = ?");
			pstmt.setInt(1, mem_num);
			pstmt.executeQuery();
			
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

		}
		
	}

}
