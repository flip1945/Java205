
package ch11;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class FootballPlayerMap {

	public static void main(String[] args) {
		// key, value 타입으로 저장
		Map<Integer, FootballPlayer> players = new HashMap<Integer, FootballPlayer>();
		
		players.put(10, new FootballPlayer("홍길동", 10, "서울FC", 22));
		players.put(11, new FootballPlayer("이순신", 11, "서울FC", 24));
		players.put(1, new FootballPlayer("강감찬", 1, "서울FC", 25));
		players.put(2, new FootballPlayer("정약용", 2, "서울FC", 28));
		players.put(3, new FootballPlayer("권 율", 3, "서울FC", 21));
		players.put(4, new FootballPlayer("권 민", 4, "서울FC", 29));
		players.put(8, new FootballPlayer("손흥민", 8, "서울F", 25));
		
		Iterator<Integer> itr = players.keySet().iterator();
		
		while (itr.hasNext()) {
			int key = itr.next();
			System.out.println(key + " " + players.get(key));
		}
	}
}
