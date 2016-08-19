package promgr;

public class ChkItemDataBean {

	private int chklist_item_num; // 진행 상황 체트 항목 번호
	private String chklist_item_name; // 진행 상황 체크 항목 이름
	private int chklist_item_chk; // 진행 상황 체트 항목 체트 여부
	private int chklist_title_num; // // 진행 상황 체트 제목 번호
	private int promgr_num; // 프로젝트 번호
	private int com_num; // 회사번호

	public int getChklist_item_num() {
		return chklist_item_num;
	}

	public void setChklist_item_num(int chklist_item_num) {
		this.chklist_item_num = chklist_item_num;
	}

	public String getChklist_item_name() {
		return chklist_item_name;
	}

	public void setChklist_item_name(String chklist_item_name) {
		this.chklist_item_name = chklist_item_name;
	}

	public int getChklist_item_chk() {
		return chklist_item_chk;
	}

	public void setChklist_item_chk(int chklist_item_chk) {
		this.chklist_item_chk = chklist_item_chk;
	}

	public int getChklist_title_num() {
		return chklist_title_num;
	}

	public void setChklist_title_num(int chklist_title_num) {
		this.chklist_title_num = chklist_title_num;
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

} // public class ChkListItemDataBean end
