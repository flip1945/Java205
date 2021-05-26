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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void hi() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다. " + this.age + "살 입니다.");
		System.out.println();
	}
}
