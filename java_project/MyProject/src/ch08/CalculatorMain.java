package ch08;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator cal1 = new ImplementCal();

		int a = 10;
		int b = 2;

		System.out.println(cal1.add(a, b));
		System.out.println(cal1.substract(a, b));
		System.out.println(cal1.multiply(a, b));
		System.out.println(cal1.divide(a, b));

	}

}
