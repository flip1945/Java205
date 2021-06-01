package ex;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	
	public static void main(String[] args) {
		
		// HashSet 저장 공간 생성
		HashSet<String> hashSet1 = new HashSet<String>();
		Set<SimpleNumber> hashSet2 = new HashSet<>();
		
		hashSet1.add("First");
		hashSet1.add("Second");
		hashSet1.add("Third");
		hashSet1.add("First");
		
		hashSet2.add(new SimpleNumber(10));
		hashSet2.add(new SimpleNumber(20));
		hashSet2.add(new SimpleNumber(20));
		hashSet2.add(new SimpleNumber(10));
		hashSet2.add(new SimpleNumber(15));
		hashSet2.add(new SimpleNumber(3));
		
		System.out.println("저장된 사이즈 : " + hashSet1.size());
		
		for (String str : hashSet1) {
			System.out.println(str);
		}
		
		System.out.println();
		
		for (SimpleNumber num : hashSet2) {
			System.out.println(num);
		}
	}
}

class SimpleNumber {
	int num;
		
	SimpleNumber(int num) {
		this.num = num;
	}
	
	@Override
	public int hashCode() {
		return this.num % 3;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof SimpleNumber) {
			return this.num == ((SimpleNumber)obj).num;			
		}
		return false;
	}

	@Override
	public String toString() {
		return String.valueOf(num);
	}
}
