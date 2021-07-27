package guest.service;

import java.sql.Connection;
import java.util.List;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageListView;
import guest.jdbc.ConnectionProvider;

public class MessageListService {
	
	private final int messageCountPerPage = 3;
	
	private MessageListService () {}
	private static MessageListService service = new MessageListService();
	public static MessageListService getInstance() {
		return service;
	}

	public MessageListView getMessageList(int pageNumber) {
		MessageListView listView = null;
		
		Connection conn = null;
		MessageDao dao =  null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			// 전체 게시물의 수
			int totalMessageCount = dao.getTotalMessageCount(conn);
			System.out.println("totalMessageCount : " + totalMessageCount);
			
			int firstRow = (pageNumber - 1) * messageCountPerPage;
			
			// 페이지에 표현할 메세지 객체들 List<Message>
			List<Message> messages = dao.getMessages(conn, firstRow, messageCountPerPage);
			System.out.println("messages : " + messages);
			
			listView = new MessageListView(
					messages,
					totalMessageCount, 
					pageNumber, 
					messageCountPerPage, 
					firstRow, 
					0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listView;
	}
}
