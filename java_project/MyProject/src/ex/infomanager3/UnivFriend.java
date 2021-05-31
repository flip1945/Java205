package ex.infomanager3;

public class UnivFriend extends Friend {

	// 대학 친구는 정공 정보를 가진다.
	private String major;

	public UnivFriend(String name, String phoneNumber, String address, String major) {
		super(name, phoneNumber, address);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("전   공 : " + this.major);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이   름 : " + this.name);
		System.out.println("전   공 : " + this.major);
	}
}
