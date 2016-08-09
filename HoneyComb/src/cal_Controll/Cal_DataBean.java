/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package cal_Controll;

import java.util.Date;

public class Cal_DataBean {
	private int cal_num;
	private String cal_subject;
	private String cal_contents;
	private Date cal_start;
	private Date cal_end;

	public int getCal_num() {
		return this.cal_num;
	}

	public void setCal_num(int cal_num) {
		this.cal_num = cal_num;
	}

	public String getCal_subject() {
		return this.cal_subject;
	}

	public void setCal_subject(String cal_subject) {
		this.cal_subject = cal_subject;
	}

	public String getCal_contents() {
		return this.cal_contents;
	}

	public void setCal_contents(String cal_contents) {
		this.cal_contents = cal_contents;
	}

	public Date getCal_start() {
		return this.cal_start;
	}

	public void setCal_start(Date cal_start) {
		this.cal_start = cal_start;
	}

	public Date getCal_end() {
		return this.cal_end;
	}

	public void setCal_end(Date cal_end) {
		this.cal_end = cal_end;
	}
}