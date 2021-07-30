package member.command;

import javax.servlet.http.HttpServletRequest;

public class InvalidCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		
		return "/member/members_Index.jsp";
	}

}