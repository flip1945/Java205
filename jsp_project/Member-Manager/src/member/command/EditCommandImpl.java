package member.command;

import javax.servlet.http.HttpServletRequest;

public class EditCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {

		return "/member/members_EditForm.jsp";
	}

}
