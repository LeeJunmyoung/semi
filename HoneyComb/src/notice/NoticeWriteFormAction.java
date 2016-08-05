package notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeWriteFormAction implements NoticeFormAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 사용자 정보(이름) 속성 지정 필요
		
		return "/notice/noticeWriteForm.jsp";

	} // String requestPro end

} // class NoticeMainAction implements FormAction end
