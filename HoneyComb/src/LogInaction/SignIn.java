package LogInaction;import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Signin.jsp�� �Ѿ�� ���� ������
public class SignIn implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		return"/view/signIn.jsp";
	}
}
