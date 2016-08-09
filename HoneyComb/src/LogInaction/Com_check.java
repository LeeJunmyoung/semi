package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogInDB.LogOnDBBean;
import LogInDB.LogOnDataBean;

public class Com_check implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String email  =(String) request.getSession().getAttribute("email");
		int com_num = (int)request.getSession().getAttribute("com_num");
		int mem_num =(int)request.getSession().getAttribute("mem_num");
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
		

LogOnDBBean ldbb = LogOnDBBean.getInstance();
LogOnDataBean Logindata = new LogOnDataBean();

Logindata = ldbb.User_Inform(mem_num);


request.getSession().setAttribute("mem_num", Logindata.getMem_num());
request.getSession().setAttribute("com_num", Logindata.getCom_num());
request.getSession().setAttribute("com_dept_num", Logindata.getCom_dept_num());
request.getSession().setAttribute("com_pos_num", Logindata.getCom_pos_num());
request.getSession().setAttribute("name", Logindata.getName());
request.getSession().setAttribute("phone_num", Logindata.getPhone_num());
request.getSession().setAttribute("com_name", Logindata.getCom_name());
request.getSession().setAttribute("com_dept_name", Logindata.getCom_dept_name());
request.getSession().setAttribute("com_pos_name", Logindata.getCom_pos_name());

		
		return "/page_layout/temp_home.jsp";
	}

}
