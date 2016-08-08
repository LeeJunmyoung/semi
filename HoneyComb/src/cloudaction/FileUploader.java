package cloudaction;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import clouddb.CloudDBBean;
import clouddb.CloudDataBean;

public class FileUploader implements CommandActionCloud{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		if (request.getParameter("upload")==null){
			CloudDataBean cloudDB = new CloudDataBean();
			CloudDBBean cloud = CloudDBBean.getInstance();
			
			String savefilepath = "E://cloud//";
			HttpSession session = request.getSession();
			//占쎌뿫占쎈뻻嚥∽옙 占쎄쉭占쎈�▽틠�눊由�
			session.setAttribute("mem_num", "11");
			session.setAttribute("com_num", "1");
			session.setAttribute("name", "tester");
			//占쎄국
			MultipartRequest mr = new MultipartRequest (request,savefilepath, 1024*1024*100,"utf-8", new DefaultFileRenamePolicy());
			// (占쎌뒄筌ｏ옙揶쏆빘猿�, 占쎈솁占쎌뵬占쎌뵠 占쎈쾺占쎈연筌욑옙 野껋럥以�, 占쎈솁占쎌뵬占쎌벥 筌ㅼ뮆占쏙옙寃뺞묾占�, 占쎌뵥�굜遺얜뎃獄쎻뫗�뻼, 占쎈솁占쎌뵬筌뤿굞�뵠 占쎌뵠沃섓옙 占쎌뿳占쎌뱽 野껋럩�뒭 '占쎈솁占쎌뵬筌륅옙+1')
			//占쎈솁占쎌뵬野껋럥以� 揶쏉옙占쎌죬占쎌궎疫뀐옙
			File file = mr.getFile("uploadFile");
			String filename = String.valueOf(file);
			//占쎈솁占쎌뵬野껋럥以� 揶쏉옙占쎌죬占쎌궎疫꿸퀡嫄�
			//占쎄퉱嚥∽옙 獄쏅떽占� 占쎈솁占쎌뵬筌륅옙 \3E(<)(占쎄텊筌욑옙+占쎌돳占쎄텢甕곕뜇�깈+占쎌궞�뵳怨쀪텢占쎌뿺占쎌뵠�뵳占�_占쎈솁占쎌뵬筌륅옙+占쎄텆占쎈땾1~9)
			CreateFilePath createfilePath =  CreateFilePath.getInstance();
			String oldPath = filename.replace("\\", "/");
			System.out.println(oldPath);
			cloudDB = tempInsert(cloudDB, request);
			cloudDB = createfilePath.FilePath(cloudDB, oldPath);
			System.out.println(cloudDB.getFile_path());
			//獄쏅떽占쏙옙�솁占쎌뵬筌뤿굝嫄�
			//占쎌뵠沃섎챷占쏙옙�삢占쎈쭆 占쎌넇占쎌삢占쎌쁽 占쎌뵠占쎌뇚占쎌벥 占쎌뵠�뵳占� 揶쏉옙占쎌죬占쎌궎疫뀐옙
			String newfilename = cloudDB.getFile_path();
			int i = 0;
			i = filename.lastIndexOf(".");
			String realFileName = newfilename+filename.substring(i,filename.length());
			//占쎌뵠沃섎챷占쏙옙�삢占쎈쭆 占쎌넇占쎌삢占쎌쁽 占쎌뵠占쎌뇚占쎌벥 占쎌뵠�뵳占� 揶쏉옙占쎌죬占쎌궎疫뀐옙 占쎄국
			//占쎈솁占쎌뵬 占쎌뵠�뵳占� 獄쏅떽��疫뀐옙
			File oldfile = new File(filename);
			File newfile = new File(savefilepath+realFileName);
			oldfile.renameTo(newfile);
			//占쎈솁占쎌뵬占쎌뵠�뵳袁⑥뺍熬곷㈇由곤옙嫄�
			//占쎈솁占쎌뵬野껋럥以� 占쏙옙占쎌삢
			String file_path = String.valueOf(newfile);
			//占쎈솁占쎌뵬野껋럥以덌옙占쏙옙�삢占쎄국
			//占쎄깻占쎌뵬占쎌뒭占쎈굡db占쎈퓠 占쏙옙占쎌삢
			//占쎈쑓占쎌뵠占쎄숲 占쎈�묕옙�샒(com_num, name 占쏙옙 tempInsert占쎈퓠占쎄퐣 筌욑옙占쎌젟, file_name 占쏙옙 createFilePath.java占쎈퓠占쎄퐣 筌욑옙占쎌젟)
			cloudDB.setFile_size((int)newfile.length());
			cloudDB.setFile_path(file_path);
			//占쎈쑓占쎌뵠占쎄숲 占쎈�묕옙�샒 占쎄국
			//DB insert
			String folder = request.getParameter("folder");
			cloud.cloudInsert(cloudDB, folder);
		
			}
		return "/cloudview/uploadForm.jsp";
	}
	private CloudDataBean tempInsert(CloudDataBean cloudDB, HttpServletRequest request){
		HttpSession session = request.getSession();
		int com_num = Integer.parseInt((String)session.getAttribute("com_num"));
		String name = (String)session.getAttribute("name");
		cloudDB.setCom_num(com_num);
		cloudDB.setFile_uploader(name);
		return cloudDB;
	}
}

/*?�뜝�룞�삕�뜝占�?(xxxxxx)com_num(xxxx), mem_num(xxxxxx), file甕곕뜇�깈(xxxxxx)
?�뜝�룞�삕?�뜝�룞�삕 �뜝占�??�뜝�룞�삕 ?�뜝�룞�삕?�뜝�룞�삕?�뜝�룞�삕�뜝占�? ?�뜝�룞�삕�뜝占�?(milli)*/