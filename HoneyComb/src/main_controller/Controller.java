package main_controller;

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


public class Controller extends HttpServlet {

	private Map commandMap = new HashMap();
	// properties���� ����

	public void init(ServletConfig config) throws ServletException {

		String props = config.getInitParameter("main_Controller");
		// web.xml���� propertyConfig�� �ش��ϴ� init-param ���� �о��
		Properties pr = new Properties();
		// ���������� ������ properties��ü�� ����
		FileInputStream f = null;
	

		try {
			f = new FileInputStream(props);
			// commandHandlerURI.properties������ ������ �о��
			pr.load(f);
			// ������ ������ properties��ü�� ����
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
		// jsp form�� method�Ӽ��� get�� ���
		requestPro(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// jsp form�� method�Ӽ��� post�� ���
		requestPro(request, response);
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String view = null;
		CommandAction com = null;

		try {
			String command = request.getRequestURI();
			// http://localhost:8888 �� ������ ���
			if (command.indexOf(request.getContextPath()) == 0) {
				// ������Ʈ ���� ������ ������ ��θ� command�� ����
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
