package ch07;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person("홍길동", 20, "901218-1234567"));
		people.add(new Male("이순신", 30, "801212-1424147", "축구"));
		people.add(new Female("유관순", 30, "801111-2424147", "독서"));
		
		for (Person person : people) {
			person.hi();
		}		

	}

}
