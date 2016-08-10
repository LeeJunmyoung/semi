package promgr;

public class CheckListTitleDataBean {

	private int checklist_title_num; // 진행 상황 체트 제목 번호
	private String checklist_title_name; // 진행 상황 체크 제목 이름
	private int promgr_num; // 프로젝트 번호
	private int com_num; // 회사번호

	public int getChecklist_title_num() {
		return checklist_title_num;
	}

	public void setChecklist_title_num(int checklist_title_num) {
		this.checklist_title_num = checklist_title_num;
	}

	public String getChecklist_title_name() {
		return checklist_title_name;
	}

	public void setChecklist_title_name(String checklist_title_name) {
		this.checklist_title_name = checklist_title_name;
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
