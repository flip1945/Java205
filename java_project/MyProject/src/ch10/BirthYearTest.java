package ch10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BirthYearTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int birthYear = 0;

		while (birthYear == 0) {
			try {
				System.out.print("태어난 년도를 입력해주세요 : ");
				birthYear = scanner.nextInt();
				System.out.println("태어난 년도는 " + birthYear + "년입니다.");
			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("입력 받은 데이터는 숫자가 아닙니다.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(birthYear);
		
		scanner.close();
	}
}
