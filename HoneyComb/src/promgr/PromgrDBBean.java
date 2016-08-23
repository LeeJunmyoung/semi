package promgr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import clouddb.CloudDataBean;

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
		
		ResultSet rs_promgr = null;
		ResultSet rs_mem_name = null;
		ResultSet rs_chklist_title = null;
		ResultSet rs_chklist_item = null;
		ResultSet rs_file = null;
		ResultSet rs_comment = null;
		ResultSet rs_comment_mem_name = null;

		StringTokenizer stz = null;
		int[] item_list = null;
		int idx = 0;

		String[] mem_name_arr = null;
		List chklist_view = null;
		List chkitem_bean = null;
		List file_view = null;
		List comment_view = null;

		List articleList = null;
		String sql = "";

		try {

			conn = getConnection();

			if (start == -1) { // main 화면에서 보여지는 list sql

				sql = "select promgr_num,promgr_name,promgr_content,promgr_date,promgr_ing,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num,r from (";
				sql += "select promgr_num,promgr_name,promgr_content,promgr_date,promgr_ing,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num,rownum r from (";
				sql += "select promgr_num,promgr_name,promgr_content,promgr_date,promgr_ing,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num from promgr ";
				sql += "where com_num=? and mem_num like ? order by promgr_num desc)) ";
				sql += "where r<=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, com_num);
				pstmt.setString(2, "%" + mem_num + "%");
				pstmt.setInt(3, end);

				rs_promgr = pstmt.executeQuery();

			} else { // more 화면에서 보여지는 list sql

				sql = "select promgr_num,promgr_name,promgr_content,promgr_date,promgr_ing,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num,r from (";
				sql += "select promgr_num,promgr_name,promgr_content,promgr_date,promgr_ing,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num,rownum r from (";
				sql += "select promgr_num,promgr_name,promgr_content,promgr_date,promgr_ing,mem_num,file_num,chklist_title_num,chklist_item_num,comment_num,com_num from promgr ";
				sql += "where com_num=? and mem_num like ? order by promgr_num desc)) ";
				sql += "where r>=? and r<=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, com_num);
				pstmt.setString(2, "%" + mem_num + "%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);

				rs_promgr = pstmt.executeQuery();

			}

			if (rs_promgr.next()) {

				articleList = new ArrayList(end);

				do {

					PromgrDataBean article = new PromgrDataBean();

					article.setPromgr_num(rs_promgr.getInt("promgr_num"));
					article.setPromgr_name(rs_promgr.getString("promgr_name"));
					article.setPromgr_content(rs_promgr.getString("promgr_content"));
					article.setPromgr_ing(rs_promgr.getInt("promgr_ing"));
					article.setPromgr_date(rs_promgr.getTimestamp("promgr_date"));
					article.setMem_num(rs_promgr.getString("mem_num"));
					article.setCom_num(rs_promgr.getInt("com_num"));

					// <num_name arr setting>
					// mem_num 분리
					stz = new StringTokenizer(rs_promgr.getString("mem_num"), "/");

					idx = 0;
					item_list = new int[stz.countTokens()];

					while (stz.hasMoreTokens()) {
						item_list[idx] = Integer.parseInt(stz.nextToken());
						idx++;
					} // while (stz.hasMoreTokens()) end

					// mem_num -> mem_name
					mem_name_arr = new String[item_list.length];

					for (int i = 0; i < item_list.length; i++) {

						pstmt = conn.prepareStatement("select * from members where mem_num=?");
						pstmt.setInt(1, item_list[i]);

						ResultSet rs_name = pstmt.executeQuery();

						if (rs_name.next()) {

							mem_name_arr[i] = rs_name.getString("name");

						} // members item if (rs.next()) end

					} // mem_name_arr for end

					article.setMem_name_arr(mem_name_arr);

					// <chklist_view setting>
					chklist_view = new ArrayList();

					// chklist_title_num 분리
					if (rs_promgr.getString("chklist_title_num") != null) {
						stz = new StringTokenizer(rs_promgr.getString("chklist_title_num"), "/");
					}

					idx = 0;
					item_list = new int[stz.countTokens()];

					while (stz.hasMoreTokens()) {
						item_list[idx] = Integer.parseInt(stz.nextToken());
						idx++;
					} // while (stz.hasMoreTokens()) end

					for (int i = 0; i < item_list.length; i++) {
						// chklist_view item setting

						pstmt = conn.prepareStatement("select * from chklist_title where chklist_title_num=?");
						pstmt.setInt(1, item_list[i]);

						rs_chklist_title = pstmt.executeQuery();

						if (rs_chklist_title.next()) {

							ChkListViewDataBean chklist_view_item = new ChkListViewDataBean();

							chklist_view_item.setList_num(rs_chklist_title.getString("chklist_title_num"));
							chklist_view_item.setList_name(rs_chklist_title.getString("chklist_title_name"));
							chklist_view_item.setList_ing(rs_chklist_title.getInt("chklist_title_ing"));

							sql = "select * from chklist_item where chklist_title_num=?";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, rs_chklist_title.getString("chklist_title_num"));

							rs_chklist_item = pstmt.executeQuery();

							if (rs_chklist_item.next()) {

								chkitem_bean = new ArrayList();

								int idx_item = 0;

								do {

									ChkItemDataBean item = new ChkItemDataBean();

									item.setChklist_item_num(rs_chklist_item.getInt("chklist_item_num"));
									item.setChklist_item_name(rs_chklist_item.getString("chklist_item_name"));
									item.setChklist_item_chk(rs_chklist_item.getInt("chklist_item_chk"));

									chkitem_bean.add(item);

								} while (rs_chklist_item.next());

								chklist_view_item.setItem_bean(chkitem_bean);

							} // chklist_item item if (rs.next()) end

							chklist_view.add(chklist_view_item);

						} // chklist_title item if (rs.next()) end

					} // chklist_title_arr for end

					article.setChklist_view(chklist_view);

					// <file_view setting>
					file_view = new ArrayList();
					
					// file_num 분리
					if (rs_promgr.getString("file_num") != null) {
						stz = new StringTokenizer(rs_promgr.getString("file_num"), "/");
					}

					idx = 0;
					item_list = new int[stz.countTokens()];

					while (stz.hasMoreTokens()) {
						item_list[idx] = Integer.parseInt(stz.nextToken());
						idx++;
					} // while (stz.hasMoreTokens()) end

					file_view = new ArrayList();

					for (int i = 0; i < item_list.length; i++) {
						// file_view item setting

						sql = "select * from cloud where file_num=? order by file_num desc";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, item_list[i]);

						rs_file = pstmt.executeQuery();

						if (rs_file.next()) {

							FileDataBean item = new FileDataBean();

							item.setFile_num(rs_file.getInt("file_num"));
							item.setFile_name(rs_file.getString("file_name"));
							item.setFile_path(rs_file.getString("file_path"));
							item.setFile_date(rs_file.getDate("file_date"));
							item.setMem_num(rs_file.getInt("mem_num"));
							item.setMem_name(rs_file.getString("file_uploader"));

							file_view.add(item);

						} // comment_view_item

					} // comment_view

					article.setFile_view(file_view);

					// <comment_view setting>
					if (rs_promgr.getString("comment_num") != null) {
						stz = new StringTokenizer(rs_promgr.getString("comment_num"), "/");
					}

					idx = 0;
					item_list = new int[stz.countTokens()];

					while (stz.hasMoreTokens()) {
						item_list[idx] = Integer.parseInt(stz.nextToken());
						idx++;
					} // while (stz.hasMoreTokens()) end

					comment_view = new ArrayList();

					for (int i = 0; i < item_list.length; i++) {
						// chklist_view item setting

						sql = "select * from promgr_comment where comment_num=? order by comment_num desc";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, item_list[i]);

						rs_comment = pstmt.executeQuery();

						if (rs_comment.next()) {

							CommentDataBean item = new CommentDataBean();

							item.setComment_num(rs_comment.getInt("comment_num"));
							item.setComment_content(rs_comment.getString("comment_content"));
							item.setMem_num(rs_comment.getInt("mem_num"));
							item.setPromgr_num(rs_comment.getInt("promgr_num"));
							item.setCom_num(rs_comment.getInt("com_num"));
							item.setComment_date(rs_comment.getTimestamp("comment_date"));

							sql = "select * from members where mem_num=?";
							pstmt = conn.prepareStatement(sql);
							pstmt.setInt(1, rs_comment.getInt("mem_num"));

							rs_comment_mem_name = pstmt.executeQuery();

							if (rs_comment_mem_name.next()) {
								item.setMem_name(rs_comment_mem_name.getString("name"));
							}

							comment_view.add(item);

						} // comment_view_item

					} // comment_view

					article.setComment_view(comment_view);

					articleList.add(article);

				} while (rs_promgr.next());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs_promgr != null)
				try {
					rs_promgr.close();
				} catch (SQLException ex) {
				}
			
			if (rs_mem_name != null)
				try {
					rs_mem_name.close();
				} catch (SQLException ex) {
				}
			
			if (rs_chklist_title != null)
				try {
					rs_chklist_title.close();
				} catch (SQLException ex) {
				}
			
			if (rs_chklist_item != null)
				try {
					rs_chklist_item.close();
				} catch (SQLException ex) {
				}
			
			if (rs_file != null)
				try {
					rs_file.close();
				} catch (SQLException ex) {
				}
			
			if (rs_comment != null)
				try {
					rs_comment.close();
				} catch (SQLException ex) {
				}
			
			if (rs_comment_mem_name != null)
				try {
					rs_comment_mem_name.close();
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

	public int AddPromgr(PromgrDataBean article) throws Exception {
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

	} // int addPromgr(PromgrDataBean article) end

	public List getMemberDataList(String promgr_num, int my_mem_num) throws Exception {
		// promgr의 mem_num의 정보를 가져와서 분리 후 참여자 정보 호출

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String item_all = null;
		StringTokenizer stz = null;
		int[] item_list = null;

		List articleList = null;

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
		String sql = "";

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

	public int addChkList(ChkListDataBean article) throws Exception {
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

			if (title_insert > 0) {
				// promgr chklist_title_num update

				sql = "select * from chklist_title where chklist_title_name=? order by chklist_title_num desc";
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

	} // int addChkList(ChkListTitleDataBean article) end

	public int addChkItem(int list_num, ChkItemDataBean article) throws Exception {
		// checklist item 생성

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		ResultSet rs_chklist = null;

		String chkitem_num_str = "";

		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			// insert
			sql = "insert into ";
			sql += "chklist_item(chklist_item_num,chklist_item_name,chklist_item_chk,chklist_title_num,promgr_num,com_num) ";
			sql += "values(chklist_item_num.NEXTVAL,?,0,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getChklist_item_name());
			pstmt.setInt(2, list_num);
			pstmt.setInt(3, article.getPromgr_num());
			pstmt.setInt(4, article.getCom_num());

			int item_insert = pstmt.executeUpdate();

			if (item_insert != 0) {
				// promgr chklist_item_num update

				// chklist_item_num
				sql = "select * from chklist_item where chklist_item_name=? order by chklist_item_num desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getChklist_item_name());
				rs = pstmt.executeQuery();

				if (rs.next()) {

					String new_chkitem_num = rs.getString("chklist_item_num");

					sql = "select * from promgr where promgr_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, article.getPromgr_num());
					rs_chklist = pstmt.executeQuery();

					if (rs_chklist.next()) {

						String chkitem_num = rs.getString("chklist_item_num");

						if (chkitem_num == null) {
							chkitem_num_str = new_chkitem_num;
						} else {
							chkitem_num_str = chkitem_num + "/" + new_chkitem_num;
						}

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
			
			if (rs_chklist != null)
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

	} // int addChkItem(ChkListItemDataBean article) end

	public int delPromgr(String promgr_num, int com_num) throws Exception {
		// promgr 삭제

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			sql = "delete from chklist_item where promgr_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, promgr_num);
			count = pstmt.executeUpdate();

			sql = "delete from chklist_title where promgr_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, promgr_num);
			count = pstmt.executeUpdate();

			// file del

			sql = "delete from promgr_comment where promgr_num=? and com_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, promgr_num);
			pstmt.setInt(2, com_num);
			count = pstmt.executeUpdate();

			sql = "delete from promgr where promgr_num=? and com_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, promgr_num);
			pstmt.setInt(2, com_num);
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

	} // int delPromgr(String promgr_num, int com_num) end

	public int delChkItem(int promgr_num, int item_num) throws Exception {
		// promgr의 item_num을 이용해 chklist_item 삭제

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String chkitem_num_str = "";

		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			sql = "delete from chklist_item where chklist_item_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_num);
			count = pstmt.executeUpdate();

			if (count > 0) {
				// promgr에서 chklist_item_num 호출

				pstmt = conn.prepareStatement("select * from chklist_item where promgr_num=?");
				pstmt.setInt(1, promgr_num);

				rs = pstmt.executeQuery();

				if (rs.next()) {

					do {

						if (chkitem_num_str.equals("")) {
							chkitem_num_str += rs.getString("chklist_item_num");
						} else {
							chkitem_num_str += "/" + rs.getString("chklist_item_num");
						}

					} while (rs.next());

					System.out.println("chkitem_num_str : " + chkitem_num_str);

					sql = "update promgr set chklist_item_num=? where promgr_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, chkitem_num_str);
					pstmt.setInt(2, promgr_num);

					count = pstmt.executeUpdate();

				} // promgr if (rs.next()) end

			} // chklist_item del

		} catch (

		Exception e) {
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

	} // int delChkItem(int promgr_num, int item_num) end

	public int delChkList(int promgr_num, int list_num) throws Exception {
		// promgr의 title_num을 이용해 chklist_title 삭제

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;

		String chklist_num_str = "";
		String chkitem_num_str = "";

		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			// title_num에 해당하는 chklist_item 삭제
			sql = "delete from chklist_item where chklist_title_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, list_num);
			count = pstmt.executeUpdate();

			if (count > 0) {

				pstmt = conn.prepareStatement("select * from chklist_item where promgr_num=?");
				pstmt.setInt(1, promgr_num);

				rs = pstmt.executeQuery();

				if (rs.next()) {

					do {

						if (chkitem_num_str.equals("")) {
							chkitem_num_str += rs.getString("chklist_item_num");
						} else {
							chkitem_num_str += "/" + rs.getString("chklist_item_num");
						}

					} while (rs.next());

					sql = "update promgr set chklist_item_num=? where promgr_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, chkitem_num_str);
					pstmt.setInt(2, promgr_num);

					count = pstmt.executeUpdate();

				} // promgr if (rs.next()) end

			} // chklist_item del

			// title_num에 해당하는 chklist_title 삭제
			sql = "delete from chklist_title where chklist_title_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, list_num);
			count = pstmt.executeUpdate();

			if (count > 0) {
				// promgr에서 chklist_title_num 호출

				pstmt = conn.prepareStatement("select * from chklist_title where promgr_num=?");
				pstmt.setInt(1, promgr_num);

				rs = pstmt.executeQuery();

				if (rs.next()) {

					do {

						if (chklist_num_str.equals("")) {
							chklist_num_str += rs.getString("chklist_title_num");
						} else {
							chklist_num_str += "/" + rs.getString("chklist_title_num");
						}

					} while (rs.next());

					sql = "update promgr set chklist_title_num=? where promgr_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, chklist_num_str);
					pstmt.setInt(2, promgr_num);

					count = pstmt.executeUpdate();

				}

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

	} // int delChkList(int promgr_num, int title_num) end

	public int modChkList(int list_num, String list_name) throws Exception {
		// promgr의 list_num을 이용해 chklist_title_name 변경

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			sql = "update chklist_title set chklist_title_name=? where chklist_title_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, list_name);
			pstmt.setInt(2, list_num);

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

	} // int modChkList(int title_num, String title_name) end

	public int modChkItem(int item_num, String item_name) throws Exception {
		// promgr의 title_num을 이용해 chklist_title_name 변경

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			sql = "update chklist_item set chklist_item_name=? where chklist_item_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_name);
			pstmt.setInt(2, item_num);

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

	} // int modChkItem(int item_num, String item_name) end

	public int addComment(CommentDataBean article) throws Exception {
		// checklist item 생성

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String comment_num_str = "";

		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			// insert
			sql = "insert into ";
			sql += "promgr_comment(comment_num,comment_content,mem_num,promgr_num,com_num,comment_date) ";
			sql += "values(comment_num.NEXTVAL,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getComment_content());
			pstmt.setInt(2, article.getMem_num());
			pstmt.setInt(3, article.getPromgr_num());
			pstmt.setInt(4, article.getCom_num());
			pstmt.setTimestamp(5, article.getComment_date());

			count = pstmt.executeUpdate();

			if (count > 0) {
				// promgr comment_num update

				// comment_num
				sql = "select * from promgr_comment where mem_num=? order by comment_num desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, article.getMem_num());
				rs = pstmt.executeQuery();

				if (rs.next()) {

					String new_comment_num = rs.getString("comment_num");

					sql = "select * from promgr where promgr_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, article.getPromgr_num());
					rs = pstmt.executeQuery();

					if (rs.next()) {

						String comment_num = rs.getString("comment_num");

						if (comment_num == null) {
							comment_num_str = new_comment_num;
						} else {
							comment_num_str = comment_num + "/" + new_comment_num;
						}

						sql = "update promgr set comment_num=? where promgr_num=?";

						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, comment_num_str);
						pstmt.setInt(2, article.getPromgr_num());

						count = pstmt.executeUpdate();

					} // promgr comment_num

				} // new_comment_num

			} // insert comment_num

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

	} // int addComment(ChkItemDataBean article) end

	public int modComment(int comment_num, String comment_content, Timestamp update_date) throws Exception {
		// promgr의 comment_num을 이용해 comment_content 변경

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			sql = "update promgr_comment set comment_content=? where comment_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment_content);
			pstmt.setInt(2, comment_num);

			count = pstmt.executeUpdate();

			sql = "update promgr_comment set comment_date=? where comment_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, update_date);
			pstmt.setInt(2, comment_num);

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

	} // int modComment(int comment_num, String comment_name) end

	public int delComment(int promgr_num, int comment_num) throws Exception {
		// promgr의 comment_num을 이용해 comment 삭제

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String comment_num_str = "";

		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			sql = "delete from promgr_comment where comment_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment_num);
			count = pstmt.executeUpdate();

			if (count > 0) {
				// promgr에서 comment_num 호출

				pstmt = conn.prepareStatement("select * from promgr_comment where promgr_num=?");
				pstmt.setInt(1, promgr_num);

				rs = pstmt.executeQuery();

				if (rs.next()) {

					do {

						if (comment_num_str.equals("")) {
							comment_num_str += rs.getInt("comment_num");
						} else {
							comment_num_str += "/" + rs.getString("comment_num");
						}

					} while (rs.next());

					System.out.println("comment_num_str : " + comment_num_str);

					sql = "update promgr set comment_num=? where promgr_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, comment_num_str);
					pstmt.setInt(2, promgr_num);

					count = pstmt.executeUpdate();

				} // promgr if (rs.next()) end

			} // comment del

		} catch (

		Exception e) {
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

	} // int delComment(int promgr_num, int comment_num) end

	public int ChangeCheckedItem(int promgr_num, int list_num, int item_num, int checked) throws Exception {
		// promgr의 item_num을 이용해 chklist_item_chk 변경

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs_list_item_all = null;
		ResultSet rs_list_item_chk = null;
		ResultSet rs_promgr_item_all = null;
		ResultSet rs_promgr_item_chk = null;

		int list_item_all = 0;
		int list_item_chk = 0;
		int promgr_item_all = 0;
		int promgr_item_chk = 0;

		int count = 0;
		String sql = "";

		try {

			conn = getConnection();

			sql = "update chklist_item set chklist_item_chk= ? where chklist_item_num= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, checked);
			pstmt.setInt(2, item_num);

			int update_count = pstmt.executeUpdate();
			
			if (update_count > 0) {

				// [list_ing setting]
				// list item all
				sql = "select count(*) from chklist_item where chklist_title_num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, list_num);
				rs_list_item_all = pstmt.executeQuery();

				if (rs_list_item_all.next()) {
					list_item_all = rs_list_item_all.getInt(1);
				}

				// list item chk
				sql = "select count(*) from chklist_item where chklist_title_num=? and chklist_item_chk=1";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, list_num);

				rs_list_item_chk = pstmt.executeQuery();

				if (rs_list_item_chk.next()) {
					list_item_chk = rs_list_item_chk.getInt(1);
				}

				// list_ing 계산
				int list_ing = (int) ((double) list_item_chk / (double) list_item_all * 100);

				sql = "update chklist_title set chklist_title_ing=? where chklist_title_num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, list_ing);
				pstmt.setInt(2, list_num);

				int list_update_count = pstmt.executeUpdate();

				if (list_update_count > 0) {
					
					// [promgr_ing setting]
					// promgr item all
					
					System.out.println("promgr::::"+promgr_num);
					sql = "select count(*) from chklist_item where promgr_num = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, promgr_num);
					rs_promgr_item_all = pstmt.executeQuery();

					if (rs_promgr_item_all.next()) {
						promgr_item_all = rs_promgr_item_all.getInt(1);
					}

					// promgr item chk
					sql = "select count(*) from chklist_item where promgr_num=? and chklist_item_chk=1";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, promgr_num);
					rs_promgr_item_chk = pstmt.executeQuery();

					if (rs_promgr_item_chk.next()) {
						promgr_item_chk = rs_promgr_item_chk.getInt(1);
					}
					
					// promgr_ing 계산
					int promgr_ing = (int) ((double) promgr_item_chk / (double) promgr_item_all * 100);

					sql = "update promgr set promgr_ing=? where promgr_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, promgr_ing);
					pstmt.setInt(2, promgr_num);

					count = pstmt.executeUpdate();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs_list_item_all != null)
				try {
					rs_list_item_all.close();
				} catch (SQLException ex) {
				}
			
			if (rs_list_item_chk != null)
				try {
					rs_list_item_chk.close();
				} catch (SQLException ex) {
				}
			
			if (rs_promgr_item_all != null)
				try {
					rs_promgr_item_all.close();
				} catch (SQLException ex) {
				}
			
			if (rs_promgr_item_chk != null)
				try {
					rs_promgr_item_chk.close();
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

	} // int int ChangeCheckedItem(int item_num, int checked) end

} // public class PromgrDBBean end
