package promgr;

import java.util.List;

public class ChkListViewDataBean {

	private String title_num; // 진행 상황 체트 제목 번호
	private String title_name; // 진행 상황 체크 제목 이름
	private List item_bean; // 진행 상황 체크 항목 list

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

	public List getItem_bean() {
		return item_bean;
	}

	public void setItem_bean(List item_bean) {
		this.item_bean = item_bean;
	}

} // public class ChkListViewDataBean end
