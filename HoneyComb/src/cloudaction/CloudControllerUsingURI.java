package cloudaction;

import java.io.*;
import java.net.URL;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CloudControllerUsingURI extends HttpServlet{

	private Map commandMap = new HashMap();

	public void init(ServletConfig config) throws ServletException {
		String props = config.getInitParameter("propertyConfig");
		Properties pr = new Properties();
		FileInputStream f = null;

		try {
			f = new FileInputStream(props);
			pr.load(f);
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		requestPro(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		requestPro(request, response);
	}
	private void requestPro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String view =  null;
	CommandActionCloud com = null;
		try{
			String command = request.getRequestURI();
			
			if(command.indexOf(request.getContextPath()) == 0){
				command = command.substring(request.getContextPath().length());
				System.out.println(command);
			}
			com = (CommandActionCloud)commandMap.get(command);
			view = com.requestPro(request, response);
		}catch(Throwable e){
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}