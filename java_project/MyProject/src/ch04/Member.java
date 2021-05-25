package ch04;

import java.util.Scanner;

public class Member {
	
	private static int curYear = 2021;
	
	public void checkFluVaccine(int birthYear) {
		int age = curYear - birthYear + 1;
		if ((age < 15) || (age >= 65)) {
			System.out.println("현재 나이 " + age + "살은");
			System.out.println("무료예방접종이 가능합니다.");
		} else {
			System.out.println("현재 나이 " + age + "살은");
			System.out.println("무료접종 대상이 아닙니다.");
		}
	}
	
	public void checkMeicalCheck(int birthYear) {
		int age = curYear - birthYear + 1;
		if (age >= 20) {
			if (curYear % 2 == birthYear % 2) {
				System.out.println("현재 나이 " + age + "살은");
				System.out.println("무료건강검진이 가능합니다.");
				if (age >= 40) {
					System.out.println("암 검사도 무료로 가능합니다.");
				}
			} else {
				System.out.println("현재 나이 " + age + "살은");
				System.out.println("무료건강검진 대상이 아닙니다.");
			}
		} else {
			System.out.println("20세 이상만 무료로 건강검진이 가능합니다.");
		}
	}
	
	public static int getIntInput(Scanner scanner) {
		return scanner.nextInt();
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Member member = new Member();
		
		while (true) {
			System.out.print("태어난 연도를 입력해주세요(0 입력시 종료) : ");
			int birthYear = getIntInput(scanner);
			
			if (birthYear == 0) {
				break;
			} else if (birthYear < 0) {
				System.out.println("올바른 년도를 입력해주세요.");
				continue;
			}
			
			System.out.println("---------독감예방 접종---------\n");
			member.checkFluVaccine(birthYear);
			System.out.println();
			
			System.out.println("---------건강검진 대상---------\n");
			member.checkMeicalCheck(birthYear);
			System.out.println();
		}

	}

}
