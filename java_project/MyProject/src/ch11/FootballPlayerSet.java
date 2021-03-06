
package ch11;

import java.util.Set;
import java.util.HashSet;

public class FootballPlayerSet {

	public static void main(String[] args) {
		// 중복 여부를 equals 메소드를 사용해 판단
		Set<FootballPlayer> players = new HashSet<FootballPlayer>();

		// 데이터 저장
//		players.add(new FootballPlayer("홍길동", 10, "서울FC", 22));
//		players.add(new FootballPlayer("이순신", 11, "서울FC", 24));
//		players.add(new FootballPlayer("이순신", 8, "서울FC", 24));
//		players.add(new FootballPlayer("강감찬", 1, "서울FC", 25));
//		players.add(new FootballPlayer("정약용", 2, "서울FC", 28));
//		players.add(new FootballPlayer("권 율", 3, "서울FC", 21));
//		players.add(new FootballPlayer("권 민", 4, "서울FC", 29));
//		players.add(new FootballPlayer("손흥민", 5, "서울FC", 25));
//		players.add(new FootballPlayer("손흥민", 5, "서울FC", 26));
//		players.add(new FootballPlayer("손흥민", 8, "서울FC", 25));
		
		players.add(new FootballPlayer("Son1", 7, "Tot", 27));
		players.add(new FootballPlayer("Park1", 7, "Man", 37));
		players.add(new FootballPlayer("Son1", 9, "Tot", 27));
		players.add(new FootballPlayer("Son2", 20, "Tot", 17));
		players.add(new FootballPlayer("Park2", 20, "Tot", 31));
		players.add(new FootballPlayer("Park2", 21, "Tot", 31));
		
		System.out.println("요소의 개수 : " + players.size());
		
		for(FootballPlayer player : players) {
			System.out.println(player);
		}
	}
}
