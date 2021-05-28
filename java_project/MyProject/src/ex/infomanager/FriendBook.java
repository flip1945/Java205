package ex.infomanager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FriendBook {

	public static void main(String[] args) {

		FriendInfoHandler handler = new FriendInfoHandler(100);
		int select = 0;

		try (Scanner s = new Scanner(System.in)) {
			while (true) {
				System.out.println("------ 메뉴 선택 ------");
				System.out.println("1. 고교 친구 정보 입력");
				System.out.println("2. 대학 친구 정보 입력");
				System.out.println("3. 전체 정보 출력");
				System.out.println("4. 기본 정보 출력");
				System.out.println("5. 프로그램 종료");
				System.out.println("---------------------");

				System.out.print("메뉴 >> ");
				select = Integer.parseInt(s.nextLine());

				switch (select) {
				case 1:
				case 2:
					handler.addFriend(select);
					break;
				case 3:
					handler.showAllData();
					break;
				case 4:
					handler.showBasicInfo();
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					throw new IllegalArgumentException("Unexpected value: " + select);
				}
			}

		} catch (InputMismatchException e) {
			System.err.println(e);
		}
	}

}
