package LogInaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�α����������� �Ѿ�� ����������
public class LogIn implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		return"/view/logIn.jsp";
	}
}
