package ex.infomanager;

public class HighFriend extends Friend {

	// 고교 친구는 직장 정보를 추가적으로 가진다.
	private String job;

	public HighFriend(String name, String phoneNumber, String address, String job) {
		super(name, phoneNumber, address);
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("직   업 : " + this.job);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이   름 : " + this.name);
		System.out.println("직   업 : " + this.job);
	}
}
