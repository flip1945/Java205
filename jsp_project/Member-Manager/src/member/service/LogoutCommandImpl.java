package member.service;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {

		return "/member/members_Logout.jsp";
	}

}
