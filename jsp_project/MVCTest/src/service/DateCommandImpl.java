package service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		
		request.setAttribute("result", new Date());
		
		return "/WEB-INF/views/date.jsp";
	}

}
