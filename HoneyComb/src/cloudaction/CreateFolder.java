//���� ������ִ±��
package cloudaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clouddb.CloudDBBean;
import clouddb.CloudDataBean;;


public class CreateFolder implements CommandActionCloud{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		CloudDBBean cloud = CloudDBBean.getInstance();
		CloudDataBean cloudPro = new CloudDataBean();
		HttpSession session  =  request.getSession();
		request.setCharacterEncoding("utf-8");
		//�ӽü���
		session.setAttribute("com_num", "1");
		session.setAttribute("name", "tester");
		//�ӽü��� ��
		
		
		
		//���� ���� �޾ƿ���
		String folder = (String)request.getParameter("folder");
		//������ �޾ƿ���
		String file_name = (String)request.getParameter("foldername");
		//com_num �޾ƿ���
		int com_num = Integer.parseInt((String)session.getAttribute("com_num"));
		//���� ���ε� �ѻ�� �޾ƿ���
		String file_uploader = (String)session.getAttribute("name");
		//cloudPro�� �ֱ�

		
		
		cloudPro.setFolder(folder);
		cloudPro.setFile_name(file_name);
		cloudPro.setCom_num(com_num);
		cloudPro.setFile_uploader(file_uploader);
		//�ߺ���� Ȯ��
		int folder_check = cloud.checkFolder(cloudPro);
		if(folder_check == 0){
			return"/cloudview/createfolder.jsp?name="+file_name;
		}
		//�ߺ���� Ȯ�� ��
	
		cloud.createFolder(cloudPro);
		return "/cloudview/createfolder.jsp";
	}

}
