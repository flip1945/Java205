package guest.domain;

import java.util.List;

public class MessageListView {

	private List<Message> messageList; // 게시물 Message 객체 3개
	private int messageTotalCount; // 전체 게시물의 개수
	private int currentPageNumber; // 현재 페이지 번호
	private int pageTotalCount; // 페이지의 개수
	private int messageCountPerPage; // 한 페이지에 표현할 메세지의 개수
	private int firstRow;
	private int endRow;

	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNumber,
			int messageCountPerPage, int firstRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		this.pageTotalCount = calPageTotalCount();
	}

	private int calPageTotalCount() {
		if (this.messageTotalCount == 0) {
			return 0;
		}
		return (int) ((this.messageTotalCount - 1) / this.messageCountPerPage) + 1;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	@Override
	public String toString() {
		return "MessageListView [messageList=" + messageList + ", messageTotalCount=" + messageTotalCount
				+ ", currentPageNumber=" + currentPageNumber + ", pageTotalCount=" + pageTotalCount
				+ ", messageCountPerPage=" + messageCountPerPage + ", firstRow=" + firstRow + ", endRow=" + endRow
				+ "]";
	}
}
