package guest.exception;

public class InvalidPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidPasswordException() {
		super("비밀번호가 틀립니다.");
	}

}
