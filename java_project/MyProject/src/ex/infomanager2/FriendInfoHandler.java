package ex.infomanager2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FriendInfoHandler {

	// 저장 데이터(객체)를 배열로 저장하고 관리하는 기능을 가지는 클래스
	private Friend[] friends;
	private int numOfFriends;

	public FriendInfoHandler(int num) {
		this.friends = new Friend[num];
		this.numOfFriends = 0;
	}

	// 데이터의 입력 처리
	// 사용자로부터 친구의 정보를 입력 받아서 -> 인스턴스를 생성 -> 배열에 저장

	public void addFriend(int select) { // select -> 1(고교) or 2(대학)
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);

			System.out.print("이   름을 입력해주세요 : ");
			String name = br.readLine();
			System.out.print("전화번호를 입력해주세요 : ");
			String phoneNumber = br.readLine();
			System.out.print("주   소를 입력해주세요 : ");
			String address = br.readLine();

			if (select == 1) { // 고교 친구
				System.out.print("직   업을 입력해주세요 : ");
				String job = br.readLine();

				addFriendInfo(new HighFriend(name, phoneNumber, address, job));
			} else {
				System.out.print("전   공을 입력해주세요 : ");
				String major = br.readLine();

				addFriendInfo(new UnivFriend(name, phoneNumber, address, major));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// Friend 클래스를 상속하는 타입의 인스턴스를 받아 배열에 저장
	private void addFriendInfo(Friend friend) {
		friends[this.numOfFriends++] = friend;
		System.out.println("정보가 저장됐습니다.");
	}

	// 모든 데이터를 출력하는 메소드
	public void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다.");
		System.out.println("-----------------------");
		if (numOfFriends > 0) {
			for (int i = 0; i < numOfFriends; i++) {
				friends[i].showData();
				System.out.println("-----------------------");
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
	}

	// 모든 기본 정보를 출력하는 메소드
	public void showBasicInfo() {
		System.out.println("친구의 모든 기본 정보를 출력합니다.");
		System.out.println("-----------------------");
		if (numOfFriends > 0) {
			for (int i = 0; i < numOfFriends; i++) {
				friends[i].showBasicInfo();
				System.out.println("-----------------------");
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
	}
}
