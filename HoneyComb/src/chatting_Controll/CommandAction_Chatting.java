package chatting_Controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction_Chatting {

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable;

	
}
