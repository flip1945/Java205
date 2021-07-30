package member.command;

import javax.servlet.http.HttpServletRequest;

public class DeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {

		return "/member/members_Del.jsp";
	}

}
