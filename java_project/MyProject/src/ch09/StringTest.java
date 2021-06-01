package ch09;

import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String name = scanner.nextLine();
		
		if (name.isEmpty() || name.equals(" ")) {
			System.out.println("공백이 아닌 이름을 입력해주세요.");
		} else {
			System.out.println("정상적인 문자열입니다.");
		}
		
		scanner.close();
	}
}
