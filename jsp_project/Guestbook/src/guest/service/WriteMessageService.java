package guest.service;

import java.sql.Connection;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageRequest;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class WriteMessageService {
	
	private WriteMessageService() {}
	
	private static WriteMessageService service = new WriteMessageService();
	
	public static WriteMessageService getInstance() {
		return service;
	}

	// 메세지를 DB에 쓰고 처리된 결과를 생성
	public int writeMessage(MessageRequest requestMessage) {
		int resultCnt = 0;
		
		// 트랜젝션 처리를 위해서 생성
		Connection conn = null;
		MessageDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			// AutoCommit의 기본값 : true
			// 프로그래머가 Java에서 트랜젝션 처리를 하려면 false로 바꿔줘야 함
			conn.setAutoCommit(false);
			
			Message message = requestMessage.toMessage();
			
			resultCnt = dao.writeMessage(conn, message);
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
		} finally {
			JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}
}
