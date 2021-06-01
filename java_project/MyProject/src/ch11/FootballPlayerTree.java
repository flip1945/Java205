
package ch11;

import java.util.Set;
import java.util.TreeSet;

public class FootballPlayerTree {

	public static void main(String[] args) {
		// 중복 여부를 compareTo 메소드를 사용해 판단
		Set<FootballPlayer> players = new TreeSet<FootballPlayer>();

		players.add(new FootballPlayer("홍길동", 10, "서울FC", 22));
		players.add(new FootballPlayer("이순신", 11, "서울FC", 24));
		players.add(new FootballPlayer("이순신", 8, "서울FC", 24));
		players.add(new FootballPlayer("강감찬", 1, "서울FC", 25));
		players.add(new FootballPlayer("정약용", 2, "서울FC", 28));
		players.add(new FootballPlayer("권 율", 3, "서울FC", 21));
		players.add(new FootballPlayer("권 민", 4, "서울FC", 29));
		players.add(new FootballPlayer("손흥민", 5, "서울FC", 25));
		players.add(new FootballPlayer("손흥민", 8, "서울FC", 25));
		
		for(FootballPlayer player : players) {
			System.out.println(player);
		}
	}
}
