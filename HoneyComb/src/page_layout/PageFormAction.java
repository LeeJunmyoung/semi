package page_layout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PageFormAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;

} // public interface NoticeFormAction end
