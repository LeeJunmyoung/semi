package notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeDBBean {
	
	private static NoticeDBBean instance = new NoticeDBBean();

	private Connection getConnection() throws Exception {

		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		
		return DriverManager.getConnection(jdbcDriver);

	} // getConnection() end

	public static NoticeDBBean getInstance() {
		return instance;
	}

	// 전체 db에 입력된 행의 수
	public int getArticleCount() throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		String sql = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from notice");
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
	public List getArticles(int start, int end) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs_isNew = null;
		List articleList = null;
		String sql = null;

		try {

			conn = getConnection();

			if (start == -1) { // main 화면에서 보여지는 list sql

				sql = "select notice_num,notice_title,notice_content,notice_member,notice_date,r from (";
				sql += "select  notice_num,notice_title,notice_content,notice_member,notice_date,rownum r from (";
				sql += "select notice_num,notice_title,notice_content,notice_member,notice_date from notice order by notice_num desc)) ";
				sql += "where rownum<=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, end);

				rs = pstmt.executeQuery();

			} else { // more 화면에서 보여지는 list sql

				sql = "select notice_num,notice_title,notice_content,notice_member,notice_date,r from (";
				sql += "select  notice_num,notice_title,notice_content,notice_member,notice_date,rownum r from (";
				sql += "select notice_num,notice_title,notice_content,notice_member,notice_date from notice order by notice_num desc)) ";
				sql += "where r>=? and r<=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);

				rs = pstmt.executeQuery();

			}

			if (rs.next()) {

				articleList = new ArrayList(end);

				do {

					NoticeDataBean article = new NoticeDataBean();

					article.setNotice_num(rs.getInt("notice_num"));
					article.setNotice_title(rs.getString("notice_title"));
					article.setNotice_content(rs.getString("notice_content"));
					article.setNotice_member(rs.getString("notice_member"));
					article.setNotice_date(rs.getTimestamp("notice_date"));

					// 공지사항 등록 시 일정 시간동안 기호 표시 여부 설정
					// extract() : 날짜의 일부분만 추출하는 sql function
					sql = "select extract(day from systimestamp-tm) ingDay from (";
					sql += "select to_timestamp((select notice_date from notice where notice_num=?)";
					sql += ", 'yy/mm/dd hh24:mi:ss.ff') tm from dual)";

					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, rs.getInt("notice_num"));

					rs_isNew = pstmt.executeQuery();

					if (rs_isNew.next()) {

						if (rs_isNew.getInt("ingDay") < 1) {
							article.setIsNew(0);
						} else {
							article.setIsNew(-1);
						}

					}

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
	public NoticeDataBean getArticle(int rowNum) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDataBean article = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement("select * from notice where notice_num=?");
			pstmt.setInt(1, rowNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				article = new NoticeDataBean();
				article.setNotice_num(rs.getInt("notice_num"));
				article.setNotice_title(rs.getString("notice_title"));
				article.setNotice_content(rs.getString("notice_content"));
				article.setNotice_member(rs.getString("notice_member"));
				article.setNotice_date(rs.getTimestamp("notice_date"));

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

	// 공지 작성 (관리자, 임원)
	public int insertArticle(NoticeDataBean article) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;

		String sql = "";

		try {

			conn = getConnection();

			// 공지 삽입
			sql = "insert into ";
			sql += "notice(notice_num,notice_title,notice_content,notice_member,notice_date) ";
			sql += "values(notice_num.NEXTVAL,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getNotice_title());
			pstmt.setString(2, article.getNotice_content());
			pstmt.setString(3, article.getNotice_member());
			pstmt.setTimestamp(4, article.getNotice_date());

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

} // public class NoticeDBBean end
