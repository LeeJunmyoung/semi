package promgr;

public class ChkListDataBean {

	private int chklist_title_num; // 진행 상황 체트 제목 번호
	private String chklist_title_name; // 진행 상황 체크 제목 이름
	private int chklist_ing; // 진행률
	private int promgr_num; // 프로젝트 번호
	private int com_num; // 회사번호

	public int getChklist_title_num() {
		return chklist_title_num;
	}

	public void setChklist_title_num(int chklist_title_num) {
		this.chklist_title_num = chklist_title_num;
	}

	public String getChklist_title_name() {
		return chklist_title_name;
	}

	public void setChklist_title_name(String chklist_title_name) {
		this.chklist_title_name = chklist_title_name;
	}

	public int getChklist_ing() {
		return chklist_ing;
	}

	public void setChklist_ing(int chklist_ing) {
		this.chklist_ing = chklist_ing;
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

} // public class ChkListTitleDataBean end
