package ch05;

public class Member {
	
	private String name;
	private String phoneNum;
	private String major;
	private int grade;
	private String email;
	private String birthDay;
	private String address;
	
	public Member(String name, String phoneNum, String major, int grade, String email, String birthDay, String address) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthDay = birthDay;
		this.address = address;
	}
	
	public Member(String name, String phoneNum, String major, int grade, String email) {
		this(name, phoneNum, major, grade, email, null, null);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void printMemberInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("전화번호 : " + this.phoneNum);
		System.out.println("전공 : " + this.major);
		System.out.println("학년 : " + this.grade);
		System.out.println("이메일 : " + this.email);
		
		if (this.birthDay == null) {
			System.out.println("생일 : 입력된 데이터가 없습니다.");
		} else {
			System.out.println("생일 : " + this.birthDay);
		}
		
		if (this.address == null) {
			System.out.println("주소 : 입력된 데이터가 없습니다.");
		} else {
			System.out.println("주소 : " + this.address);			
		}
		System.out.println();
	}

}
