package ch13;

import java.util.Scanner;

public class HighLowGame {
	
	public static boolean check = false;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		CountDownThread ct = new CountDownThread();
		int randomNumber = (int)(Math.random() * 100) + 1;
		int answer = -1;
		
		ct.start();
		
		while (answer != randomNumber) {
			System.out.print("정답을 입력해주세요 : ");
			answer = scanner.nextInt();
			
			// 입력한 정답이 정답보다 크다면
			if (answer > randomNumber) {
				System.out.println("정답은 더 낮은 숫자입니다.");
			} else if (answer < randomNumber) {
				System.out.println("정답은 더 높은 숫자입니다.");
			}
		}
		
		check = true;
		System.out.println("정답입니다.");
		System.out.println("정답은 " + randomNumber + "입니다.");
		scanner.close();
	}
}
