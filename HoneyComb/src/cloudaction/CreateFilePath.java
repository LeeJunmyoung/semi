//?ŒŒ?¼ê²½ë¡œ(?ŒŒ?¼ëª?)?ƒ?„±
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
		//?ƒˆë¡? ë°”ê? ?ŒŒ?¼ëª? \3E(<)(?‚ ì§?+?šŒ?‚¬ë²ˆí˜¸+?˜¬ë¦°ì‚¬?Œ?´ë¦?_?ŒŒ?¼ëª?+?‚œ?ˆ˜1~9)
		//?‚ ì§œëŠ” long ?„ˆë¬? ê¸¸ì–´?„œ int ?—?„œ ?˜•ë³??™˜
		int today = (int)System.currentTimeMillis();
		day = String.valueOf(today);
		//?‚ ì§œë
		//?šŒ?‚¬ë²ˆí˜¸?‹œ?‘
		com  = String.valueOf(cloudDB.getCom_num());
		//?šŒ?‚¬ë²ˆí˜¸ ?

		//?‚œ?ˆ˜
		Random random = new Random();
		int rVal = random.nextInt(8)+1;
		Val = String.valueOf(rVal);
		//?‚œ?ˆ˜ ?
		//?´? „ê²½ë¡œ?„¤? •
		int i= 0;
		int j = 0;
		i = oldPath.lastIndexOf(".");
		j = oldPath.lastIndexOf("/");
		String tempFilePath = oldPath.substring(0,i);
		oldFile = tempFilePath.substring(j+1,tempFilePath.length());
		System.out.println(tempFilePath);
		System.out.println(oldFile);
		//(?‚ ì§?+?šŒ?‚¬ë²ˆí˜¸+?˜¬ë¦°ì‚¬?Œ?´ë¦?_?ŒŒ?¼ëª?+?‚œ?ˆ˜1~9)
		//?´ë¦?
		 String name = cloudDB.getFile_uploader();
		//?´ë¦„ë		
		file_Path = day+com+name+"_"+oldFile+"_"+Val;
		cloudDB.setFile_path(file_Path);
		cloudDB.setFile_name(oldFile);
		return cloudDB;
		
	}

}
