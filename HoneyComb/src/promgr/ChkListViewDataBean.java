package promgr;

import java.util.List;

public class ChkListViewDataBean {

	private String list_num; // 진행 상황 체트 제목 번호
	private String list_name; // 진행 상황 체크 제목 이름
	private int list_ing; // 진행 상황 진행률
	private List item_bean; // 진행 상황 체크 항목 list

	public String getList_num() {
		return list_num;
	}

	public void setList_num(String list_num) {
		this.list_num = list_num;
	}

	public String getList_name() {
		return list_name;
	}

	public void setList_name(String list_name) {
		this.list_name = list_name;
	}

	public int getList_ing() {
		return list_ing;
	}

	public void setList_ing(int list_ing) {
		this.list_ing = list_ing;
	}

	public List getItem_bean() {
		return item_bean;
	}

	public void setItem_bean(List item_bean) {
		this.item_bean = item_bean;
	}

} // public class ChkListViewDataBean end
