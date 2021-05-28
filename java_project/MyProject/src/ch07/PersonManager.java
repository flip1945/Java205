package ch07;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person("홍길동", "901218-1234567"));
		people.add(new Male("이순신", "151212-3424147", "축구"));
		people.add(new Male("강감찬", "941212-1424147", "농구"));
		people.add(new Female("유관순", "801011-2424147", "독서"));
		people.add(new Female("이선덕", "000911-2424147", "걷기"));
		people.add(new Female("이세종", "210111-4424147", "자기"));
		
		for (Person person : people) {
			person.hi();
		}
		
//		Test
		System.out.println(((Male)people.get(2)).getSport());

	}

}
