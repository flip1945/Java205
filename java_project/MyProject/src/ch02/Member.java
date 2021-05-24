package ch02;

public class Member {
	
	String name;
	int age;
	double height;
	boolean hasBook;
	
	public Member(String name, int age, double height, boolean hasBook) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.hasBook = hasBook;
	}
	
	public void printMyName() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age + "살");
		System.out.println("키 : " + this.height + "cm");
		System.out.println("책의 보유 여부 : " + this.hasBook);
	}
	
	public static void main(String[] args) {
		Member member = new Member("채호연", 10, 100.0, true);
		member.printMyName();
	}
	
}
