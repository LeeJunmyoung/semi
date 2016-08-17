package promgr;

public class ChkListViewDataBean {

	private String title_num; // 진행 상황 체트 제목 번호
	private String title_name; // 진행 상황 체크 제목 이름
	private String[] item_num; // 진행 상황 체크 항목 번호
	private String[] item_name; // 진행 상황 체크 항목 이름

	public String getTitle_num() {
		return title_num;
	}

	public void setTitle_num(String title_num) {
		this.title_num = title_num;
	}

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}

	public String[] getItem_num() {
		return item_num;
	}

	public void setItem_num(String[] item_num) {
		this.item_num = item_num;
	}

	public String[] getItem_name() {
		return item_name;
	}

	public void setItem_name(String[] item_name) {
		this.item_name = item_name;
	}

} // public class ChkListViewDataBean end
