package promgr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import oracle.net.aso.s;

public class PromgrDBBean {

	private static PromgrDBBean instance = new PromgrDBBean();

	private Connection getConnection() throws Exception {

		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";

		return DriverManager.getConnection(jdbcDriver);

	} // getConnection() end

	public static PromgrDBBean getInstance() {
		return instance;
	}

	public int getPromgrCount(int com_num, int mem_num) throws Exception {
		// promgr row의 수

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from promgr where com_num=? and mem_num like ?");
			pstmt.setInt(1, com_num);
			pstmt.setString(2, "%" + mem_num + "%");

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
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

		return count;

	} // int getPromgrCount(int com_num, int mem_num) end

	public List getPromgrList(int com_num, int mem_num, int start, int end) throws Exception {
		// paging, promgr row 목록 호출

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringTokenizer stz = null;
		int[] item_list = null;
		int idx = 0;
		String[] mem_name_arr = null;
		String[] chklist_title_arr = null;
		String[] chklist_item_arr = null;

		List articleList = null;
		String sql = null;

		try {

			conn = getConnection();

			if (start == -1) { // main 화면에서 보여지는 list sql

				sql = "select promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num,r from (";
				sql += "select  promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num,rownum r from (";
				sql += "select promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num from promgr ";
				sql += "where com_num=? and mem_num like ? order by promgr_num desc)) ";
				sql += "where r<=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, com_num);
				pstmt.setString(2, "%" + mem_num + "%");
				pstmt.setInt(3, end);

				rs = pstmt.executeQuery();

			} else { // more 화면에서 보여지는 list sql

				sql = "select promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num,r from (";
				sql += "select promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num,rownum r from (";
				sql += "select promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num from promgr ";
				sql += "where com_num=? and mem_num like ? order by promgr_num desc)) ";
				sql += "where r>=? and r<=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, com_num);
				pstmt.setString(2, "%" + mem_num + "%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);

				rs = pstmt.executeQuery();

			}

			if (rs.next()) {

				articleList = new ArrayList(end);

				do {

					PromgrDataBean article = new PromgrDataBean();

					article.setPromgr_num(rs.getInt("promgr_num"));
					article.setPromgr_name(rs.getString("promgr_name"));
					article.setPromgr_content(rs.getString("promgr_content"));
					article.setPromgr_date(rs.getTimestamp("promgr_date"));
					article.setMem_num(rs.getString("mem_num"));
					article.setFile_num(rs.getString("file_num"));
					article.setChklist_title_num(rs.getString("chklist_title_num"));
					article.setChklist_item_num(rs.getString("chklist_item_num"));
					article.setComment_num(rs.getString("comment_num"));
					article.setCom_num(rs.getInt("com_num"));

					// <num_name arr setting>
					// mem_num 분리
					stz = new StringTokenizer(rs.getString("mem_num"), "/");

					idx = 0;
					item_list = new int[stz.countTokens()];

					while (stz.hasMoreTokens()) {
						item_list[idx] = Integer.parseInt(stz.nextToken());
						idx++;
					} // while (stz.hasMoreTokens()) end

					// mem_num -> mem_name
					mem_name_arr = new String[item_list.length];

					for (int j = 0; j < item_list.length; j++) {

						pstmt = conn.prepareStatement("select * from members where mem_num=?");
						pstmt.setInt(1, item_list[j]);

						ResultSet rs_name = pstmt.executeQuery();

						if (rs_name.next()) {

							mem_name_arr[j] = rs_name.getString("name");

						} // members item if (rs.next()) end

					} // mem_name_arr for end

					article.setMem_name_arr(mem_name_arr);

					// <chklist_title_arr setting>
					// chklist_title_num 분리
					if (rs.getString("chklist_title_num") != null) {
						stz = new StringTokenizer(rs.getString("chklist_title_num"), "/");
					}

					idx = 0;
					item_list = new int[stz.countTokens()];

					while (stz.hasMoreTokens()) {
						item_list[idx] = Integer.parseInt(stz.nextToken());
						idx++;
					} // while (stz.hasMoreTokens()) end

					// chklist_title_num -> chklist_title_name
					chklist_title_arr = new String[item_list.length];

					for (int j = 0; j < item_list.length; j++) {

						pstmt = conn.prepareStatement("select * from chklist_title where chklist_title_num=?");
						pstmt.setInt(1, item_list[j]);

						ResultSet rs_chklist_title = pstmt.executeQuery();

						if (rs_chklist_title.next()) {

							chklist_title_arr[j] = rs_chklist_title.getString("chklist_title_name");

						} // chklist_title item if (rs.next()) end

					} // chklist_title_arr for end

					article.setChklist_title_arr(chklist_title_arr);

					// <chklist_item_arr setting>
					// chklist_tiem_num 분리
					if (rs.getString("chklist_item_num") != null) {
						stz = new StringTokenizer(rs.getString("chklist_item_num"), "/");
					}

					idx = 0;
					item_list = new int[stz.countTokens()];

					while (stz.hasMoreTokens()) {
						item_list[idx] = Integer.parseInt(stz.nextToken());
						idx++;
					} // while (stz.hasMoreTokens()) end

					// chklist_item_num -> chklist_item_name
					chklist_item_arr = new String[item_list.length];

					for (int j = 0; j < item_list.length; j++) {

						pstmt = conn.prepareStatement("select * from chklist_item where chklist_item_num=?");
						pstmt.setInt(1, item_list[j]);

						ResultSet rs_chklist_item = pstmt.executeQuery();

						if (rs_chklist_item.next()) {

							chklist_item_arr[j] = rs_chklist_item.getString("chklist_item_name");

						} // chklist_item item if (rs.next()) end

						for (int k = 0; k < chklist_item_arr.length; k++) {
							System.out.println("chklist_item_arr[" + k + "] : " + chklist_item_arr[k]);
						}

					} // chklist_item_arr for end

					article.setChklist_item_arr(chklist_item_arr);

					articleList.add(article);

				} while (rs.next());

			}

		} catch (Exception e) {
			e.printStackTrace();
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

		return articleList;

	} // List getPromgrList(int endRow) end

	public PromgrDataBean getPromgrArticle(int rowNum, String mem_num) throws Exception {
		// promgr 목록의 한 item의 데이터를 호출

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PromgrDataBean article = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement("select * from promgr where promgr_num=? and mem_num like ?");
			pstmt.setInt(1, rowNum);
			pstmt.setString(2, "%" + mem_num + "%");

			rs = pstmt.executeQuery();

			if (rs.next()) {

				article = new PromgrDataBean();

				article.setPromgr_num(rs.getInt("promgr_num"));
				article.setPromgr_name(rs.getString("promgr_name"));
				article.setPromgr_content(rs.getString("promgr_content"));
				article.setPromgr_date(rs.getTimestamp("promgr_date"));
				article.setMem_num(rs.getString("mem_num"));
				article.setFile_num(rs.getString("file_num"));
				article.setChklist_title_num(rs.getString("chklist_title_num"));
				article.setChklist_item_num(rs.getString("chklist_item_num"));
				article.setComment_num(rs.getString("comment_num"));
				article.setCom_num(rs.getInt("com_num"));

			}

		} catch (Exception e) {
			e.printStackTrace();
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

		return article;

	} // PromgrDataBean getPromgrArticle(int rowNum, String mem_num) end

	public int insertPromgr(PromgrDataBean article) throws Exception {
		// promgr 생성

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;

		String sql = "";

		try {

			conn = getConnection();

			sql = "insert into ";
			sql += "promgr(promgr_num,promgr_name,promgr_content,promgr_date,mem_num,com_num) ";
			sql += "values(promgr_num.NEXTVAL,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getPromgr_name());
			pstmt.setString(2, article.getPromgr_content());
			pstmt.setTimestamp(3, article.getPromgr_date());
			pstmt.setString(4, article.getMem_num());
			pstmt.setInt(5, article.getCom_num());

			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
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

		return count;

	} // int insertPromgr(PromgrDataBean article) end

	public List getMemberDataList(String promgr_num, int my_mem_num) throws Exception {
		// promgr의 mem_num의 정보를 가져와서 분리 후 참여자 정보 호출

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String item_all = null;
		StringTokenizer stz = null;
		int[] item_list = null;
		List articleList = null;
		String sql = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement("select * from promgr where promgr_num=?");
			pstmt.setString(1, promgr_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				item_all = rs.getString("mem_num");

				stz = new StringTokenizer(item_all, "/");

				int idx = 0;
				item_list = new int[stz.countTokens()];

				while (stz.hasMoreTokens()) {
					item_list[idx] = Integer.parseInt(stz.nextToken());
					idx++;
				} // while (stz.hasMoreTokens()) end

				articleList = new ArrayList();

				for (int i = 0; i < item_list.length; i++) {

					pstmt = conn.prepareStatement("select * from members where mem_num=? and not mem_num=?");
					pstmt.setInt(1, item_list[i]);
					pstmt.setInt(2, my_mem_num);

					rs = pstmt.executeQuery();

					if (rs.next()) {

						MemberListDataBean article = new MemberListDataBean();

						article.setMem_num(rs.getInt("mem_num"));
						article.setMem_name(rs.getString("name"));
						article.setMem_email(rs.getString("email"));
						article.setMem_pos(rs.getString("com_pos_name"));

						articleList.add(article);

					} // members if (rs.next()) end

				} // for end

			} // promgr if (rs.next()) end

		} catch (Exception e) {
			e.printStackTrace();
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

		return articleList;

	} // List getMemberDataList(String promgr_num, int my_mem_num) end

	public List getMemberSearchList(String promgr_num) throws Exception {
		// promgr의 mem_num의 정보를 가져와서 분리 후 참여자 제외한 정보 호출

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int com_num = 0;
		String item_all = null;
		StringTokenizer stz = null;
		int[] item_list = null;
		List articleList = null;
		String sql = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement("select * from promgr where promgr_num=?");
			pstmt.setString(1, promgr_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				com_num = rs.getInt("com_num");
				item_all = rs.getString("mem_num");

				stz = new StringTokenizer(item_all, "/");

				int idx = 0;
				item_list = new int[stz.countTokens()];

				while (stz.hasMoreTokens()) {
					item_list[idx] = Integer.parseInt(stz.nextToken());
					idx++;
				} // while (stz.hasMoreTokens()) end

				articleList = new ArrayList();

				sql = "select * from members where com_num=?";

				for (int i = 0; i < item_list.length; i++) {

					sql += " and not mem_num=" + item_list[i];

				} // for end

			} // if (rs.next()) end

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, com_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				do {

					MemberListDataBean article = new MemberListDataBean();

					article.setMem_num(rs.getInt("mem_num"));
					article.setMem_name(rs.getString("name"));
					article.setMem_email(rs.getString("email"));
					article.setMem_pos(rs.getString("com_pos_name"));

					articleList.add(article);

				} while (rs.next());

			} // if (rs.next()) end

		} catch (Exception e) {
			e.printStackTrace();
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

		return articleList;

	} // List getMemberSearchList(String promgr_num) end

	public int addMembers(int promgr_num, String[] add_mem_num) throws Exception {
		// promgr의 mem_num을 이용 해 참여자 추가

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String item_all = "";
		String mem_num_str = "";
		int count = 0;
		String sql = "";

		for (int i = 0; i < add_mem_num.length; i++) {
			mem_num_str += "/" + add_mem_num[i];
		}

		System.out.println("mem_num_str : " + mem_num_str);

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement("select * from promgr where promgr_num= ?");
			pstmt.setInt(1, promgr_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				item_all = rs.getString("mem_num");

				sql = "update promgr set mem_num = ? where promgr_num=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, item_all + mem_num_str);
				pstmt.setInt(2, promgr_num);

				count = pstmt.executeUpdate();

			} // promgr if (rs.next()) end

		} catch (Exception e) {
			e.printStackTrace();
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

		return count;

	} // int addMembers(int promgr_num, String[] add_mem_num) end

	public int delMembers(int promgr_num, String[] del_mem_num) throws Exception {
		// promgr의 mem_num을 이용해 참여자 삭제

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String item_all = "";
		StringTokenizer stz = null;
		int[] item_list = null;
		String mem_num_str = "";
		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement("select * from promgr where promgr_num= ?");
			pstmt.setInt(1, promgr_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				item_all = rs.getString("mem_num");

				stz = new StringTokenizer(item_all, "/");

				int idx = 0;
				item_list = new int[stz.countTokens()];

				while (stz.hasMoreTokens()) {
					item_list[idx] = Integer.parseInt(stz.nextToken());
					idx++;
				} // while (stz.hasMoreTokens()) end

				for (int i = 0; i < del_mem_num.length; i++) {

					for (int j = 0; j < item_list.length; j++) {

						if (!del_mem_num[i].equals(String.valueOf(item_list[j]))) {

							if (j == 0) {
								mem_num_str += item_list[j];
							} else {
								mem_num_str += "/" + item_list[j];
							}

						}

					}

				}

				System.out.println("mem_num_str : " + mem_num_str);

				sql = "update promgr set mem_num = ? where promgr_num=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mem_num_str);
				pstmt.setInt(2, promgr_num);

				count = pstmt.executeUpdate();

			} // promgr if (rs.next()) end

		} catch (Exception e) {
			e.printStackTrace();
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

		return count;

	} // int delMembers(int promgr_num, String[] del_mem_num) end

	public int insertChkList(ChkListTitleDataBean article) throws Exception {
		// checklist 생성

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String chklist_num_str = "";
		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			sql = "insert into ";
			sql += "chklist_title(chklist_title_num,chklist_title_name,promgr_num,com_num) ";
			sql += "values(chklist_title_num.NEXTVAL,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getChklist_title_name());
			pstmt.setInt(2, article.getPromgr_num());
			pstmt.setInt(3, article.getCom_num());

			int title_insert = pstmt.executeUpdate();

			if (title_insert != 0) {
				// promgr chklist_title_num update

				sql = "select * from chklist_title where chklist_title_name=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getChklist_title_name());
				rs = pstmt.executeQuery();

				if (rs.next()) {

					String new_chklist_num = rs.getString("chklist_title_num");

					sql = "select * from promgr where promgr_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, article.getPromgr_num());
					rs = pstmt.executeQuery();

					if (rs.next()) {

						String chklist_num = rs.getString("chklist_title_num");

						if (chklist_num == null) {
							chklist_num_str = new_chklist_num;
						} else {
							chklist_num_str = chklist_num + "/" + new_chklist_num;
						}

						sql = "update promgr set chklist_title_num=? where promgr_num=?";

						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, chklist_num_str);
						pstmt.setInt(2, article.getPromgr_num());

						count = pstmt.executeUpdate();

					} // promgr chklist_title_num

				} // new_chklist_title

			} // insert chklist_title

		} catch (Exception e) {
			e.printStackTrace();
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

		return count;

	} // int insertChkList(ChkListTitleDataBean article) end

	public int insertChkItem(String title, ChkListItemDataBean article) throws Exception {
		// checklist item 생성

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int chklist_title_num = 0;
		int chklist_item_num = 0;
		String chkitem_num_str = "";
		int count = 0;
		String sql = "";

		try {

			conn = getConnection();
			// chklist_title_num
			sql = "select * from chklist_title where chklist_title_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				chklist_title_num = rs.getInt("chklist_title_num");
			}

			// insert
			sql = "insert into ";
			sql += "chklist_item(chklist_item_num,chklist_item_name,chklist_item_chk,chklist_title_num,promgr_num,com_num) ";
			sql += "values(chklist_item_num.NEXTVAL,?,0,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getChklist_item_name());
			pstmt.setInt(2, chklist_title_num);
			pstmt.setInt(3, article.getPromgr_num());
			pstmt.setInt(4, article.getCom_num());

			int item_insert = pstmt.executeUpdate();

			System.out.println("count : " + count);

			if (item_insert != 0) {
				// promgr chklist_item_num update

				// chklist_item_num
				sql = "select * from chklist_item where chklist_item_name=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getChklist_item_name());
				rs = pstmt.executeQuery();

				if (rs.next()) {

					String new_chkitem_num = rs.getString("chklist_item_num");

					sql = "select * from promgr where promgr_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, article.getPromgr_num());
					rs = pstmt.executeQuery();

					if (rs.next()) {

						String chkitem_num = rs.getString("chklist_item_num");

						if (chkitem_num == null) {
							chkitem_num_str = new_chkitem_num;
						} else {
							chkitem_num_str = chkitem_num + "/" + new_chkitem_num;
						}

						System.out.println("chkitem_num_str : " + chkitem_num_str);

						sql = "update promgr set chklist_item_num=? where promgr_num=?";

						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, chkitem_num_str);
						pstmt.setInt(2, article.getPromgr_num());

						count = pstmt.executeUpdate();

					} // promgr chklist_item_num

				} // new_chklist_item

			} // insert chklist_item

		} catch (Exception e) {
			e.printStackTrace();
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

		return count;

	} // int insertChkItem(ChkListItemDataBean article) end

} // public class PromgrDBBean end
