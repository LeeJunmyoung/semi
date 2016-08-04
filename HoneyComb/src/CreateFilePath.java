//파일경로(파일명)생성
package cloudaction;

import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clouddb.CloudDBBean;
import clouddb.CloudDataBean;

public class CreateFilePath {
	private static CreateFilePath instance = new CreateFilePath();
	
	public static CreateFilePath getInstance() {
		return instance;
	}
	public CloudDataBean FilePath(CloudDataBean cloudDB, String oldPath){

		String file_Path = null;
		String day = null;
		String com = null;
		String Val = null;
		String oldFile = null;
		//새로 바꿀 파일명 \3E(<)(날짜+회사번호+올린사람이름_파일명+난수1~9)
		//날짜는 long 너무 길어서 int 에서 형변환
		int today = (int)System.currentTimeMillis();
		day = String.valueOf(today);
		//날짜끝
		//회사번호시작
		com  = String.valueOf(cloudDB.getCom_num());
		//회사번호 끝

		//난수
		Random random = new Random();
		int rVal = random.nextInt(8)+1;
		Val = String.valueOf(rVal);
		//난수 끝
		//이전경로설정
		int i= 0;
		int j = 0;
		i = oldPath.lastIndexOf(".");
		j = oldPath.lastIndexOf("/");
		String tempFilePath = oldPath.substring(0,i);
		oldFile = tempFilePath.substring(j+1,tempFilePath.length());
		System.out.println(tempFilePath);
		System.out.println(oldFile);
		//(날짜+회사번호+올린사람이름_파일명+난수1~9)
		//이름
		 String name = cloudDB.getFile_uploader();
		//이름끝		
		file_Path = day+com+name+"_"+oldFile+"_"+Val;
		cloudDB.setFile_path(file_Path);
		cloudDB.setFile_name(oldFile);
		return cloudDB;
		
	}

}
