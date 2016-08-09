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
		
		String writefile = (String)request.getParameter("file_name");
		System.out.println("입력한 파일:"+writefile);
		String folde = request.getParameter("folder");
		System.out.println("입력폴더:"+folde);
		if (request.getParameter("upload")==null){
			CloudDataBean cloudDB = new CloudDataBean();
			CloudDBBean cloud = CloudDBBean.getInstance();
			
			String savefilepath = "E://cloud//";
			HttpSession session = request.getSession();
			//�뜝�럩肉ュ뜝�럥六삣슖�댙�삕 �뜝�럡�돪�뜝�럥占썩뼺�떊占쎈닁�뵳占�
			session.setAttribute("mem_num", "11");
			session.setAttribute("com_num", "1");
			session.setAttribute("name", "tester");
			//�뜝�럡援�
			MultipartRequest mr = new MultipartRequest (request,savefilepath, 1024*1024*100,"utf-8", new DefaultFileRenamePolicy());
			// (�뜝�럩�뭵嶺뚳퐦�삕�뤆�룇鍮섊뙼占�, �뜝�럥�냱�뜝�럩逾у뜝�럩逾� �뜝�럥苡뷴뜝�럥�뿰嶺뚯쉻�삕 �뇦猿뗫윥餓ο옙, �뜝�럥�냱�뜝�럩逾у뜝�럩踰� 嶺뚣끉裕녶뜝�룞�삕野껊틷臾얍뜝占�, �뜝�럩逾ο옙援쒒겫�뼔�럠�뛾�렮維쀯옙六�, �뜝�럥�냱�뜝�럩逾х춯琉욧턂占쎈턄 �뜝�럩逾졿쾬�꼻�삕 �뜝�럩肉녑뜝�럩諭� �뇦猿뗫윪占쎈뮡 '�뜝�럥�냱�뜝�럩逾х춯瑜낆삕+1')
			//�뜝�럥�냱�뜝�럩逾ч뇦猿뗫윥餓ο옙 �뤆�룊�삕�뜝�럩二у뜝�럩沅롧뼨�먯삕
			File file = mr.getFile("uploadFile");
			String filename = String.valueOf(file);
			//�뜝�럥�냱�뜝�럩逾ч뇦猿뗫윥餓ο옙 �뤆�룊�삕�뜝�럩二у뜝�럩沅롧뼨轅명�▼쳞占�
			//�뜝�럡�돮�슖�댙�삕 �뛾�룆�뼺�뜝占� �뜝�럥�냱�뜝�럩逾х춯瑜낆삕 \3E(<)(�뜝�럡�뀏嶺뚯쉻�삕+�뜝�럩�뤂�뜝�럡�뀬�뵓怨뺣쐡占쎄퉰+�뜝�럩沅욑옙逾녔�⑥�ろ뀬�뜝�럩肉뷴뜝�럩逾좑옙逾녑뜝占�_�뜝�럥�냱�뜝�럩逾х춯瑜낆삕+�뜝�럡�뀊�뜝�럥�빢1~9)
			CreateFilePath createfilePath =  CreateFilePath.getInstance();
			String oldPath = filename.replace("\\", "/");
			cloudDB = tempInsert(cloudDB, request);
			
			
			
			cloudDB = createfilePath.FilePath(cloudDB, oldPath);
			//�뛾�룆�뼺�뜝�룞�삕占쎌냱�뜝�럩逾х춯琉욧턁椰꾬옙
			//�뜝�럩逾졿쾬�꼶梨룟뜝�룞�삕占쎌궋�뜝�럥彛� �뜝�럩�꼪�뜝�럩�궋�뜝�럩�겱 �뜝�럩逾졾뜝�럩�뇶�뜝�럩踰� �뜝�럩逾좑옙逾녑뜝占� �뤆�룊�삕�뜝�럩二у뜝�럩沅롧뼨�먯삕
			String newfilename = cloudDB.getFile_path();
			int i = 0;
			i = filename.lastIndexOf(".");
			String realFileName = newfilename+filename.substring(i,filename.length());
			//�뜝�럩逾졿쾬�꼶梨룟뜝�룞�삕占쎌궋�뜝�럥彛� �뜝�럩�꼪�뜝�럩�궋�뜝�럩�겱 �뜝�럩逾졾뜝�럩�뇶�뜝�럩踰� �뜝�럩逾좑옙逾녑뜝占� �뤆�룊�삕�뜝�럩二у뜝�럩沅롧뼨�먯삕 �뜝�럡援�
			//�뜝�럥�냱�뜝�럩逾� �뜝�럩逾좑옙逾녑뜝占� �뛾�룆�뼺占쏙옙�뼨�먯삕
			File oldfile = new File(filename);
			File newfile = new File(savefilepath+realFileName);
			oldfile.renameTo(newfile);
			//�뜝�럥�냱�뜝�럩逾у뜝�럩逾좑옙逾녘쥈�뫁類띸넭怨룔늾�뵳怨ㅼ삕椰꾬옙
			//�뜝�럥�냱�뜝�럩逾ч뇦猿뗫윥餓ο옙 �뜝�룞�삕�뜝�럩�궋
			String file_path = String.valueOf(newfile);
			//�뜝�럥�냱�뜝�럩逾ч뇦猿뗫윥餓λ뜉�삕�뜝�룞�삕占쎌궋�뜝�럡援�
			//�뜝�럡源삣뜝�럩逾у뜝�럩�뮡�뜝�럥援죆b�뜝�럥�뱺 �뜝�룞�삕�뜝�럩�궋
			//�뜝�럥�몥�뜝�럩逾졾뜝�럡�댉 �뜝�럥占쎈쵓�삕占쎌깚(com_num, name �뜝�룞�삕 tempInsert�뜝�럥�뱺�뜝�럡�맋 嶺뚯쉻�삕�뜝�럩�젧, file_name �뜝�룞�삕 createFilePath.java�뜝�럥�뱺�뜝�럡�맋 嶺뚯쉻�삕�뜝�럩�젧)
			cloudDB.setFile_size((int)newfile.length());
			cloudDB.setFile_path(file_path);
			//�뜝�럥�몥�뜝�럩逾졾뜝�럡�댉 �뜝�럥占쎈쵓�삕占쎌깚 �뜝�럡援�
			//DB insert
			String folder = request.getParameter("folder");
			int filecheck = cloud.cloudInsert(cloudDB, folder);
			if(filecheck == 0){
				return "/cloudview/uploadForm.jsp?filecheck="+cloudDB.getFile_name();
			}
		
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

/*?占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�?(xxxxxx)com_num(xxxx), mem_num(xxxxxx), file�뵓怨뺣쐡占쎄퉰(xxxxxx)
?占쎈쐻占쎈짗占쎌굲?占쎈쐻占쎈짗占쎌굲 占쎈쐻�뜝占�??占쎈쐻占쎈짗占쎌굲 ?占쎈쐻占쎈짗占쎌굲?占쎈쐻占쎈짗占쎌굲?占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�? ?占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�?(milli)*/