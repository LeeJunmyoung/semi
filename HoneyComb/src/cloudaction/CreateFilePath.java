//?��?��경로(?��?���?)?��?��
package cloudaction;

import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import clouddb.CloudDBBean;
import clouddb.CloudDataBean;

public class CreateFilePath {
	private static CreateFilePath instance = new CreateFilePath();
	
	public static CreateFilePath getInstance() {
		return instance;
	}
	public String FilePath(String oldPath, String filename, HttpServletRequest request){
		HttpSession session = request.getSession();
		String newPath = null;
		String day = null;
		String com_num = null;
		String name = null;
		String Val = null;
		String oldFile = null;
		
		//오늘날짜 구하기
		int today = (int)System.currentTimeMillis();
		day = String.valueOf(today);
		
		/*com_num 구하기*/
		com_num  = String.valueOf(session.getAttribute("com_num"));
		
		//파일업로더 구하기
		name = (String)session.getAttribute("name");
		
		//random값 구하기
		Random random = new Random();
		int rVal = random.nextInt(8)+1;
		Val = String.valueOf(rVal);
		
		//기본경로 추출
		int i = oldPath.lastIndexOf("/");
		String defaultPath = oldPath.substring(0,i+1);
		//확장자 추출
		int j = oldPath.lastIndexOf(".");
		String extendPath = oldPath.substring(j);
		
		//경로 추가
		newPath = defaultPath+day+name+"_"+filename+"_"+Val+extendPath;		
		
		return newPath;
		
	}

}
