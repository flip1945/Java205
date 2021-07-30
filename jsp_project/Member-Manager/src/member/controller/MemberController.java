package member.controller;

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

import member.service.Command;
import member.service.InvalidCommandImpl;

public class MemberController extends HttpServlet {
	private static final long serialVersionUID = -4388831328668416838L;
	
	private Map<String, Command> commands = new HashMap<String, Command>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("config");
		String configPath = config.getServletContext().getRealPath(configFile);
		FileInputStream fis = null;
		Properties properties = new Properties();
		
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
				Command command = (Command)Class.forName(value).newInstance();
				commands.put(key, command);
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandUri = request.getRequestURI();
		
		if (commandUri.indexOf(request.getContextPath()) == 0) {
			commandUri = commandUri.substring(request.getContextPath().length());
		}
		
		String viewPage = "/member/members_Index.jsp";
		Command command = commands.get(commandUri);
		
		if (command == null) {
			command = new InvalidCommandImpl();
		}
		
		viewPage = command.getPage(request);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
