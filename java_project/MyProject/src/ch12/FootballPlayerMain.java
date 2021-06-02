
package ch12;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class FootballPlayerMain {

	public static void main(String[] args) {
		// 중복 판단 하지 않고, 순서대로 입력 받음
		// 축구 선수들을 리스트에 저장
		List<FootballPlayer> players = new ArrayList<FootballPlayer>();
		
		players.add(new FootballPlayer("홍길동", 10, "서울FC", 22));
		players.add(new FootballPlayer("이순신", 11, "서울FC", 24));
		players.add(new FootballPlayer("이순신", 8, "서울FC", 24));
		players.add(new FootballPlayer("강감찬", 1, "서울FC", 25));
		players.add(new FootballPlayer("정약용", 2, "서울FC", 28));
		players.add(new FootballPlayer("권 율", 3, "서울FC", 21));
		players.add(new FootballPlayer("권 민", 4, "서울FC", 29));
		players.add(new FootballPlayer("손흥민", 5, "서울FC", 25));
		players.add(new FootballPlayer("손흥민", 8, "서울FC", 25));
		
		try {
			// 인스턴스를 ser 파일에 쓰기
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("FootballPlayer.ser"));
			out.writeObject(players);
			out.close();
			
			// 인스턴스를 ser 파일에서 읽기
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("FootballPlayer.ser"));
			@SuppressWarnings("unchecked")
			List<FootballPlayer> newPlayers = (ArrayList<FootballPlayer>) in.readObject();
			
			Collections.sort(newPlayers);
			
			for (FootballPlayer player : newPlayers) {
				System.out.println(player);
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
