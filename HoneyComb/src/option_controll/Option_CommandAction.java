/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package option_controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Option_CommandAction {
	String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}