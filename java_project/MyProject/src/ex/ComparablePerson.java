package ex;

import java.util.TreeSet;

public class ComparablePerson {

	public static void main(String[] args) {
		
		TreeSet<Person> set = new TreeSet<Person>();
		
		set.add(new Person("Lee", 24));
		set.add(new Person("Hong", 29));
		set.add(new Person("Park", 21));
		
		for (Person p : set) {
			System.out.println(p.getName() + ", " + p.getAge());
		}
	}
}


class Person implements Comparable<Person> {
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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
	
	public void showData() {
		System.out.printf("%s, %d \n", this.name, this.age);
	}

	@Override
	public int compareTo(Person p) {
		return this.age - p.age;
//		return p.age - this.age;
	}
	
}
