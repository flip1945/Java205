package ch10;

public class UserId {
	private String id;
	
	public UserId() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) throws BadIdInputException {
		userIdCheck(id);
		this.id = id;
	}

	private void userIdCheck(String id) throws BadIdInputException {
		if (id.matches(".*[^\\w].*") || id.isEmpty()) {
			throw new BadIdInputException("[에러] 올바르지 않은 id입니다. 다시 입력해주세요.");
		}
	}
}
