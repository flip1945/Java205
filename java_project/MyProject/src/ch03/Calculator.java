package ch03;

import java.lang.Math;
import java.util.Scanner;

public class Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	}
	
	public int mul(int a, int b) {
		return a * b;
	}
	
	public int div(int a, int b) {
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
		System.out.println("두 숫자의 나누기의 몫 : " + cal.div(a, b));
		System.out.println();
		
		System.out.printf("첫 번째 숫자의 원 둘레 : %.02f\n", cal.getCircumference((double)a));
		System.out.printf("첫 번째 숫자의 원 넓이 : %.02f\n", cal.getCircleArea((double)a));
		System.out.println();
		
		System.out.printf("두 번째 숫자의 원 둘레 : %.02f\n", cal.getCircumference((double)b));
		System.out.printf("두 번째 숫자의 원 넓이 : %.02f\n", cal.getCircleArea((double)b));
	}

}
