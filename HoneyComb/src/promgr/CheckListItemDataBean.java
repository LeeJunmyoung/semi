package promgr;

public class CheckListItemDataBean {

	private int checklist_item_num; // 진행 상황 체트 항목 번호
	private String checklist_item_name; // 진행 상황 체크 항목 이름
	private String checklist_item_checked; // 진행 상황 체트 항목 체트 여부
	private int checklist_title_num; // // 진행 상황 체트 제목 번호
	private int promgr_num; // 프로젝트 번호
	private int com_num; // 회사번호

	public int getChecklist_item_num() {
		return checklist_item_num;
	}

	public void setChecklist_item_num(int checklist_item_num) {
		this.checklist_item_num = checklist_item_num;
	}

	public String getChecklist_item_name() {
		return checklist_item_name;
	}

	public void setChecklist_item_name(String checklist_item_name) {
		this.checklist_item_name = checklist_item_name;
	}

	public String getChecklist_item_checked() {
		return checklist_item_checked;
	}

	public void setChecklist_item_checked(String checklist_item_checked) {
		this.checklist_item_checked = checklist_item_checked;
	}

	public int getChecklist_title_num() {
		return checklist_title_num;
	}

	public void setChecklist_title_num(int checklist_title_num) {
		this.checklist_title_num = checklist_title_num;
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

} // public class CheckListTitleDataBean end
