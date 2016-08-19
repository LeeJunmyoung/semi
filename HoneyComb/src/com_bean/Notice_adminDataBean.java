package com_bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Notice_adminDataBean {

	private int notice_admin_num;
	private String notice_admin_content;
	private String notice_admin_title;
	private Timestamp notice_admin_date;

	public int getNotice_admin_num() {
		return notice_admin_num;
	}

	public void setNotice_admin_num(int notice_admin_num) {
		this.notice_admin_num = notice_admin_num;
	}

	public String getNotice_admin_content() {
		return notice_admin_content;
	}

	public void setNotice_admin_content(String notice_admin_content) {
		this.notice_admin_content = notice_admin_content;
	}

	public String getNotice_admin_title() {
		return notice_admin_title;
	}

	public void setNotice_admin_title(String notice_admin_title) {
		this.notice_admin_title = notice_admin_title;
	}

	public Timestamp getNotice_admin_date() {
		return notice_admin_date;
	}

	public void setNotice_admin_date(Timestamp notice_admin_date) {
		this.notice_admin_date = notice_admin_date;
	}

}
