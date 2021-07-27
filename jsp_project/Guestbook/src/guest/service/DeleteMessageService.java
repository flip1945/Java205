package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.exception.InvalidPasswordException;
import guest.exception.MessageNotFoundException;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class DeleteMessageService {

	private DeleteMessageService() {}
	private static DeleteMessageService service = new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return service;
	}

	public int deleteMessage(int mid, String pw) throws SQLException, MessageNotFoundException, InvalidPasswordException {
		int resultCnt = 0;

		Connection conn = null;
		MessageDao dao = null;

		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();

			conn.setAutoCommit(false);

			Message message = dao.getMessageByMid(conn, mid);

			if (message == null) {
				throw new MessageNotFoundException(mid);
			} else { // 일치하는 아이디 없음
				if (message.getPassword().equals(pw)) {
					resultCnt = dao.deleteMessage(conn, mid);
				} else { // 비밀번호 불일치
					throw new InvalidPasswordException();
				}
			}

			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} catch (MessageNotFoundException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}

		return resultCnt;
	}
}
