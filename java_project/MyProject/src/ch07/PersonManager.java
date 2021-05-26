package ch07;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person("홍길동", "901218-1234567"));
		people.add(new Male("이순신", "801212-1424147", "축구"));
		people.add(new Male("강감찬", "941212-1424147", "농구"));
		people.add(new Female("유관순", "801111-2424147", "독서"));
		people.add(new Female("이선덕", "001111-2424147", "걷기"));
		
		for (Person person : people) {
			person.hi();
		}		

	}

}
