package ex;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "일번");
		map.put(5, "오번");
		map.put(8, "팔번");
		
		System.out.println(map.get(5));
		System.out.println(map.get(1));
		System.out.println(map.get(8));
		System.out.println(map.get(10));
	}
}
