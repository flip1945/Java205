package member.dto;

// 빈즈 클래스 생성
public class Member {
	// 변수는 모두 private 처리
	private String id;
	private String pw;
	private String name;
	private String regDate;
	
	// beans 클래스는 기본 생성자 필수
	public Member() {}
	
	public Member(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public Member(String id, String pw, String name, String regDate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.regDate = regDate;
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return this.pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegDate() {
		return this.regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
}
