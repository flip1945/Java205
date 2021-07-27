package guest.exception;

public class MessageNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public MessageNotFoundException(int mid) {
		super(mid + "번 게시물은 존재하지 않습니다.");
	}

}
