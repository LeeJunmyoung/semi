package proMgr_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FormAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;

} // public interface CommandAction end
