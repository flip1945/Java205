package service;

import javax.servlet.http.HttpServletRequest;

public class InvalidService {

	public String getPage(HttpServletRequest request) {
		String resultUri = "/WEB-INF/views/default.jsp";
		
		return resultUri;
	}
}
