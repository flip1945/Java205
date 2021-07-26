package member.dto;

public class LoginInfo {

	private String id;
	private String name;
	
	public LoginInfo(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", name=" + name + "]";
	}
}
