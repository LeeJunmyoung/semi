package LogInaction;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LogInDB.LogOnDBBean;


public class LogInPro implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		
		LogOnDBBean dbPro=LogOnDBBean.getInstance();
		
		String email=request.getParameter("email");
		String passwd=request.getParameter("passwd");
		
		
		Vector member = dbPro.Checkmembers(email, passwd);
	
		if(member.isEmpty()){
			return"/view/logInpro.jsp";
		}else{
			session.setAttribute("mem_num", member.get(0));
			session.setAttribute("com_num", member.get(1));
			session.setAttribute("com_dept_num", member.get(2));
			session.setAttribute("com_pos_num", member.get(3));
			session.setAttribute("name", member.get(4));
			session.setAttribute("phone_num", member.get(5));
			
			
			session.setAttribute("email", email);
			
			/*session.setAttribute("com_name", member.get(6));
			session.setAttribute("com_dept_name", member.get(7));
			session.setAttribute("com_pos_name", member.get(8));*/
			
			session.setAttribute("profile_img", member.get(9)); // 추가
			
			
		}
		 
		return "/index.jsp";
	}

}
