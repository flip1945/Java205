package guest.domain;

public class MessageRequest {

	private String guestname;
	private String password;
	private String message;

	public String getGuestname() {
		return this.guestname;
	}

	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// MessageRequest -> Message
	public Message toMessage() {
		return new Message(guestname, password, message);
	}

	@Override
	public String toString() {
		return "MessageRequest [guestname=" + guestname + ", password=" + password + ", message=" + message + "]";
	}
}