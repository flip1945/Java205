package service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateService {

	public String getDate(HttpServletRequest request) {
		String resultUri = "/WEB-INF/views/date.jsp";
		
		request.setAttribute("result", new Date());
		
		return resultUri;
	}
}
