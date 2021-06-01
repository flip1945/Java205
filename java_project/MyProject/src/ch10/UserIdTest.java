package ch10;

import java.util.Scanner;

public class UserIdTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		UserId user1 = new UserId();

		while (user1.getId() == null) {
			try {
				System.out.print("id를 입력해주세요 : ");
				String id = scanner.nextLine();
				user1.setId(id);
				System.out.println("올바른 id입니다. 종료합니다.");
			} catch (BadIdInputException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(user1.getId());
		scanner.close();
	}
}
