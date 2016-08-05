package com_complete;

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



public class Complete_Controller extends HttpServlet {

	private Map commandMap = new HashMap();
	// properties占쏙옙占쏙옙 占쏙옙占쏙옙

	public void init(ServletConfig config) throws ServletException {

		String props = config.getInitParameter("com_Controller");
		// web.xml占쏙옙占쏙옙 propertyConfig占쏙옙 占쌔댐옙占싹댐옙 init-param 占쏙옙占쏙옙 占싻억옙占�
		Properties pr = new Properties();
		// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 properties占쏙옙체占쏙옙 占쏙옙占쏙옙
		FileInputStream f = null;
	

		try {
			f = new FileInputStream(props);
			// commandHandlerURI.properties占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占싻억옙占�
			pr.load(f);
			// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 properties占쏙옙체占쏙옙 占쏙옙占쏙옙
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ex) {
				}
		}

		Iterator keyIter = pr.keySet().iterator();

		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String className = pr.getProperty(command);

			try {
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				throw new ServletException(e);
			} catch (InstantiationException e) {
				throw new ServletException(e);
			} catch (IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// jsp form占쏙옙 method占쌈쇽옙占쏙옙 get占쏙옙 占쏙옙占�
		requestPro(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// jsp form占쏙옙 method占쌈쇽옙占쏙옙 post占쏙옙 占쏙옙占�
		requestPro(request, response);
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String view = null;
		CommandAction com = null;

		try {
			String command = request.getRequestURI();
			// http://localhost:8888 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占�
			if (command.indexOf(request.getContextPath()) == 0) {
				// 占쏙옙占쏙옙占쏙옙트 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙罐占� command占쏙옙 占쏙옙占쏙옙
				command = command.substring(request.getContextPath().length());
			}
			
			
			
			com = (CommandAction) commandMap.get(command);
			view = com.requestPro(request, response);
		} catch (Throwable e) {
			throw new ServletException(e);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
