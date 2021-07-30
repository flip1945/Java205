package member.command;

import javax.servlet.http.HttpServletRequest;

public class ListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		
		return "/member/members_List.jsp";
	}

}
