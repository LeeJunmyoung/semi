package LogInDB;

import java.sql.Timestamp;

public class LogOnDataBean {
	private int mem_num;
	private String name;
	private String email;
	private String passwd;
	private String phone_num;
	private int com_num;
	private int com_dept_num;
	private int com_pos_num;
	
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public int getCom_num() {
		return com_num;
	}
	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}
	public int getCom_dept_num() {
		return com_dept_num;
	}
	public void setCom_dept_num(int com_dept_num) {
		this.com_dept_num = com_dept_num;
	}
	public int getCom_pos_num() {
		return com_pos_num;
	}
	public void setCom_pos_num(int com_pos_num) {
		this.com_pos_num = com_pos_num;
	}
	
	
	
}
