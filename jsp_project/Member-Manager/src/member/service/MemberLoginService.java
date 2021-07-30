package member.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.util.ConnectionProvider;
import member.dao.MemberDao;
import member.dto.Member;
import util.CookieBox;

public class MemberLoginService {
	
	private MemberLoginService() {}
	private static MemberLoginService service = new MemberLoginService();
	public static MemberLoginService getInstance() {
		return service;
	}
	
	public void loginMember(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		boolean isLogin = false;
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String rememId = request.getParameter("rememId");
		
		Connection conn = null;
		MemberDao dao = null;
		
		if (userId != null && userPw != null && userId.trim().length() > 2 && userPw.trim().length() > 2) {
			try {
				conn = ConnectionProvider.getConnection();
				dao = MemberDao.getInstance();
				
				Member member = dao.getMemberByIdPw(conn, userId, userPw);
				
				if (member != null) {
					// 회원의 정보를 Session 객체에 저장
					session.setAttribute("loginInfo", member.toLoginInfo());
					isLogin = true;
				}
				
				if (rememId != null && rememId.equals("on")) {
					response.addCookie(CookieBox.makeCookie("rememId", userId, "/", 60*60*24*365));
				} else {
					response.addCookie(CookieBox.makeCookie("rememId", userId, "/", 0));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("isLogin", isLogin);
	}

}
