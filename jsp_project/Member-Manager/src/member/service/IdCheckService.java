package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.util.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;

public class IdCheckService {
	
	private IdCheckService() {}
	private static IdCheckService service = new IdCheckService();
	public static IdCheckService getInstance() {
		return service;
	}

	public String idCheck(String memberId) {
		String result = "N";
		
		Connection conn = null;
		MemberDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			result = dao.getMemberById(conn, memberId) > 0 ? "N" : "Y";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return result;
	}
}
