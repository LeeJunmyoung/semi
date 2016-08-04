package cloudaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandActionCloud {

	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable;

	
}
