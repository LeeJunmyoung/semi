package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Com_check implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String email  =(String) request.getSession().getAttribute("email");
		int com_num = (int)request.getSession().getAttribute("com_num");
	System.out.println(com_num);
		if(email.equals("admin@admin.com")){
			return "/admin/admin_main.jsp";
		}
		
		else{
			if(com_num == 0 ){
				return "/company/mainForm.jsp";
			}else if(com_num<0){
				// 승인 안났을경우
				return "/temp_accept_page/wait_accept_company.jsp";
				
			}
			
			}
		
		return "/page_layout/temp_home.jsp";
	}

}
