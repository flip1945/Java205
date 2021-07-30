package member.service;

import javax.servlet.http.HttpServletRequest;

public class RegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		
		return "/member/members_RegForm.jsp";
	}

}
