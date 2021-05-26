package ch07;

import java.util.Calendar;

public class Person {
	protected String name;
	protected String id;
	protected int age;
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
		this.age = getAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	protected int getAge() {
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int birthYear = Integer.parseInt(id.substring(0, 2));
		
		birthYear += (birthYear <= thisYear - 2000) ? 2000 : 1900;
		
		return thisYear - birthYear + 1;
	}
	
	public void hi() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다. " + this.age + "살 입니다.");
		System.out.println();
	}
}
