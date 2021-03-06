package ch07;

public class Male extends Person {
	private String sport;
	
	public Male(String name, String id, String sport) {
		super(name, id);
		this.sport = sport;
	}

	public String getSport() {
		return this.sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}
	
	public void hi() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다. " + this.age + "살 입니다.");
		System.out.println("저는 남자이고, 좋아하는 운동은 " + this.sport + "입니다.");
		System.out.println();
	}
}
