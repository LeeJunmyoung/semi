package memCheck_bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemCheckDBBean {

	private static MemCheckDBBean instance = new MemCheckDBBean();

	public static MemCheckDBBean getInstance() {
		return instance;
	}

	private MemCheckDBBean() {

	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public ArrayList memList() throws Exception {
		// memCheck_Main.jsp의 초기 리스트를 가져옴 (전체 가입자)

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList comList = null;
		MemCheckDataBean com = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select com_name, com_add, com_aff, com_phone, com_num from complete_com order by com_name");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				comList = new ArrayList();
				do {

					com = new MemCheckDataBean();

					com.setCom_name(rs.getString("com_name"));
					com.setCom_add(rs.getString("com_add"));
					com.setCom_aff(rs.getString("com_aff"));
					com.setCom_phone(rs.getString("com_phone"));
					com.setCom_num(rs.getInt("com_num"));

					comList.add(com);

				} while (rs.next());
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

	public ArrayList comSearch(String com_name) throws Exception {
		// memCheck_Main.jsp에서 회사 검색시 실행

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList comSearchList = null;
		MemCheckDataBean com = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select com_name, com_add, com_aff, com_phone, com_num from complete_com where com_name like ?");
			pstmt.setString(1, "%" + com_name + "%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				comSearchList = new ArrayList<>();
				com = new MemCheckDataBean();
				do {
					com.setCom_name(rs.getString("com_name"));
					com.setCom_add(rs.getString("com_add"));
					com.setCom_aff(rs.getString("com_aff"));
					com.setCom_phone(rs.getString("com_phone"));
					com.setCom_num(rs.getInt("com_num"));
				} while (rs.next());

				comSearchList.add(com);
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

		return comSearchList;
	}

	public ArrayList comMemberList(int com_num) throws Exception {
		// memberList 클릭시 해당 company의 소속된 member리스트를 가져옴

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList comMemberList = null;
		MemCheckDataBean mem = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select name, email, phone_num, com_dept_name, com_pos_name from members where com_num = ? order by com_pos_num");
			pstmt.setInt(1, com_num);
			rs = pstmt.executeQuery();
			// com_pos_num기준으로 정렬 (modify)

			if (rs.next()) {
				comMemberList = new ArrayList();

				do {
					mem = new MemCheckDataBean();

					mem.setName(rs.getString("name"));
					mem.setEmail(rs.getString("email"));
					mem.setPhone_num(rs.getString("phone_num"));
					mem.setCom_dept_name(rs.getString("com_dept_name"));
					mem.setCom_pos_name(rs.getString("com_pos_name"));

					comMemberList.add(mem);

				} while (rs.next());
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

		return comMemberList;
	}

}