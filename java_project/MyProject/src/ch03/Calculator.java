package ch03;

import java.util.Scanner;

public class Calculator {
	
	public long add(long a, int b) {
		return a + b;
	}
	
	public long sub(long a, int b) {
		return a - b;
	}
	
	public long mul(long a, int b) {
		return a * b;
	}
	
	public double div(double a, int b) {
		return a / b;
	}
	
	public double getCircumference(double r) {
		return 2 * r * Math.PI;
	}
	
	public double getCircleArea(double r) {
		return r * r * Math.PI;
	}
	
	public static int getIntInput(Scanner scanner) {
		return scanner.nextInt();
	}
	
	public static int getDoubleInput(Scanner scanner) {
		return scanner.nextInt();
	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		int a = getIntInput(scanner);
		System.out.print("두 번째 숫자를 입력하세요 : ");
		int b = getIntInput(scanner);
		
		System.out.println("두 숫자의 합 : " + cal.add(a, b));
		System.out.println("두 숫자의 차 : " + cal.sub(a, b));
		System.out.println("두 숫자의 곱 : " + cal.mul(a, b));
		System.out.printf("두 숫자의 나누기: %.2f", cal.div(a, b));
		System.out.println();
		System.out.println();
		
		System.out.print("반지름을 입력해주세요 : ");
		double r = getDoubleInput(scanner);
		
		System.out.printf("원의 둘레는 : %.2f입니다.\n", cal.getCircumference(r));
		System.out.printf("원의 넓이는 : %.2f입니다.\n", cal.getCircleArea(r));
	}

}
