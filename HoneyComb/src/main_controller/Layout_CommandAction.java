package main_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Layout_CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;

}
