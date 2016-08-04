package LogInaction;import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Signin.jsp로 넘어가기 위한 페이지
public class SignIn implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		return"/view/signIn.jsp";
	}
}
