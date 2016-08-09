/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package cal_Controll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cal_Controll.CommandAction;

public class ControllerUsingURI extends HttpServlet {
	private Map commandMap = new HashMap();

	public void init(ServletConfig config) throws ServletException {
		String props = config.getInitParameter("cal_propertyConfig");
		Properties pr = new Properties();
		FileInputStream f = null;

		try {
			f = new FileInputStream(props);
			pr.load(f);
		} catch (IOException arg17) {
			throw new ServletException(arg17);
		} finally {
			if (f != null) {
				try {
					f.close();
				} catch (IOException arg16) {
					;
				}
			}

		}

		Iterator keyIter = pr.keySet().iterator();

		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String className = pr.getProperty(command);

			try {
				Class e = Class.forName(className);
				Object commandInstance = e.newInstance();
				this.commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException arg18) {
				throw new ServletException(arg18);
			} catch (InstantiationException arg19) {
				throw new ServletException(arg19);
			} catch (IllegalAccessException arg20) {
				throw new ServletException(arg20);
			}
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.requestPro(request, response);
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = null;
		CommandAction com = null;

		try {
			String dispatcher = request.getRequestURI();
			if (dispatcher.indexOf(request.getContextPath()) == 0) {
				dispatcher = dispatcher.substring(request.getContextPath().length());
			}

			com = (CommandAction) this.commandMap.get(dispatcher);
			view = com.requestPro(request, response);
		} catch (Throwable arg5) {
			throw new ServletException(arg5);
		}

		RequestDispatcher dispatcher1 = request.getRequestDispatcher(view);
		dispatcher1.forward(request, response);
	}
}