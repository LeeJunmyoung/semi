//?��?��경로(?��?���?)?��?��
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
		//?���? 바�? ?��?���? \3E(<)(?���?+?��?��번호+?��린사?��?���?_?��?���?+?��?��1~9)
		//?��짜는 long ?���? 길어?�� int ?��?�� ?���??��
		int today = (int)System.currentTimeMillis();
		day = String.valueOf(today);
		//?��짜끝
		//?��?��번호?��?��
		com  = String.valueOf(cloudDB.getCom_num());
		//?��?��번호 ?��

		//?��?��
		Random random = new Random();
		int rVal = random.nextInt(8)+1;
		Val = String.valueOf(rVal);
		//?��?�� ?��
		//?��?��경로?��?��
		int i= 0;
		int j = 0;
		i = oldPath.lastIndexOf(".");
		j = oldPath.lastIndexOf("/");
		String tempFilePath = oldPath.substring(0,i);
		oldFile = tempFilePath.substring(j+1,tempFilePath.length());
		System.out.println(tempFilePath);
		System.out.println(oldFile);
		//(?���?+?��?��번호+?��린사?��?���?_?��?���?+?��?��1~9)
		//?���?
		 String name = cloudDB.getFile_uploader();
		//?��름끝		
		file_Path = day+com+name+"_"+oldFile+"_"+Val;
		cloudDB.setFile_path(file_Path);
		cloudDB.setFile_name(oldFile);
		return cloudDB;
		
	}

}