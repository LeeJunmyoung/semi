package promgr;

import java.sql.Timestamp;

public class MemberListDataBean {

	private int mem_num; // 회원 번호
	private String mem_name; // 회원 이름
	private String mem_email; // 회원 이메일
	private String mem_dept; // 회원 부서

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_dept() {
		return mem_dept;
	}

	public void setMem_dept(String mem_dept) {
		this.mem_dept = mem_dept;
	}

} // public class ProMgrDataBean end
