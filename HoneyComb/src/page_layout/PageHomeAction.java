package page_layout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageHomeAction implements PageFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		
		return "/page_layout/home.jsp";

	} // String requestPro end

} // class NoticeMainAction implements FormAction end
