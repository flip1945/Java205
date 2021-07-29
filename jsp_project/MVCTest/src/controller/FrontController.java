package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import service.Command;
import service.InvalidCommandImpl;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Command> commands = new HashMap<String, Command>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		commands.put("/", new GreetingCommandImpl());
//		commands.put("/greeting.do", new GreetingCommandImpl());
//		commands.put("/date.do", new DateCommandImpl());
		
		String configFile = config.getInitParameter("config");
		
		Properties properties = new Properties();
		
		FileInputStream fis = null;
		String configPath = config.getServletContext().getRealPath(configFile);
		
		try {
			fis = new FileInputStream(configPath);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator<Object> itr = properties.keySet().iterator();
		
		while (itr.hasNext()) {
			String key = (String)itr.next();
			String value = properties.getProperty(key);
			try {
				Command commandObj = (Command)Class.forName(value).newInstance();
				commands.put(key , commandObj);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandUri = request.getRequestURI();
		
		if (commandUri.indexOf(request.getContextPath()) == 0) {
			commandUri = commandUri.substring(request.getContextPath().length());
		}
		
		String viewPage = "/WEB-INF/views/default.jsp";
		Command command = commands.get(commandUri);
		
		if (command == null) {
			command = new InvalidCommandImpl();
		}
		
		viewPage = command.getPage(request);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
