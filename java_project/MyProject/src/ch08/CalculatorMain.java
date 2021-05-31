package ch08;

import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator cal1 = new ImplementCal();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자를 입력해주세요 : ");
		int n1 = s.nextInt();
		System.out.print("두 번째 숫자를 입력해주세요 : ");
		int n2 = s.nextInt();

		System.out.println("두 숫자의 합 : " + cal1.add(n1, n2));
		System.out.println("두 숫자의 차 : " + cal1.substract(n1, n2));
		System.out.println("두 숫자의 곱 : " + cal1.multiply(n1, n2));
		System.out.println("두 숫자의 나누기 : " + cal1.divide(n1, n2));

		s.close();
	}

}
