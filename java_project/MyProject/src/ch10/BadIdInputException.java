package ch10;

public class BadIdInputException extends Exception {
	private static final long serialVersionUID = 1L;

	public BadIdInputException(String msg) {
		super(msg);
	}
}
