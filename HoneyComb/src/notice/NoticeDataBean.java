package notice;

import java.sql.Timestamp;

public class NoticeDataBean {

	private int notice_num; // 공지 글 번호
	private String notice_title; // 공지 제목
	private String notice_content; // 공지 내용
	private String notice_member; // 공지 작성자
	private Timestamp notice_date; // 공지 작성 날짜
	private int isNew; // 최신 공지 글 표시, 0=true, -1=false
	private int com_num; // 회사 번호

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public String getNotice_member() {
		return notice_member;
	}

	public void setNotice_member(String notice_member) {
		this.notice_member = notice_member;
	}

	public Timestamp getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(Timestamp notice_date) {
		this.notice_date = notice_date;
	}

	public int getCom_num() {
		return com_num;
	}

	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}

	public int getIsNew() {
		return isNew;
	}

	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}

} // public class NoticeDataBean end
