/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package cal_Controll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cal_Controll.Cal_DataBean;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class Cal_DBBean {
	private static Cal_DBBean instance = new Cal_DBBean();

	public static Cal_DBBean getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public void insertCal(Cal_DataBean calendar,int mem_num,int com_num,int com_dept_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Object rs = null;
		Object totalList = null;
		new Cal_DataBean();
		String sql = "";

		try {
			conn = this.getConnection();
			sql = "insert into calendar(cal_num,cal_subject,cal_contents,cal_start,cal_end,mem_num,com_num,com_dept_num) values(board_num.NEXTVAL,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, calendar.getCal_subject());
			pstmt.setString(2, calendar.getCal_contents());
			pstmt.setDate(3, new Date(calendar.getCal_start().getTime()));
			pstmt.setDate(4, new Date(calendar.getCal_end().getTime()));
			pstmt.setInt(5, mem_num);
			pstmt.setInt(6, com_num);
			pstmt.setInt(7, com_dept_num);
			
			pstmt.executeUpdate();
		} catch (Exception arg24) {
			arg24.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					((ResultSet) rs).close();
				} catch (SQLException arg23) {
					;
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException arg22) {
					;
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException arg21) {
					;
				}
			}

		}

	}

	public void modify(Cal_DataBean calendar) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Object rs = null;
		String sql = "";

		try {
			conn = this.getConnection();
			sql = "update calendar set cal_subject = ? , cal_contents = ? , cal_start = ? ,cal_end = ? where cal_num = ? ";
			pstmt = conn.prepareStatement(sql);
			System.out.println(calendar.getCal_start());
			System.out.println(calendar.getCal_end());
			pstmt.setString(1, calendar.getCal_subject());
			pstmt.setString(2, calendar.getCal_contents());
			pstmt.setDate(3, new Date(calendar.getCal_start().getTime()));
			pstmt.setDate(4, new Date(calendar.getCal_end().getTime()));
			pstmt.setInt(5, calendar.getCal_num());
			pstmt.executeUpdate();
		} catch (Exception arg22) {
			arg22.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					((ResultSet) rs).close();
				} catch (SQLException arg21) {
					;
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException arg20) {
					;
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException arg19) {
					;
				}
			}

		}

	}

	public List viewCal(int mem_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList totalList = null;
		new Cal_DataBean();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement("select * from calendar where mem_num = ?");
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalList = new ArrayList();

				do {
/*
					Date d = rs.getDate("cal_end");
					d.setDate(d.getDate() + 1);
					월단위 끊기 해야 하는데 귀찮아
*/					
					
					Cal_DataBean e = new Cal_DataBean();
					e.setCal_subject(rs.getString("cal_subject"));
					e.setCal_contents(rs.getString("cal_contents"));
					e.setCal_start(rs.getDate("cal_start"));
					
					Date formatdate = new Date(rs.getDate("cal_end").getYear(),rs.getDate("cal_end").getMonth(),rs.getDate("cal_end").getDate()+1);
					
					e.setCal_end(formatdate);
					e.setCal_num(rs.getInt("cal_num"));
					totalList.add(e);
				} while (rs.next());
			}
		} catch (Exception arg23) {
			arg23.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException arg22) {
					;
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException arg21) {
					;
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException arg20) {
					;
				}
			}

		}

		return totalList;
	}

	public void delete(int cal_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Object rs = null;
		Object totalList = null;
		new Cal_DataBean();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement("delete from calendar where cal_num = ?");
			pstmt.setInt(1, cal_num);
			pstmt.executeUpdate();
		} catch (Exception arg23) {
			arg23.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					((ResultSet) rs).close();
				} catch (SQLException arg22) {
					;
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException arg21) {
					;
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException arg20) {
					;
				}
			}

		}

	}
}