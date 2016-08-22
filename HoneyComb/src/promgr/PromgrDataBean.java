package promgr;

import java.sql.Timestamp;
import java.util.List;

public class PromgrDataBean {

	private int promgr_num; // 프로젝트 번호
	private String promgr_name; // 프로젝트 이름
	private String promgr_content; // 프로젝트 내용
	private Timestamp promgr_date; // 프로젝트 생성 날짜
	private int promgr_ing; // 프로젝트 진행률
	private String mem_num; // 프로젝트 참여자 번호
	private String[] mem_name_arr; // 프로젝트 참여자 이름
	private List file_view;
	private List chklist_view; // 진행 상황 체크
	private List comment_view; // 댓글 번호
	private int com_num; // 회사 번호

	public int getPromgr_num() {
		return promgr_num;
	}

	public void setPromgr_num(int promgr_num) {
		this.promgr_num = promgr_num;
	}

	public String getPromgr_name() {
		return promgr_name;
	}

	public void setPromgr_name(String promgr_name) {
		this.promgr_name = promgr_name;
	}

	public String getPromgr_content() {
		return promgr_content;
	}

	public void setPromgr_content(String promgr_content) {
		this.promgr_content = promgr_content;
	}

	public Timestamp getPromgr_date() {
		return promgr_date;
	}

	public void setPromgr_date(Timestamp promgr_date) {
		this.promgr_date = promgr_date;
	}

	public int getPromgr_ing() {
		return promgr_ing;
	}

	public void setPromgr_ing(int promgr_ing) {
		this.promgr_ing = promgr_ing;
	}

	public String getMem_num() {
		return mem_num;
	}

	public void setMem_num(String mem_num) {
		this.mem_num = mem_num;
	}

	public String[] getMem_name_arr() {
		return mem_name_arr;
	}

	public void setMem_name_arr(String[] mem_name_arr) {
		this.mem_name_arr = mem_name_arr;
	}

	public List getFile_view() {
		return file_view;
	}

	public void setFile_view(List file_view) {
		this.file_view = file_view;
	}

	public List getChklist_view() {
		return chklist_view;
	}

	public void setChklist_view(List chklist_view) {
		this.chklist_view = chklist_view;
	}

	public List getComment_view() {
		return comment_view;
	}

	public void setComment_view(List comment_view) {
		this.comment_view = comment_view;
	}

	public int getCom_num() {
		return com_num;
	}

	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}

} // public class ProMgrDataBean end
