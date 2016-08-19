package promgr;

import java.sql.Timestamp;

public class CommentDataBean {

	private int comment_num; // 댓글 번호
	private String comment_content; // 댓글 내용
	private int mem_num; // 작성자 번호
	private String mem_name; // 작성자 이름
	private int promgr_num; // 프로젝트 번호
	private int com_num; // 회사 번호
	private Timestamp comment_date;

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public int getPromgr_num() {
		return promgr_num;
	}

	public void setPromgr_num(int promgr_num) {
		this.promgr_num = promgr_num;
	}

	public int getCom_num() {
		return com_num;
	}

	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}

	public Timestamp getComment_date() {
		return comment_date;
	}

	public void setComment_date(Timestamp timestamp) {
		this.comment_date = timestamp;
	}

} // public class CommentDataBean end
