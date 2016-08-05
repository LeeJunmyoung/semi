package cloudaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clouddb.CloudDBBean;
import clouddb.CloudDataBean;

public class CloudForm implements CommandActionCloud{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		System.out.println("여기까지 오나??");
		CloudDBBean cloud = CloudDBBean.getInstance();
		CloudDataBean list = new CloudDataBean();
		List cloudList = new ArrayList();
		
		HttpSession session = request.getSession();
		/*comnum session ?��?��test*/
		System.out.println("cloudform.java com_num?�ֱ�");
		session.setAttribute("com_num", "44");
		/*comnum session ?��?��test*/
		
		int com_num = Integer.parseInt((String)session.getAttribute("com_num"));
		
		
		
		cloudList = cloud.cloudList(com_num);
		request.setAttribute("cloudList", cloudList);
				
		
		return "/cloudview/cloudForm.jsp";
	}

}
