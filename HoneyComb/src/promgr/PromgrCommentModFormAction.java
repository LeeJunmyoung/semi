package promgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromgrCommentModFormAction implements PromgrFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		System.out.println("PromgrCommentModFormAction");
		
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		
		request.setAttribute("comment_num", comment_num);
		
		return "/promgr/promgrCommentModForm.jsp";

	} // String requestPro end

} // class ProMgrWriteProAction implements ProMgrFormAction end
