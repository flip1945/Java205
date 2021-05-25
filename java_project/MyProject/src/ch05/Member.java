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
		this.name = name;
		this.phoneNum = phoneNum;
		this.major = major;
		this.grade = grade;
		this.email = email;
	}

	public String getName() {
		return name;
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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void printMemberInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("전화번호 : " + this.phoneNum);
		System.out.println("전공 : " + this.major);
		System.out.println("학년 : " + this.grade);
		System.out.println("email : " + this.email);
		System.out.println("생일 : " + this.birthDay);
		System.out.println("주소 : " + this.address);
		System.out.println();
	}

	public static void main(String[] args) {
		Member member1 = new Member("홍길동", "010-1234-5678", "의적", 4, "hong@naver.com", "12.12", "한양");
		Member member2 = new Member("이순신", "010-4567-0123", "제독", 5, "Lee1234@naver.com");
		
		member1.printMemberInfo();
		member2.printMemberInfo();

	}

}
