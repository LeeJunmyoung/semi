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

	// 전체 db에 입력된 행의 수
	public int getArticleCount(int com_num, String mem_num) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		String sql = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from promgr where com_num=? and mem_num like ?");
			pstmt.setInt(1, com_num);
			pstmt.setString(2, "%" + mem_num + "%");

			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
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

		return x;

	} // getArticleCount() end

	// paging, db로 부터 여러 행 목록 호출
	public List getArticles(int com_num, String mem_num, int start, int end) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		String sql = null;

		try {

			conn = getConnection();

			if (start == -1) { // main 화면에서 보여지는 list sql

				sql = "select promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,checklist_title_num,checklist_item_num,comment_num,com_num,r from (";
				sql += "select  promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,checklist_title_num,checklist_item_num,comment_num,com_num,rownum r from (";
				sql += "select promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,checklist_title_num,checklist_item_num,comment_num,com_num from promgr ";
				sql += "where com_num=? and mem_num like ? order by promgr_num desc)) ";
				sql += "where r<=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, com_num);
				pstmt.setString(2, "%" + mem_num + "%");
				pstmt.setInt(3, end);

				rs = pstmt.executeQuery();

			} else { // more 화면에서 보여지는 list sql

				sql = "select promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,checklist_title_num,checklist_item_num,comment_num,com_num,r from (";
				sql += "select promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,checklist_title_num,checklist_item_num,comment_num,com_num,rownum r from (";
				sql += "select promgr_num,promgr_name,promgr_content,promgr_date,mem_num,file_num,checklist_title_num,checklist_item_num,comment_num,com_num from promgr ";
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
					article.setChecklist_title_num(rs.getString("checklist_title_num"));
					article.setChecklist_item_num(rs.getString("checklist_item_num"));
					article.setComment_num(rs.getString("comment_num"));
					article.setCom_num(rs.getInt("com_num"));

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

	} // List getArticles(int endRow) end

	// db로 부터 목록의 한 항목의 데이터를 호출
	public PromgrDataBean getArticle(int rowNum, String mem_num) throws Exception {

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
				article.setChecklist_title_num(rs.getString("checklist_title_num"));
				article.setChecklist_item_num(rs.getString("checklist_item_num"));
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

	} // NoticeDataBean getArticle(int rowNum) end

	// 프로젝트 메니저 생성
	public int insertArticle(PromgrDataBean article) throws Exception {

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

	} // insertArticle(BoardDataBean article) end

	// promgr의 mem_num의 정보를 가져와서 분리 후 참여자 정보 호출
	public List getMemberDataList(int promgr_num) throws Exception {

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

			pstmt = conn.prepareStatement("select * from promgr where promgr_num= ? ");
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

				articleList = new ArrayList();

				for (int i = 0; i < item_list.length; i++) {

					pstmt = conn.prepareStatement("select * from members where mem_num = ? ");
					pstmt.setInt(1, item_list[i]);

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

	} // List getMemberDataList(int promgr_num) end

	// promgr의 mem_num의 정보를 가져와서 분리 후 참여자 제외한 정보 호출
	public List getMemberSearchList(int promgr_num) throws Exception {

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
			pstmt.setInt(1, promgr_num);

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
				
				System.out.println("sql : " + sql);

			} // if (rs.next()) end

			pstmt = conn.prepareStatement(sql);

			System.out.println("com_num : " + com_num);
			
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

	} // List getMemberSearchList(int promgr_num, String token) end

} // public class NoticeDBBean end
