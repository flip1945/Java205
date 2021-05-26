package ch07;

public class Person {
	protected String name;
	protected int age;
	protected String id;
	
	public Person(String name, int age, String id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	public void hi() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다. " + this.age + "살 입니다.");
		System.out.println();
	}
}
