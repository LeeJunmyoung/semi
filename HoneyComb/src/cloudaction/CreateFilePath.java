//??Όκ²½λ‘(??Όλͺ?)??±
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
		//?λ‘? λ°κ? ??Όλͺ? \3E(<)(? μ§?+??¬λ²νΈ+?¬λ¦°μ¬??΄λ¦?_??Όλͺ?+??1~9)
		//? μ§λ long ?λ¬? κΈΈμ΄? int ?? ?λ³??
		int today = (int)System.currentTimeMillis();
		day = String.valueOf(today);
		//? μ§λ
		//??¬λ²νΈ??
		com  = String.valueOf(cloudDB.getCom_num());
		//??¬λ²νΈ ?

		//??
		Random random = new Random();
		int rVal = random.nextInt(8)+1;
		Val = String.valueOf(rVal);
		//?? ?
		//?΄? κ²½λ‘?€? 
		int i= 0;
		int j = 0;
		i = oldPath.lastIndexOf(".");
		j = oldPath.lastIndexOf("/");
		String tempFilePath = oldPath.substring(0,i);
		oldFile = tempFilePath.substring(j+1,tempFilePath.length());


		//(? μ§?+??¬λ²νΈ+?¬λ¦°μ¬??΄λ¦?_??Όλͺ?+??1~9)
		//?΄λ¦?
		 String name = cloudDB.getFile_uploader();
		//?΄λ¦λ		
		file_Path = day+com+name+"_"+oldFile+"_"+Val;
		cloudDB.setFile_path(file_Path);
		cloudDB.setFile_name(oldFile);
		return cloudDB;
		
	}

}
