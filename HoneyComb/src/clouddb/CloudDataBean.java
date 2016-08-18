package clouddb;

import java.sql.Date;
import java.sql.Timestamp;

public class CloudDataBean {
	private int file_num;
	private String file_name;
	private String file_path;
	private String file_uploader;
	private int file_size;
	private Date file_date;
	private int com_num;
	private String folder;
	
	
	
	public int getFile_num() {
		return file_num;
	}
	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_uploader() {
		return file_uploader;
	}
	public void setFile_uploader(String file_uploader) {
		this.file_uploader = file_uploader;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public Date getFile_date() {
		return file_date;
	}
	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}
	public int getCom_num() {
		return com_num;
	}
	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		if(folder == null){
			this.folder = "";
		}else		
		this.folder = folder;
	}
	
	
}
