package Main;

public class Contact {
	
	private String name;
	private String phoneNum;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	public Contact(String name, String phoneNum, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	} 
	
	public static void main(String[] args) {
		Contact contact = new Contact("채호연", "010-1234-5678", "coghdus1016@naver.com", "화성시", "2000-01-01", "비트캠프");
		
		contact.setAddress("화성시 융건로");
	}
}
