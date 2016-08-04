package LogInaction;
//회원가입
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogInDB.LogOnDBBean;
import LogInDB.LogOnDataBean;

public class SignInPro implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");
		LogOnDataBean member = new LogOnDataBean();
		LogOnDBBean dbpro =  LogOnDBBean.getInstance();
		
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String passwd=request.getParameter("passwd");
		String pnum1=request.getParameter("pnum1");
		String pnum2=request.getParameter("pnum2");
		String pnum3=request.getParameter("pnum3");
		String pnum=pnum1+pnum2+pnum3;

		
		member.setEmail(email);
		member.setName(name);
		member.setPasswd(passwd);
		member.setPhone_num(pnum);
		
		dbpro.insertMember(member);
		
		return"/index.jsp";
	}

}
