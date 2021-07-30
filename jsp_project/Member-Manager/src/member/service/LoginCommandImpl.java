package member.service;

import javax.servlet.http.HttpServletRequest;

public class LoginCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		
		return "/member/members_LoginForm.jsp";
	}

}