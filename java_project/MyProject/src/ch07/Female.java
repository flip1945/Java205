package ch07;

public class Female extends Person {
	private String hobby;

	public Female(String name, int age, String id, String hobby) {
		super(name, age, id);
		this.hobby = hobby;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public void hi() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다. " + this.age + "살 입니다.");
		System.out.println("저는 여자이고, 좋아하는 취미는 " + this.hobby + "입니다.");
		System.out.println();
	}
}
