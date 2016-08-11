package memCheck_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandActionMemCheck {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;

}
