package service;

import javax.servlet.http.HttpServletRequest;

public interface Command {

	public String getPage(HttpServletRequest request);

}
